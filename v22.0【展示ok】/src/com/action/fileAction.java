package com.action;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;
import java.io.InputStream;  
import java.io.OutputStream;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
  
import org.apache.struts2.ServletActionContext;  
  
import com.dao.ProblemDAO;
import com.model.Problem;
import com.opensymphony.xwork2.ActionSupport;  
  
public class fileAction extends ActionSupport {
	
	// myFile属性用来封装上传的文件  
    private File myFile;  
      
    // myFileFileName属性用来封装上传文件的文件名  
    private String myFileFileName;  
  
    //获得myFile值  
    public File getMyFile() {  
        return myFile;  
    }  
  
    //设置myFile值  
    public void setMyFile(File myFile) {  
        this.myFile = myFile;  
    }  
  
    //获得myFileFileName值  
    public String getMyFileFileName() {  
        return myFileFileName;  
    }
  
    //设置myFileFileName值  
    public void setMyFileFileName(String myFileFileName) {  
        this.myFileFileName = myFileFileName;  
    }  
  
    public String execute() throws Exception {  
    	
    	//如果没有上传文件，则错误
    	if(myFile == null)
        	return ERROR;
    	
    	String isNew=ServletActionContext.getRequest().getParameter("isnew");
//    	String isNew=(String) ServletActionContext.getRequest().getAttribute("haha");
    	//System.out.println("isNew == "+isNew);
    	
    	int id=1000;
    	//说明是新添加题目，主要是确定路径
    	if(isNew.equals("yes")){
			//得到最后一个problemid
	    	ProblemDAO pDao=new ProblemDAO();
	    	addProblemDB();
	    	id=pDao.getLastId2();
    	}
		
    	
    	
    	//清除upload中的临时文件
    	clear("F:\\Program Files\\apache-tomcat-7.0.37\\webapps\\huoj\\upload");
    	
        //基于myFile创建一个文件输入流  
        InputStream is = new FileInputStream(myFile);
        
        // 设置上传文件目录  
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
        //String uploadPath = ServletActionContext.getServletContext().getRealPath("e:/test");  
        
        // 设置目标文件  
        File toFile = new File(uploadPath, this.getMyFileFileName());
        //File toFile = new File(uploadPath, "1025");
          
        // 创建一个输出流  
        OutputStream os = new FileOutputStream(toFile);
  
        //设置缓存  
        byte[] buffer = new byte[1024];
  
        int length = 0;  
  
        //读取myFile文件输出到toFile文件中  
        while ((length = is.read(buffer)) > 0) {  
            os.write(buffer, 0, length);  
        }  
//        System.out.println("上传用户"+username);  
//        System.out.println("上传文件名"+myFileFileName);  
//        System.out.println("上传文件类型"+myFileContentType);  
        //关闭输入流  
        is.close();  
          
        //关闭输出流  
        os.close();  
        
        String oldPath = "F:\\Program Files\\apache-tomcat-7.0.37\\webapps\\huoj\\upload\\"+this.getMyFileFileName();
        String newPath = "C:\\huoj\\word\\"+id+"\\";
        
        File file = new File(newPath);
		//如果文件夹不存在就创建
        if(file.exists()==false){
        	file.mkdirs();
        }
        
        //复制文件到指定目录
        copyFile(oldPath,newPath);
        
        //生成html文件
        changeWord.change("C:\\huoj\\word\\"+id , "a.doc");
          
        return SUCCESS;  
    }
    
    
   //清除upload里面的临时文件
  	private void clear(String dir) {
  		File dirFile = new File(dir);
  		if (dirFile.exists() && dirFile.isDirectory()) {
  			File[] fileList = dirFile.listFiles();
  			int n = fileList.length;
  			for (int i = 0; i < n; i++)
  				fileList[i].delete();
  		}
  	}
  	
  	
  	
  	private void copyFile(String oldPath,String newPath){
  		try { 
            //int bytesum = 0; 
            int byteread = 0;
            File oldfile = new File(oldPath); 
            if (oldfile.exists()) { //文件存在时 
            	
            	//删掉目标文件夹中原来的文件
            	this.clear(newPath);
            	
                InputStream inStream = new FileInputStream(oldPath); //读入原文件 
                FileOutputStream fs = new FileOutputStream(newPath+"a.doc"); 
                byte[] buffer = new byte[1444]; 
                
                while ( (byteread = inStream.read(buffer)) != -1) { 
                    //bytesum += byteread; //字节数 文件大小 
                    //System.out.println(bytesum); 
                    fs.write(buffer, 0, byteread); 
                } 
                inStream.close(); 
            } 
        } 
        catch (Exception e) { 
            System.out.println("复制单个文件操作出错"); 
            e.printStackTrace(); 

        }
  	}
  	
  	
  	//即使是用word上传的方式也得上传数据库
  	private void addProblemDB() throws IOException{
  		Problem problem=new Problem();
  		ProblemDAO pDao=new ProblemDAO();
		problem.setDefunct("N");
		problem.setInDate(new Timestamp(new Date().getTime()));
		problem.setSpj((short) 0);
		
		problem.setTitle("uploadTest");
		problem.setTimeLimit(1000);
		problem.setMemoryLimit(128000);
		
		pDao.save(problem);
  	}
  	
  	
  	public String viewWord() throws Exception{
		
  		String pid=ServletActionContext.getRequest().getParameter("pid");
  		
  		//System.out.println(pid);
  		
  		File file = new File("C:\\huoj\\word\\"+pid);
  		//如果不存在就返回错误
  		if(file.exists()==false){
  			return ERROR;
  		}
  		
  		//复制文件到web内部文件夹
  		String srcDirName = "C:\\huoj\\word\\"+pid;
        String destDirName = "F:\\Program Files\\apache-tomcat-7.0.37\\webapps\\huoj\\upload";

        CopyDirectory.copyDirectory(srcDirName, destDirName, true);
  		
  		
		return SUCCESS;
	}
  	
}  