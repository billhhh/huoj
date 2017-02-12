package com.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.ProblemDAO;
import com.dao.UsersDAO;
import com.model.Problem;
import com.model.Users;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

///**
//* 检查java虚拟机的内存使用情况
//* @return
//*/
//public int checkJVMRun(){
//int i = (int)Runtime.getRuntime().totalMemory()/1024;//Java 虚拟机中的内存总量,以字节为单位
//int j = (int)Runtime.getRuntime().freeMemory()/1024;//Java 虚拟机中的空闲内存量
//return j ;
//}

public class test {

	static BufferedReader br;
	static int cnt=0;
	static Process pro;
	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//******************************************编译******************************************
		String defaultSrcPath = "C:\\onlinejudge\\temp\\";
		String defaultExePath = "C:\\onlinejudge\\temp\\main.exe";
		String defaultCmd = "";
		
		defaultSrcPath += "main.cpp";
		defaultCmd += "g++";
		
		defaultCmd += " -o " + defaultExePath + " " + defaultSrcPath;
		
		Process process = Runtime.getRuntime().exec(defaultCmd);
		process.waitFor();
		File exeFile = new File(defaultExePath);
		//******************************************编译结束******************************************
		
		pro = Runtime.getRuntime().exec(defaultExePath);
	
		//pro.waitFor();
		
		br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
		Thread thread=new Thread(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String str;
				try {
					while(( str = br.readLine()) != null)
					{
						System.out.println(str);
						cnt+=str.getBytes().length;
						if(cnt>=1024){
						pro.destroy();
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});		
		
		thread.start();
		
		
	}

}
