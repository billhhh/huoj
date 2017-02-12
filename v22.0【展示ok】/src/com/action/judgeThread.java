package com.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;

import com.model.Constants;

import com.model.JudgeContext;

public class judgeThread implements Runnable {

	public static BlockingQueue<JudgeContext> judgeQueue;
	//private JudgeContext context;
	private Connection ct=null;
	
	//��д���췽��
		public judgeThread(){
			try {
				//�õ�����
				ct=new ConnDB().getConn();
				//this.context=cont;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("�ѽ���judgeThread����");
		//System.out.println("judgeThread"+submitThread.submitQueue.isEmpty());
		while (true) {
			try {
				JudgeContext context = judgeQueue.take();
				
				//test compile
//				compile(context);
				
				
				//����Դ����
				if (compile(context)) {
					//ִ�б���õ�exe����
					execute(context);
					
					//�ж�out�����𣬴��ھͽ�����һ��
					if(isExist("C:\\huoj\\temp\\out.txt")==true){
						try {
							writeOut(context.getSolution_id());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	//���룬����Ҫ�ķ���
	private boolean compile(JudgeContext context) throws IOException, InterruptedException {
		//defaultDir   Ĭ�ϵ�temp·�����������
		String defaultDir = "C:\\huoj\\temp\\";
		clear(defaultDir);
		
		//defaultSrcPath   Ĭ�ϵ� c/c++ Դ�ļ�·��
		String defaultSrcPath = "C:\\huoj\\temp\\";
		//defaultExePath    Ĭ�ϵ� exe �ļ�·��
		String defaultExePath = "C:\\huoj\\temp\\main.exe";
		//defaultCmd   Ĭ�ϵ�gcc·��
		//String defaultCmd = "C:\\onlinejudge\\bin\\gcc\\bin\\";
		String defaultCmd = "";

		switch (context.getLanguage()) {
		case Constants.GCC:
			defaultSrcPath += "main.c";
			//defaultCmd += "gcc.exe";
			defaultCmd += "gcc";
			break;
			
		case Constants.GPLUSPLUS:
			defaultSrcPath += "main.cpp";
			//defaultCmd += "g++.exe";
			defaultCmd += "g++";
			break;
		}
		
		createSrcFile(defaultSrcPath, context.getSource());
		
		defaultCmd += " -o " + defaultExePath + " " + defaultSrcPath;

		Process process = Runtime.getRuntime().exec(defaultCmd);
		process.waitFor();
		File exeFile = new File(defaultExePath);

		if (exeFile.exists()) {
			updateResult(context.getSolution_id(), Constants.Running);
			return true;
		} else {
			updateResult(context.getSolution_id(), Constants.CompileError);
			InputStream istrm = process.getErrorStream();
			InputStreamReader isr = new InputStreamReader(istrm);
			BufferedReader br = new BufferedReader(isr);
			String strError = "", strLine;
			while ((strLine = br.readLine()) != null) {
				strError += strLine + "\n";
			}
			saveComplieInfo(context.getSolution_id(), strError);
			return false;
		}
	}
	
	
	
	//ִ���ļ�����������Ҫ��������
	private void execute(JudgeContext context) throws IOException, InterruptedException {
		//�൱�����ϣ�C:>judge.exe main.exe TimeLimit MemoryLimit data temp
		String cmd = "C:\\huoj\\bin\\judge.exe";
		cmd += " " + "C:\\huoj\\temp\\main.exe";
		cmd += " " + context.getTime_limit();
		cmd += " " + context.getMemory_limit();
		//cmd += " " + "C:\\onlinejudge\\data\\" + context.getProblem_id() + "\\";
		cmd += " " + "D:\\data\\" + context.getProblem_id() + "\\";
		cmd += " " + "C:\\huoj\\temp";
		Process process = Runtime.getRuntime().exec(cmd);
		process.waitFor();

		InputStream istrm = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(istrm);
		BufferedReader br = new BufferedReader(isr);
		int state = Constants.Running, time, memory;
		String strLine;
		if ((strLine = br.readLine()) != null && strLine.equals(Constants.strAccepted)) {
			state = Constants.Accepted;
			strLine = br.readLine();
			memory = Integer.parseInt(strLine);
			strLine = br.readLine();
			time = Integer.parseInt(strLine);
			
			updateResult(context.getSolution_id(), state, memory, time,context.getSource().length());
			updateProblem(context);
			updateUser(context);
			return;
		} else if (strLine.equals(Constants.strTimeLimit)) {
			state = Constants.TimeLimit;
		} else if (strLine.equals(Constants.strMemoryLimit)) {
			state = Constants.MemoryLimit;
		} else if (strLine.equals(Constants.strWrongAnswer)) {
			state = Constants.WrongAnswer;
		} else {
			state = Constants.RuntimeError;
		}
		
		updateResult(context.getSolution_id(), state);
	}
	
	
	
	private void updateResult(int solutionId, int result, int memory, int time,int codeLength) {
		PreparedStatement ps = null;
		String sql = "update solution set result = ?, memory = ?, time = ?, code_length = ? where solution_id = ?";
		try {
			ps = ct.prepareStatement(sql);
			ps.setInt(1, result);
			ps.setInt(2, memory);
			ps.setInt(3, time);
			ps.setInt(4, codeLength);
			ps.setInt(5, solutionId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	private void updateProblem(JudgeContext context) {
		//PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		String sql = "select max(accepted) from problem";
		
		try {
			ps1 = ct.prepareStatement(sql);
			rs = ps1.executeQuery();
			if (rs.next()) {
				sql = "update problem set accepted = ? where problem_id = ?";
				ps2 = ct.prepareStatement(sql);
				ps2.setInt(1, rs.getInt(1)+1);
				ps2.setInt(2, context.getProblem_id());
				ps2.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps1 != null) {
					ps1.close();
				}
				if (ps2 != null) {
					ps2.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	private void updateUser(JudgeContext context) {
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		String sql = "select max(solved) from users";
		try {
			ps1 = ct.prepareStatement(sql);
			rs = ps1.executeQuery();
			if (rs.next()) {
				sql = "update users set solved = ? where user_id = ?";
				ps2 = ct.prepareStatement(sql);
				ps2.setInt(1, rs.getInt(1)+1);
				ps2.setString(2, context.getUser_id());
				ps2.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (ps1 != null) {
					ps1.close();
				}
				if (ps2 != null) {
					ps2.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	//���temp�������ʱ�ļ�
	private void clear(String dir) {
		File dirFile = new File(dir);
		if (dirFile.exists() && dirFile.isDirectory()) {
			File[] fileList = dirFile.listFiles();
			int n = fileList.length;
			for (int i = 0; i < n; i++)
				fileList[i].delete();
		}
	}
	
	
	//������ʱ�����ļ�
	private void createSrcFile(String path, String src) throws IOException {
		File srcFile = new File(path);
		srcFile.createNewFile();
		FileWriter fileWriter = new FileWriter(srcFile);
		fileWriter.write(src, 0, src.length());
		fileWriter.close();
	}
	
	
	//�޸�statusҳ��������б�
	private void updateResult(int solutionId, int result) {
		PreparedStatement ps = null;
		String sql = "update solution set result = ? where solution_id = ?";
		try {
			ps = ct.prepareStatement(sql);
			ps.setInt(1, result);
			ps.setInt(2, solutionId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	//���������Ϣ
	private void saveComplieInfo(int solutionId, String strError) {
		PreparedStatement ps = null;
		String sql = "insert into compileinfo values (?, ?)";
		try {
			ps = ct.prepareStatement(sql);
			ps.setInt(1, solutionId);
			ps.setString(2, strError);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//�ж��ļ��Ƿ����
	public boolean isExist(String path) {
		  File file = new File(path);
		  //�ж��ļ����Ƿ����,����������򷵻�false
		  if (!file.exists()) {
		     return false;
		  }
		  return true;
	}
	
	
	//��out.txt��stdout.txtд�����ݿ⣬д��ɹ��ͷ���true�����ɹ�����false
	public boolean writeOut(int solutionId) throws SQLException{
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		
		String outCon=readTxtFile("C:\\huoj\\temp\\out.txt");
		//���������outCon��֤������д�����ݿ�
		if(outCon!=null){
			//�������out
			//System.out.println("���������ɵ�out.txt������:"+outCon+"END");
			
			String stdOutCon=readTxtFile("C:\\huoj\\temp\\stdout.txt");
			
			//System.out.println("solutionId == "+solutionId);
			//��ʼдstdout.txt���ݿ�
			String sql = "update source_code set stdout=(?) where solution_id=?";
			ps = ct.prepareStatement(sql);
			ps.setString(1, stdOutCon);
			ps.setInt(2, solutionId);
			ps.executeUpdate();
			
			
			//��ʼдout.txt���ݿ�
			String sql2 = "update source_code set sourout=(?) where solution_id=?";
			ps2 = ct.prepareStatement(sql2);
			ps2.setString(1, outCon);
			ps2.setInt(2, solutionId);
			ps2.executeUpdate();
			
			
			//�ر���Դ
			try {
				if (ps != null) {
					ps.close();
				}
				if (ps2 != null) {
					ps2.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return true;
		}
		
		return false;
			
	}
	
	
	
	
	/**
     * ���ܣ�Java��ȡtxt�ļ�������
     * ���裺1���Ȼ���ļ����
     * 2������ļ��������������һ���ֽ���������Ҫ��������������ж�ȡ
     * 3����ȡ������������Ҫ��ȡ�����ֽ���
     * 4��һ��һ�е������readline()��
     * ��ע����Ҫ���ǵ����쳣���
     * @param filePath
     */
	//�ɹ�����String�͵����ݣ����ɹ�����null
    public String readTxtFile(String filePath){
    	String outContent=null;
        try {
                String encoding="GBK";
                File file=new File(filePath);
                
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file),encoding);//���ǵ������ʽ
                
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                StringBuffer strBuffer = new StringBuffer();
                while((lineTxt = bufferedReader.readLine()) != null){
                   // System.out.println(lineTxt);
                    
                    strBuffer.append(lineTxt);
                    strBuffer.append("\n");
                }
                outContent=strBuffer.toString();
                read.close();
                
        } catch (Exception e) {
            System.out.println("��ȡ�ļ����ݳ���");
            e.printStackTrace();
        }
        
        return outContent;
    }

}
