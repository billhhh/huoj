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

	private JudgeContext context;//����ֱ�ӽ�������ǰ̨��context����
	private PreparedStatement ps = null;//PreparedStatementԤ����ʽ���ٶȸ��죬��������set������ֵ
	private ResultSet rs=null;//���صĽ����
	private Connection ct=null;
	private List<StatusList> StatusItems;
	private int nowPage=1;
	private int pageNumber;
	private String successInfo;
	private String page="next";//statusҳ���ж�ǰ��ҳ
	
	private String outInfo;//����Ա�鿴��out����Ϣ
	private String stdOutInfo;//����Ա�鿴��stdout����Ϣ
	private String outSolutionId;//����ǰ̨��solutionId

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


	//��ʼ������
	protected boolean initConnection() {
		try {
			//�õ�����
			ct=new ConnDB().getConn();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	//�û��� submitpageҳ�� ������ύ����ť
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
			
			//����û��Ѿ���¼
			context.setUser_id((String) session.getAttribute("uid"));
			//System.out.println("user == "+context.getUser_id());
			
			
			
			//�ҳ���ǰ��Ŀ�� time_limit, memory_limit��������context��
			initConnection();
			String sql = "select time_limit, memory_limit from problem where problem_id = ?";
			try {
				ps = ct.prepareStatement(sql);
				ps.setInt(1, context.getProblem_id());
				rs = ps.executeQuery();
				if (rs.next() == false) {
					//�Ҳ�����Ŀ
				} else {
					context.setTime_limit(rs.getInt("time_limit"));
					context.setMemory_limit(rs.getInt("memory_limit"));
					
//					System.out.println("time_limit == "+context.getTime_limit());
//					System.out.println("memory_limit == "+context.getMemory_limit());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				
				//�ر���Դ
				this.close();
			}
			
			//System.out.println("����submitThread֮ǰ");
			
			submitThread.submitQueue.offer(context);
			//System.out.println("submitAction"+submitThread.submitQueue.isEmpty());
			
//			submitThread th=new submitThread(context);
//			th.run();
			
			successInfo="��Ŀ�ύ�ɹ���";
			
			return SUCCESS;
		}
	}
	
	
	public String statusList() throws Exception{
		//System.out.println("����statusList.action");
		int pageSize=100;   //ÿҳ��ʾ100����¼
		SolutionDAO solutiondao=new SolutionDAO();
		//���ҳ
		if(page.equals("next")){
			StatusItems=solutiondao.StatusList((this.getNowPage()-1)*pageSize,pageSize);
			nowPage++;
		}
		//��ǰ��ҳ	
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
		
		//ȡ����׼���
		ps = ct.prepareStatement(sql);
		ps.setInt(1, solutionid);
		rs = ps.executeQuery();
		if (rs.next()) {
			
			//System.out.println("��׼�����"+rs.getString(1));
			stdOutInfo=rs.getString(1);
		}
		
		
		String sql2 = "SELECT sourout FROM source_code where solution_id=?";
		//ȡ���û����
		ps = ct.prepareStatement(sql2);
		ps.setInt(1, solutionid);
		rs = ps.executeQuery();
		if (rs.next()) {
			
			//System.out.println("�û������"+rs.getString(1));
			outInfo=rs.getString(1);
		}
		
		//�ر���Դ
		this.close();
		
		return SUCCESS;
	}
	
	
	
	//�ر���Դ���������Ҫ!!!!
		public void close(){
			try {
				if(rs!=null){
					//�����Ϊnull����������
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
