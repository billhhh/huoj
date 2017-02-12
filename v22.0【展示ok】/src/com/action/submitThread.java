package com.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;

import com.model.JudgeContext;

public class submitThread implements Runnable{

	public static BlockingQueue<JudgeContext> submitQueue;
//	private JudgeContext context;
	private Connection ct=null;
	
	//��д���췽��
	public submitThread(){
		try {
			//�õ�����
			ct=new ConnDB().getConn();
//			this.context=cont;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		System.out.println("�ѽ���submitThread����");
		//System.out.println("submitThread"+submitThread.submitQueue.isEmpty());
		//System.out.println(this.context);
		// TODO Auto-generated method stub
		while (true) {
			try {
				JudgeContext context = submitQueue.take();  //�õ���������
				context.setSolution_id(getSolutionId());
				//System.out.println(context.getSolution_id());
				submitSolution(context);  //��contextд��solution��
				updateProblem(context);  //���������ύ����
				updateUser(context);     //�����û��ύ����
				submitSource(context);  //��Դ��д�����ݿ�
				judgeThread.judgeQueue.offer(context); //����judgeThread��������
				
//				judgeThread th=new judgeThread(context);
//				th.run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//�õ�ǰһ���ύ����ţ���solution��
	private int getSolutionId() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select max(solution_id) from solution";
		int solutionId = 1000;
		
		try {
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getInt(1) != 0) {
					solutionId = rs.getInt(1) + 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return solutionId;
	}
	
	
	
	private void submitSolution(JudgeContext context) {
		PreparedStatement ps = null;
		String sql = "insert into solution(solution_id, problem_id, user_id, in_date, language) values(?, ?, ?, now(), ?)";
	
		try {
			ps = ct.prepareStatement(sql);
			
//			System.out.println(context.getSolution_id());
			ps.setInt(1, context.getSolution_id());
			
//			System.out.println(context.getProblem_id());
			ps.setInt(2, context.getProblem_id());
			
//			System.out.println(context.getUser_id());
			ps.setString(3, context.getUser_id());
			
//			System.out.println(context.getLanguage());
			ps.setInt(4, context.getLanguage());
			ps.executeUpdate();
		} catch (SQLException e) {
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
	
	
	
	
	//��֪�������������ʲô�ģ��²��Ǹ����ύ��������Ӧ��д����
	private void updateProblem(JudgeContext context) {
		//PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		
		//ȡ������Ŀ������ύ��������
		String sql = "select max(submit) from problem where problem_id='"+context.getProblem_id()+"'";
		
		try {
			ps1 = ct.prepareStatement(sql);
			rs = ps1.executeQuery();
			if (rs.next()) {
				sql = "update problem set submit = ? where problem_id = ?";
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
	
	
	//ͬ�ϲ�֪��
	private void updateUser(JudgeContext context) {
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		String sql = "select max(submit) from users where user_id='"+context.getUser_id()+"'";
		try {
			ps1 = ct.prepareStatement(sql);
			rs = ps1.executeQuery();
			if (rs.next()) {
				sql = "update users set submit = ? where user_id = ?";
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
	
	
	
	
	
	private void submitSource(JudgeContext context) {
		PreparedStatement ps = null;
		String sql = "insert into source_code values(?, ? , ?, ?)";
		
		try {
			ps = ct.prepareStatement(sql);
			ps.setInt(1, context.getSolution_id());
			ps.setString(2, context.getSource());
			ps.setString(3, null);
			ps.setString(4, null);
			ps.executeUpdate();
		} catch (SQLException e) {
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

}
