package com.action;

import java.sql.*;

import com.model.Constants;

public class ConnDB {
	
private Connection ct=null;
	public Connection getConn(){
		try {
			
			//1.��������
			Class.forName("com.mysql.jdbc.Driver");
	     	
	     	//2.�õ�����
	     	//��������������ݿ�ĵ�ַ
	     	ct=DriverManager.getConnection(Constants.url, Constants.user, Constants.pass);
	     	
			
		} catch (Exception e) {
			// TODO: handle exception
			
			//һ��д��...
			e.printStackTrace();
		}
		
		return ct;
		
	}
}
