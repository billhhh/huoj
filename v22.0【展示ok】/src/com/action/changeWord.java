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

            System.out.println("word�ļ�·����"+DocFile);
            //word�ļ�������·��

            String HtmlFile = DocFile.substring(0, (DocFile.length() - 4)) + ".html";

            System.out.println("htm�ļ�·����"+HtmlFile);
            //html�ļ�������·��

            ActiveXComponent app = new ActiveXComponent("Word.Application");
            //����word

            try
            {
                app.setProperty("Visible", new Variant(false));
                //����word����ǿ��ӻ�����

                Dispatch docs = app.getProperty("Documents").toDispatch();

                Dispatch doc = Dispatch.invoke(docs,"Open", Dispatch.Method, new Object[]{DocFile,new Variant(false), new Variant(true)}, new int[1]).toDispatch(); 
                //��word�ļ�

                Dispatch.invoke(doc,"SaveAs",Dispatch.Method, new Object[]{HtmlFile,new Variant(8)}, new int[1]);
                //��Ϊhtm��ʽ�����ļ�

                Dispatch.call(doc, "Close",new Variant(false));
                //�ر��ļ�

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                app.invoke("Quit", new Variant[] {});
                //�˳�word����
            }
            //ת�����
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
