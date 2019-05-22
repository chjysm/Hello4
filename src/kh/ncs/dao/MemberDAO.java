package kh.ncs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource ds;

	public int deleteMember(String id) { // 아이디값을 이용해서 회원탈퇴
		String sql = "delete from sajo where id = ? ";
		try(
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setString(1, id);
			con.commit();
			int result = pstat.executeUpdate();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}return -1;
	}



}
