package com.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class fileCreator {
	
	public void creatFiles(String path,String filename,String content) throws IOException{
		
		File file = new File(path);
		file.mkdirs();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path+filename), true));
		 
		writer.write(content);
	     
	    writer.close();
	}
}
