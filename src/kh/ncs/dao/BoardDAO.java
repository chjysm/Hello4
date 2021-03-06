package kh.ncs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kh.ncs.dto.BoardDTO;

public class BoardDAO {
	private DataSource ds;

	public BoardDAO() throws Exception {
		Context ctx = new InitialContext();
		Context compenv = (Context) ctx.lookup("java:/comp/env");
		this.ds = (DataSource) compenv.lookup("jdbc");
	}

	private Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	// 게시물작성코드
	public int insert(BoardDTO dto) {
		String sql = "insert into board4 valeus(seq.nextval,?,?,?,default)";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {

			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getTitle());
			pstat.setString(3, dto.getContents());

			int result = pstat.executeUpdate();

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			// 오류시 -1리턴
			return -1;
		}
	}

	// 모든게시물 보여줌
	public List<BoardDTO> selectAll_board() {
		String sql = "select * form board4";
		List<BoardDTO> list = new ArrayList<>();
		try (Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();

		) {
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("content"));
				dto.setWriteDate(rs.getTimestamp("writeDate"));
				list.add(dto);

			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			// 오류시 null나올꺼임 문의
			return null;
		}

	}

	// selectId sub code
	public PreparedStatement forSelectId(Connection con, String id) throws Exception {
		String sql = "select * from board4 where id = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, id);
		return pstat;
	}

	// 아이디로 게시물 정보검색 //이건 session으로 받아온 id로 검색 해서
	public BoardDTO select_id(String id) {

		try (Connection con = this.getConnection();
				PreparedStatement pstat = this.forSelectId(con, id);
				ResultSet rs = pstat.executeQuery();

		) {
		
			BoardDTO dto = new BoardDTO();
			rs.next();
			dto.setSeq(rs.getInt("seq"));
			dto.setTitle(rs.getString("title"));
			dto.setWriter(rs.getString("writer"));
			dto.setContents(rs.getString("content"));
			dto.setWriteDate(rs.getTimestamp("writeDate"));
			return dto;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

}
