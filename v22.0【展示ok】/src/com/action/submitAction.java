package com.action;

import java.sql.*;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SolutionDAO;
import com.model.JudgeContext;
import com.model.Problem;
import com.model.StatusList;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class submitAction extends ActionSupport{

	private JudgeContext context;//便于直接接受来自前台的context数据
	private PreparedStatement ps = null;//PreparedStatement预处理方式，速度更快，并可以用set方法赋值
	private ResultSet rs=null;//返回的结果集
	private Connection ct=null;
	private List<StatusList> StatusItems;
	private int nowPage=1;
	private int pageNumber;
	private String successInfo;
	private String page="next";//status页面判断前后翻页
	
	private String outInfo;//管理员查看的out的信息
	private String stdOutInfo;//管理员查看的stdout的信息
	private String outSolutionId;//接受前台的solutionId

	public String getOutSolutionId() {
		return outSolutionId;
	}


	public void setOutSolutionId(String outSolutionId) {
		this.outSolutionId = outSolutionId;
	}


	public String getOutInfo() {
		return outInfo;
	}


	public void setOutInfo(String outInfo) {
		this.outInfo = outInfo;
	}


	public String getStdOutInfo() {
		return stdOutInfo;
	}


	public void setStdOutInfo(String stdOutInfo) {
		this.stdOutInfo = stdOutInfo;
	}


	public String getPage() {
		return page;
	}


	public void setPage(String page) {
		this.page = page;
	}


	public String getSuccessInfo() {
		return successInfo;
	}


	public void setSuccessInfo(String successInfo) {
		this.successInfo = successInfo;
	}


	public int getPageNumber() {
		return pageNumber;
	}


	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}


	public int getNowPage() {
		return nowPage;
	}


	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}


	public List<StatusList> getStatusItems() {
		return StatusItems;
	}


	public void setStatusItems(List<StatusList> statusItems) {
		StatusItems = statusItems;
	}


	public JudgeContext getContext() {
		return context;
	}


	public void setContext(JudgeContext context) {
		this.context = context;
	}
	
	public String execute() throws Exception{
		return SUCCESS;
	}


	//初始化连接
	protected boolean initConnection() {
		try {
			//得到连接
			ct=new ConnDB().getConn();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	//用户在 submitpage页面 点击“提交”按钮
	public String submit() throws Exception{
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		Integer tmp=(Integer)session.getAttribute("pid");
		//System.out.println(s);
		
		context.setProblem_id(tmp);
		//System.out.println("pid==="+context.getProblem_id());
		
		//System.out.println("language == "+context.getLanguage());
		
		if(session.getAttribute("uid")==null){
			return "login";
		}else{
			
			//如果用户已经登录
			context.setUser_id((String) session.getAttribute("uid"));
			//System.out.println("user == "+context.getUser_id());
			
			
			
			//找出当前题目的 time_limit, memory_limit，并放入context中
			initConnection();
			String sql = "select time_limit, memory_limit from problem where problem_id = ?";
			try {
				ps = ct.prepareStatement(sql);
				ps.setInt(1, context.getProblem_id());
				rs = ps.executeQuery();
				if (rs.next() == false) {
					//找不到题目
				} else {
					context.setTime_limit(rs.getInt("time_limit"));
					context.setMemory_limit(rs.getInt("memory_limit"));
					
//					System.out.println("time_limit == "+context.getTime_limit());
//					System.out.println("memory_limit == "+context.getMemory_limit());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				
				//关闭资源
				this.close();
			}
			
			//System.out.println("进入submitThread之前");
			
			submitThread.submitQueue.offer(context);
			//System.out.println("submitAction"+submitThread.submitQueue.isEmpty());
			
//			submitThread th=new submitThread(context);
//			th.run();
			
			successInfo="题目提交成功！";
			
			return SUCCESS;
		}
	}
	
	
	public String statusList() throws Exception{
		//System.out.println("进入statusList.action");
		int pageSize=100;   //每页显示100条记录
		SolutionDAO solutiondao=new SolutionDAO();
		//向后翻页
		if(page.equals("next")){
			StatusItems=solutiondao.StatusList((this.getNowPage()-1)*pageSize,pageSize);
			nowPage++;
		}
		//向前翻页	
		else{
			System.out.println("pervious");
			StatusItems=solutiondao.StatusList((this.getNowPage()-3)*pageSize,pageSize);
			nowPage--;
		}
			
//		HttpServletRequest request=ServletActionContext.getRequest();
//		HttpServletResponse response=ServletActionContext.getResponse();
//		request.getRequestDispatcher("index.jsp").forward(request, response);
//		response.sendRedirect("index.jsp");
		
		return SUCCESS;
	}
	
	
	
	
	public String outView() throws Exception{
		
		initConnection();
		String sql = "SELECT stdout FROM source_code where solution_id=?";
		
		int solutionid=Integer.parseInt(outSolutionId);
		
		//取出标准输出
		ps = ct.prepareStatement(sql);
		ps.setInt(1, solutionid);
		rs = ps.executeQuery();
		if (rs.next()) {
			
			//System.out.println("标准输出："+rs.getString(1));
			stdOutInfo=rs.getString(1);
		}
		
		
		String sql2 = "SELECT sourout FROM source_code where solution_id=?";
		//取出用户输出
		ps = ct.prepareStatement(sql2);
		ps.setInt(1, solutionid);
		rs = ps.executeQuery();
		if (rs.next()) {
			
			//System.out.println("用户输出："+rs.getString(1));
			outInfo=rs.getString(1);
		}
		
		//关闭资源
		this.close();
		
		return SUCCESS;
	}
	
	
	
	//关闭资源，这个很重要!!!!
		public void close(){
			try {
				if(rs!=null){
					//最后置为null，垃圾回收
					rs.close();
					rs=null;
				}
				if(ps!=null){
					ps.close();
					ps=null;
				}
				if(ct!=null){
					ct.close();
					ct=null;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
}
