package com.action;

import java.sql.*;

import com.model.Constants;

public class ConnDB {
	
private Connection ct=null;
	public Connection getConn(){
		try {
			
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
	     	
	     	//2.得到链接
	     	//后面的是连接数据库的地址
	     	ct=DriverManager.getConnection(Constants.url, Constants.user, Constants.pass);
	     	
			
		} catch (Exception e) {
			// TODO: handle exception
			
			//一定写上...
			e.printStackTrace();
		}
		
		return ct;
		
	}
}
