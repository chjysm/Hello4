package kh.ncs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kh.ncs.dto.InOutDTO;

public class InOutDAO {
	private DataSource ds;
	public InOutDAO()throws Exception{
		Context ctx = new InitialContext();
		Context compenv = (Context)ctx.lookup("java:/comp/env");
			this.ds = (DataSource)compenv.lookup("jdbc");
	}
	
	private Connection getConnection()throws Exception{
		return ds.getConnection();
	}
		
	public int insert(InOutDTO param)throws Exception {
		String sql = "insert into io values(io_seq.nextval,?,?)";
		try(
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setString(1, param.getName());
			pstat.setString(2, param.getMessage());
			int result = pstat.executeUpdate();
			return result;
		}
	}
	public List<InOutDTO> output()throws Exception{
		String sql = "select * from io";
		try(
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();
				){
			List<InOutDTO> list = new ArrayList<>();
			while(rs.next()) {
			int seq = rs.getInt("seq");
			String name = rs.getString("name");
			String msg = rs.getString("message");
			InOutDTO dto = new InOutDTO(seq, name, msg);
			list.add(dto);
		} 
			return list;
			}
	}
	
}
