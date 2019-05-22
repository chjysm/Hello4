package kh.ncs.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kh.ncs.dto.MemberDTO;


public class MemberDAO {
	private DataSource ds;
	public MemberDAO() throws Exception {
		Context ctx = new InitialContext();
		Context compenv = (Context) ctx.lookup("java:/comp/env");
		this.ds = (DataSource) compenv.lookup("jdbc");
	}
	private Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	public int idCheck(String id) throws Exception {
		String sql = "select * from sajo where id=?";
		try(
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setString(1,id);
			int result = pstat.executeUpdate();
			con.commit();
			return result;
		} 
	}
	public int login(String id, String pw) throws Exception {
		String sql="select * from sajo where id=? and pw=?";
		String newPw=testSHA256(pw);
		try(
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);	
				){
			pstat.setString(1,id);
			pstat.setString(2,newPw);
			int result = pstat.executeUpdate();
			return result;
		} 
	}
	private static String testSHA256(String str){
		String SHA = ""; 
		try{
			MessageDigest sh = MessageDigest.getInstance("SHA-256"); 
			sh.update(str.getBytes()); 
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer(); 
			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			SHA = sb.toString();
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace(); 
			SHA = null; 
		}
		return SHA;
	}
	public int sign(MemberDTO dto) throws Exception {
		String sql = "insert into sajo values(?,?,?,?,?)";
		try(
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setString(1,dto.getId());
			pstat.setString(2,testSHA256(dto.getPassword()));
			pstat.setString(3,dto.getName());
			pstat.setString(4,dto.getPhone());
			pstat.setString(5,dto.getEmail());
			int result = pstat.executeUpdate();
			con.commit();
			return result;
		} 
	}
	public int deleteMember(String id) throws Exception { // 아이디값을 이용해서 회원탈퇴
		String sql = "delete from sajo where id = ? ";
		try(
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setString(1, id);
			con.commit();
			int result = pstat.executeUpdate();
			return result;
		}
	}
}



	


	