package com.action;



import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.PrivilegeDAO;
import com.dao.ProblemDAO;
import com.dao.UsersDAO;
import com.model.PrivilegeId;
import com.model.Users;
import com.opensymphony.xwork2.ActionSupport;
import com.util.MD5Util;
import com.util.ReadPropertiesFile;

public class userAction extends ActionSupport{
	private Users user;
	private String errorInfo;
	private String oldPwd;
	private String successInfo;
	private List<Users> users; //这个变量如果有get和set方法就会自动传到jsp前台
	private int pageNumber;
	private int nowPage=0;
	private int pageSize;
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public String getSuccessInfo() {
		return successInfo;
	}

	public void setSuccessInfo(String successInfo) {
		this.successInfo = successInfo;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String execute() throws Exception{
		return SUCCESS;
	}
	
	public String regist() throws Exception{
		UsersDAO userDao=new UsersDAO(); 
		if(userDao.user_exist(user.getUserId())){
			errorInfo="该id已被注册";
			return ERROR;
		}else {
			user.setIp(userDao.getIp());
			user.setDefunct("N");
			Timestamp ts = new Timestamp(new Date().getTime());
			user.setSubmit(0);
			user.setSolved(0);
			user.setAccesstime(ts);
			user.setLanguage(1);
			user.setPassword(MD5Util.encode2hex(user.getPassword()));
			user.setRegTime(ts);
			user.setVolume(1);
			userDao.save(user);
			return SUCCESS;
		}
	}
	
	public String login() throws Exception{
		
		String pwd=user.getPassword();
		
		UsersDAO userDao =new UsersDAO();
		PrivilegeDAO pDao =new PrivilegeDAO();
		
		if(!userDao.user_exist(user.getUserId())){
			errorInfo="用户不存在！";
			return ERROR;
		}
		else if(!userDao.findById(user.getUserId()).getPassword().equals(MD5Util.encode2hex(pwd))){
			errorInfo="用户名或者密码错误！";
			return ERROR;
		}
		else{
			//成功登录进入
			HttpSession session=ServletActionContext.getRequest().getSession();
			
			session.setAttribute("uid", user.getUserId());
			//System.out.println("uid=="+(String)session.getAttribute("uid"));
			
			PrivilegeId pid=new PrivilegeId(user.getUserId(),"administrator","N");
			//System.out.println(pDao.findById(pid));
			
			session.setAttribute("uprivilege", pDao.findById(pid));
			/*if(session.getAttribute("uprivilege")!=null){
				System.out.println("不空！！");
			}else{
				System.out.println("为空！！");
			}*/
			
			user=userDao.findById(user.getUserId());
			user.setAccesstime(new Timestamp(new Date().getTime()));
			userDao.save(user);
			return SUCCESS;
		}
			
	}
	
	public String logout() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.removeAttribute("uid");
		session.removeAttribute("uprivilege");
		return SUCCESS;
	}
	
	public String userInfo() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();
		if(session.getAttribute("uid")==null){
			return "login";
		}else{
			user=new UsersDAO().findById(session.getAttribute("uid").toString());
			return SUCCESS;
		}
	}
	
	//修改密码
	public String updatePwd() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();
		if(session.getAttribute("uid")==null){
			return "login";
		}else{
			Users userInfo=new UsersDAO().findById(session.getAttribute("uid").toString());
			if(MD5Util.encode2hex(oldPwd).equals(userInfo.getPassword())){
				userInfo.setPassword(MD5Util.encode2hex(user.getPassword()));
				new UsersDAO().save(userInfo);
				successInfo="密码修改成功!";
				return SUCCESS;
			}else{
				errorInfo="原密码错误!";
				return ERROR;
			}
			
		}
	}
	
	//修改个人信息
	public String userInfoUpdate() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();
		UsersDAO userDao =new UsersDAO();
		if(session.getAttribute("uid")==null){
			return "login";
		}else{
			Users userIF=userDao.findById(session.getAttribute("uid").toString());
			userIF.setNick(user.getNick());
			userIF.setSchool(user.getSchool());
			userIF.setEmail(user.getEmail());
			userDao.save(userIF);
			return SUCCESS;
		}
	}
	
	public String rankList() throws Exception{
		/*读取分页大小参数*/
		String pageSizeString=ReadPropertiesFile.readPropertiesFile("rank_page_list");
		pageSize=Integer.valueOf(pageSizeString);
		/*根据分页参数查找*/
		UsersDAO usersdao=new UsersDAO();
		
		//这个变量如果有get和set方法就会自动传到jsp前台
		users=usersdao.rankList(this.getNowPage()*pageSize,pageSize);
		pageNumber=usersdao.usersCount();
		/*向上取整*/
		pageNumber=(int) Math.ceil((double)pageNumber/(double)pageSize);
		return SUCCESS;
	}
	
	  public String formatDouble(double s){
	      DecimalFormat fmt = new DecimalFormat("#.000");
	      return fmt.format(s);
	  }
	
	
}
