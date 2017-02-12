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
	
	// myFile����������װ�ϴ����ļ�  
    private File myFile;  
      
    // myFileFileName����������װ�ϴ��ļ����ļ���  
    private String myFileFileName;  
  
    //���myFileֵ  
    public File getMyFile() {  
        return myFile;  
    }  
  
    //����myFileֵ  
    public void setMyFile(File myFile) {  
        this.myFile = myFile;  
    }  
  
    //���myFileFileNameֵ  
    public String getMyFileFileName() {  
        return myFileFileName;  
    }
  
    //����myFileFileNameֵ  
    public void setMyFileFileName(String myFileFileName) {  
        this.myFileFileName = myFileFileName;  
    }  
  
    public String execute() throws Exception {  
    	
    	//���û���ϴ��ļ��������
    	if(myFile == null)
        	return ERROR;
    	
    	String isNew=ServletActionContext.getRequest().getParameter("isnew");
//    	String isNew=(String) ServletActionContext.getRequest().getAttribute("haha");
    	//System.out.println("isNew == "+isNew);
    	
    	int id=1000;
    	//˵�����������Ŀ����Ҫ��ȷ��·��
    	if(isNew.equals("yes")){
			//�õ����һ��problemid
	    	ProblemDAO pDao=new ProblemDAO();
	    	addProblemDB();
	    	id=pDao.getLastId2();
    	}
		
    	
    	
    	//���upload�е���ʱ�ļ�
    	clear("F:\\Program Files\\apache-tomcat-7.0.37\\webapps\\huoj\\upload");
    	
        //����myFile����һ���ļ�������  
        InputStream is = new FileInputStream(myFile);
        
        // �����ϴ��ļ�Ŀ¼  
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
        //String uploadPath = ServletActionContext.getServletContext().getRealPath("e:/test");  
        
        // ����Ŀ���ļ�  
        File toFile = new File(uploadPath, this.getMyFileFileName());
        //File toFile = new File(uploadPath, "1025");
          
        // ����һ�������  
        OutputStream os = new FileOutputStream(toFile);
  
        //���û���  
        byte[] buffer = new byte[1024];
  
        int length = 0;  
  
        //��ȡmyFile�ļ������toFile�ļ���  
        while ((length = is.read(buffer)) > 0) {  
            os.write(buffer, 0, length);  
        }  
//        System.out.println("�ϴ��û�"+username);  
//        System.out.println("�ϴ��ļ���"+myFileFileName);  
//        System.out.println("�ϴ��ļ�����"+myFileContentType);  
        //�ر�������  
        is.close();  
          
        //�ر������  
        os.close();  
        
        String oldPath = "F:\\Program Files\\apache-tomcat-7.0.37\\webapps\\huoj\\upload\\"+this.getMyFileFileName();
        String newPath = "C:\\huoj\\word\\"+id+"\\";
        
        File file = new File(newPath);
		//����ļ��в����ھʹ���
        if(file.exists()==false){
        	file.mkdirs();
        }
        
        //�����ļ���ָ��Ŀ¼
        copyFile(oldPath,newPath);
        
        //����html�ļ�
        changeWord.change("C:\\huoj\\word\\"+id , "a.doc");
          
        return SUCCESS;  
    }
    
    
   //���upload�������ʱ�ļ�
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
            if (oldfile.exists()) { //�ļ�����ʱ 
            	
            	//ɾ��Ŀ���ļ�����ԭ�����ļ�
            	this.clear(newPath);
            	
                InputStream inStream = new FileInputStream(oldPath); //����ԭ�ļ� 
                FileOutputStream fs = new FileOutputStream(newPath+"a.doc"); 
                byte[] buffer = new byte[1444]; 
                
                while ( (byteread = inStream.read(buffer)) != -1) { 
                    //bytesum += byteread; //�ֽ��� �ļ���С 
                    //System.out.println(bytesum); 
                    fs.write(buffer, 0, byteread); 
                } 
                inStream.close(); 
            } 
        } 
        catch (Exception e) { 
            System.out.println("���Ƶ����ļ���������"); 
            e.printStackTrace(); 

        }
  	}
  	
  	
  	//��ʹ����word�ϴ��ķ�ʽҲ���ϴ����ݿ�
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
  		//��������ھͷ��ش���
  		if(file.exists()==false){
  			return ERROR;
  		}
  		
  		//�����ļ���web�ڲ��ļ���
  		String srcDirName = "C:\\huoj\\word\\"+pid;
        String destDirName = "F:\\Program Files\\apache-tomcat-7.0.37\\webapps\\huoj\\upload";

        CopyDirectory.copyDirectory(srcDirName, destDirName, true);
  		
  		
		return SUCCESS;
	}
  	
}  