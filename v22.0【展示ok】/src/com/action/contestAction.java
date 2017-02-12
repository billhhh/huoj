package com.action;

import java.sql.Timestamp;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.dao.ContestDAO;
import com.model.Contest;
import com.opensymphony.xwork2.ActionSupport;
import com.util.ReadPropertiesFile;

//继承ActionSupport类，才可能传SUCCESS
public class contestAction extends ActionSupport{
	
	private List<Contest> contests; //这个变量如果有get和set方法就会自动传到jsp前台
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
		/*读取分页大小参数*/
		String pageSizeString=ReadPropertiesFile.readPropertiesFile("contest_page_list");
		pageSize=Integer.valueOf(pageSizeString);
		
		//pageSize=10;
		
		/*根据分页参数查找*/
		ContestDAO contestdao=new ContestDAO();
		contests=contestdao.contestList(this.getNowPage()*pageSize,pageSize);
		//System.out.println(contests);
		
		
		String flag=ServletActionContext.getRequest().getParameter("flag");
		if(flag.equalsIgnoreCase("1")){
			//********************标签********************
			//测试输出当前时间
			//System.out.println(new java.util.Date());
			
			//java.util.Date CurDate=new java.util.Date();
			Timestamp CurDate = new Timestamp(System.currentTimeMillis());
			
			for(int  i = 0 ; i < contests.size(); i++) {
				//如果截止时间在现在时间之后，就是在running，否则就是已截止，要移除
			    if(CurDate.after(contests.get(i).getEndTime())==true)
			    {
			    	//System.out.println("之前： "+contests.get(i).getEndTime());
			    	//System.out.println("i == "+i);
			    	contests.remove(i);
			    	//System.out.println("之后： "+contests.get(i).getEndTime());
			    	//System.out.println("size == "+contests.size());
			    	i--;
			    }
			}
		//contests.remove(1);
		}
		
		pageNumber=contestdao.contestCount();
		/*向上取整*/
		pageNumber=(int) Math.ceil((double)pageNumber/(double)pageSize);
		return SUCCESS;
	}
	
}
