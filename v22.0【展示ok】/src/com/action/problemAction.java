package com.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.dao.ProblemDAO;
import com.model.Problem;
import com.opensymphony.xwork2.ActionSupport;
import com.util.ReadPropertiesFile;

import freemarker.core.ReturnInstruction.Return;

import java.util.*;

import org.apache.struts2.ServletActionContext;

import com.jspsmart.upload.*;

public class problemAction extends ActionSupport {
	private Problem problem;
	private String successInfo;
	private int nowPage=1;
	private int pageNumber;
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	private List<Problem> problems;
	private StringBuffer pageList=new StringBuffer();
	
	public StringBuffer getPageList() {
		return pageList;
	}

	public void setPageList(StringBuffer pageList) {
		this.pageList = pageList;
	}

	public List<Problem> getProblems() {
		return problems;
	}

	public void setProblems(List<Problem> problems) {
		this.problems = problems;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public String getSuccessInfo() {
		return successInfo;
	}

	public void setSuccessInfo(String successInfo) {
		this.successInfo = successInfo;
	}

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	public String execute(){
		return SUCCESS;
	}
	
	public String addProblem() throws Exception{
		ProblemDAO pDao=new ProblemDAO();
		problem.setDefunct("N");
		problem.setInDate(new Timestamp(new Date().getTime()));
		problem.setSpj((short) 0);
		
		fileCreator fc=new fileCreator();
		String foldPath="D:\\data\\"+(pDao.getLastId2()+1);
		
		fc.creatFiles(foldPath, "\\data.in", problem.getTestInput());
		fc.creatFiles(foldPath, "\\data.out", problem.getTestOutput());
		
		problem.setInputPath(foldPath);
		problem.setOutputPath(foldPath);
		
		pDao.save(problem);
		successInfo="添加问题成功！";
		return SUCCESS;
	}
	
	
	public String problemList() throws Exception{
		String pageSizeString=ReadPropertiesFile.readPropertiesFile("problem_page_size");
		int pageSize=Integer.valueOf(pageSizeString);
		ProblemDAO problemdao=new ProblemDAO();
		problems=problemdao.ProblemList((this.getNowPage()-1)*pageSize,pageSize);
		this.pageNumber=problemdao.problemCount();
		//System.out.println(pageNumber);
		/*向上取整*/
		pageNumber=(int) Math.ceil((double)pageNumber/(double)pageSize);
		/*Iterator<Problem> itr=problems.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next().getTitle());
		}*/
		return SUCCESS;
	}
	
	public String problemDetails() throws Exception{
		//System.out.println("问题id"+problem.getProblemId());
		problem=new ProblemDAO().findById(problem.getProblemId());
		//System.out.println(problem.getTitle());
		return SUCCESS;
	}
	
	
}
