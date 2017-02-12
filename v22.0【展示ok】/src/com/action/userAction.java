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
	private List<Users> users; //������������get��set�����ͻ��Զ�����jspǰ̨
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
			errorInfo="��id�ѱ�ע��";
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
			errorInfo="�û������ڣ�";
			return ERROR;
		}
		else if(!userDao.findById(user.getUserId()).getPassword().equals(MD5Util.encode2hex(pwd))){
			errorInfo="�û��������������";
			return ERROR;
		}
		else{
			//�ɹ���¼����
			HttpSession session=ServletActionContext.getRequest().getSession();
			
			session.setAttribute("uid", user.getUserId());
			//System.out.println("uid=="+(String)session.getAttribute("uid"));
			
			PrivilegeId pid=new PrivilegeId(user.getUserId(),"administrator","N");
			//System.out.println(pDao.findById(pid));
			
			session.setAttribute("uprivilege", pDao.findById(pid));
			/*if(session.getAttribute("uprivilege")!=null){
				System.out.println("���գ���");
			}else{
				System.out.println("Ϊ�գ���");
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
	
	//�޸�����
	public String updatePwd() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();
		if(session.getAttribute("uid")==null){
			return "login";
		}else{
			Users userInfo=new UsersDAO().findById(session.getAttribute("uid").toString());
			if(MD5Util.encode2hex(oldPwd).equals(userInfo.getPassword())){
				userInfo.setPassword(MD5Util.encode2hex(user.getPassword()));
				new UsersDAO().save(userInfo);
				successInfo="�����޸ĳɹ�!";
				return SUCCESS;
			}else{
				errorInfo="ԭ�������!";
				return ERROR;
			}
			
		}
	}
	
	//�޸ĸ�����Ϣ
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
		/*��ȡ��ҳ��С����*/
		String pageSizeString=ReadPropertiesFile.readPropertiesFile("rank_page_list");
		pageSize=Integer.valueOf(pageSizeString);
		/*���ݷ�ҳ��������*/
		UsersDAO usersdao=new UsersDAO();
		
		//������������get��set�����ͻ��Զ�����jspǰ̨
		users=usersdao.rankList(this.getNowPage()*pageSize,pageSize);
		pageNumber=usersdao.usersCount();
		/*����ȡ��*/
		pageNumber=(int) Math.ceil((double)pageNumber/(double)pageSize);
		return SUCCESS;
	}
	
	  public String formatDouble(double s){
	      DecimalFormat fmt = new DecimalFormat("#.000");
	      return fmt.format(s);
	  }
	
	
}
