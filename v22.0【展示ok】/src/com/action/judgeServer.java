package com.action;

import java.util.concurrent.ArrayBlockingQueue;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.model.JudgeContext;

public class judgeServer extends HttpServlet {

	judgeThread judgeThread;
	submitThread submitThread;

	Thread judge;
	Thread submit;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		int queueSize = Integer.parseInt(config.getInitParameter("QueueSize"));
		com.action.judgeThread.judgeQueue = new ArrayBlockingQueue<JudgeContext>(queueSize);
		com.action.submitThread.submitQueue = new ArrayBlockingQueue<JudgeContext>(queueSize);
		
		// Initial judge thread
		submitThread = new submitThread();
		judgeThread = new judgeThread();
		
		submit = new Thread(submitThread);
		submit.start();
		
		judge = new Thread(judgeThread);
		judge.start();
		
	}
	
	public void destroy() {
		System.out.println("“—À¿!!");
		super.destroy();
	}
}
