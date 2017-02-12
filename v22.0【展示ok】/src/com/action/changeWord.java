package com.action;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class changeWord {

	public static boolean change (String FolderPath,String FileName){

        String FileFormat = "";
        System.out.println(FolderPath);
        FileFormat = FileName.substring(FileName.length()-4,FileName.length());
        System.out.println(FileFormat);

        if(FileFormat.equalsIgnoreCase(".doc"))
        {
            String DocFile = FolderPath +"\\"+ FileName;

            System.out.println("word文件路径："+DocFile);
            //word文件的完整路径

            String HtmlFile = DocFile.substring(0, (DocFile.length() - 4)) + ".html";

            System.out.println("htm文件路径："+HtmlFile);
            //html文件的完整路径

            ActiveXComponent app = new ActiveXComponent("Word.Application");
            //启动word

            try
            {
                app.setProperty("Visible", new Variant(false));
                //设置word程序非可视化运行

                Dispatch docs = app.getProperty("Documents").toDispatch();

                Dispatch doc = Dispatch.invoke(docs,"Open", Dispatch.Method, new Object[]{DocFile,new Variant(false), new Variant(true)}, new int[1]).toDispatch(); 
                //打开word文件

                Dispatch.invoke(doc,"SaveAs",Dispatch.Method, new Object[]{HtmlFile,new Variant(8)}, new int[1]);
                //作为htm格式保存文件

                Dispatch.call(doc, "Close",new Variant(false));
                //关闭文件

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                app.invoke("Quit", new Variant[] {});
                //退出word程序
            }
            //转化完毕
            return true;
        }
        return false;
    }


	 public static void main(String[] args)
	 {
	  
	  String paths = new String("E:\\wordToHtml");
	  String filename = "a.doc";
	  
	  System.out.println(System.getProperty("java.library.path"));
	
	  change(paths, filename);
	
	 }
}
