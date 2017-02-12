package com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;


public class ReadPropertiesFile {
	//读取资源文件,并处理中文乱码  
    public static String readPropertiesFile(String attribute)  
    {  
        Properties properties = new Properties();  
        try  
        {  
        	String path=ReadPropertiesFile.class.getResource("").toString();
        	path=path.replace("file:/", "");
        	path=path.replace("%20", " ");
        	//System.out.println(path);
            InputStream inputStream = new FileInputStream(path+"ApplicationResources.properties");  
            properties.load(inputStream); 
            inputStream.close(); //关闭流  
        }  
        catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
        String result = properties.getProperty(attribute);
        try  
        {  
            result = new String(result.getBytes("ISO-8859-1"), "utf-8"); // 处理中文乱码  
        }  
        catch (UnsupportedEncodingException e)  
        {  
            e.printStackTrace();  
        }  
        return result;
    }  

}
