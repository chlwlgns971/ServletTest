package kr.or.ddit.session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	private static MemberDao dao;
	
	private MemberDao() {
		
	}
	public static MemberDao getInstance() {
		if(dao==null) dao=new MemberDao();
		return dao;
	}
	public MemberVO getLoginMember(MemberVO paramVo) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		MemberVO memVo=null;
		try {
			conn=DBUtil.getConnection2();
			
			String sql="select* from mymember where mem_id=? and mem_pass=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, paramVo.getMem_id());
			pstmt.setString(2, paramVo.getMem_pass());
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				memVo=new MemberVO();
				memVo.setMem_id(rs.getString("mem_id"));
				memVo.setMem_pass(rs.getString("mem_pass"));
				memVo.setMem_name(rs.getString("mem_name"));
				memVo.setMem_tel(rs.getString("mem_tel"));
				memVo.setMem_addr(rs.getString("mem_addr"));
			}
		}catch(SQLException e) {
			memVo=null;
			e.printStackTrace();
		}
		finally {
			if(rs!=null) try {rs.close();}catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null) try {conn.close();}catch(SQLException e) {}
		}
		return memVo;
	}
}
