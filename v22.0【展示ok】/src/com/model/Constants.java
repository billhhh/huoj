package com.model;

public class Constants {
	public final static int GCC = 0;
	public final static int GPLUSPLUS = 1;
	
	public final static String url = "jdbc:mysql://localhost:3306/jol";
	public final static String user = "root";
	public final static String pass = "root";
	
	public final static int Waiting = 0;
	public final static int CompileError = 1;
	public final static int Running = 2;
	public final static int RuntimeError = 3;
	public final static int TimeLimit = 4;
	public final static int MemoryLimit = 5;
	public final static int WrongAnswer = 6;
	public final static int Accepted = 7;
	
	public final static String strRuntimeError = "RuntimeError";
	public final static String strTimeLimit = "TimeLimit";
	public final static String strMemoryLimit = "MemoryLimit";
	public final static String strWrongAnswer = "WrongAnswer";
	public final static String strAccepted = "Accept";
}
