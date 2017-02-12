package com.action;

import java.sql.Timestamp;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.dao.ContestDAO;
import com.model.Contest;
import com.opensymphony.xwork2.ActionSupport;
import com.util.ReadPropertiesFile;

//�̳�ActionSupport�࣬�ſ��ܴ�SUCCESS
public class contestAction extends ActionSupport{
	
	private List<Contest> contests; //������������get��set�����ͻ��Զ�����jspǰ̨
	private int pageNumber;
	private int nowPage=0;
	private int pageSize;
	
	public List<Contest> getContests() {
		return contests;
	}

	public void setContests(List<Contest> contests) {
		this.contests = contests;
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



	public int getPageSize() {
		return pageSize;
	}



	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}



	public String contestList() throws Exception{
		/*��ȡ��ҳ��С����*/
		String pageSizeString=ReadPropertiesFile.readPropertiesFile("contest_page_list");
		pageSize=Integer.valueOf(pageSizeString);
		
		//pageSize=10;
		
		/*���ݷ�ҳ��������*/
		ContestDAO contestdao=new ContestDAO();
		contests=contestdao.contestList(this.getNowPage()*pageSize,pageSize);
		//System.out.println(contests);
		
		
		String flag=ServletActionContext.getRequest().getParameter("flag");
		if(flag.equalsIgnoreCase("1")){
			//********************��ǩ********************
			//���������ǰʱ��
			//System.out.println(new java.util.Date());
			
			//java.util.Date CurDate=new java.util.Date();
			Timestamp CurDate = new Timestamp(System.currentTimeMillis());
			
			for(int  i = 0 ; i < contests.size(); i++) {
				//�����ֹʱ��������ʱ��֮�󣬾�����running����������ѽ�ֹ��Ҫ�Ƴ�
			    if(CurDate.after(contests.get(i).getEndTime())==true)
			    {
			    	//System.out.println("֮ǰ�� "+contests.get(i).getEndTime());
			    	//System.out.println("i == "+i);
			    	contests.remove(i);
			    	//System.out.println("֮�� "+contests.get(i).getEndTime());
			    	//System.out.println("size == "+contests.size());
			    	i--;
			    }
			}
		//contests.remove(1);
		}
		
		pageNumber=contestdao.contestCount();
		/*����ȡ��*/
		pageNumber=(int) Math.ceil((double)pageNumber/(double)pageSize);
		return SUCCESS;
	}
	
}
