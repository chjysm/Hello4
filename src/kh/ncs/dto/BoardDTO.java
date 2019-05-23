package kh.ncs.dto;

import java.sql.Timestamp;

public class BoardDTO {
	private int seq;
	private String writer;
	private String title;
	private String contents;
	private Timestamp writeDate;

	public BoardDTO() {//오류왜나냐고 ㅡㅡ
		super();
	}

	public BoardDTO(int seq, String writer, String title, String contents, Timestamp writeDate) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.writeDate = writeDate;
	}

	public int getSeq() {//ㅁㄴㅇㅁㄴㅇ
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Timestamp getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

}
