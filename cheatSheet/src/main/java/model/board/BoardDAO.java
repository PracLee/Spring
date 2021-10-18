package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.JDBC;

@Repository
public class BoardDAO {
	private final String insertSQL="insert into board (id,title,writer,content) values((select nvl(max(id),0)+1 from board),?,?,?)";
	private final String updateSQL="update board set title=?,content=? where id=?";
	private final String deleteSQL="delete board where id=?";
	private final String getBoardSQL="SELECT * FROM board WHERE id = ? ";
	private final String getBoardListSQL="SELECT * FROM board order by wdate desc";


	public void insertBoard(BoardVO vo) {
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		}
		catch(Exception e){
			System.out.println("UserDAO SelectOne() printed!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}

	}


	public void updateBoard(BoardVO vo) {
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getId());
			pstmt.executeUpdate();
		}
		catch(Exception e){
			System.out.println("UserDAO SelectOne() printed!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}


	}

	public void deleteBoard(BoardVO vo) {
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, vo.getId());
			pstmt.executeUpdate();
		}
		catch(Exception e){
			System.out.println("UserDAO SelectOne() printed!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}

	}


	public List<BoardVO> getBoardList() {
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		ArrayList<BoardVO> datas = new ArrayList<BoardVO>();
		BoardVO data = null;
		try{
			pstmt=conn.prepareStatement(getBoardListSQL);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data= new BoardVO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
				datas.add(data);
			}	
			rs.close();
		}
		catch(Exception e){
			System.out.println("UserDAO SelectOne() printed!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return datas;
	}


	public BoardVO getBoard(BoardVO vo) {
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		BoardVO data = null;
		try{
			pstmt=conn.prepareStatement(getBoardSQL);
			pstmt.setInt(1, vo.getId());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data= new BoardVO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
			}	
			rs.close();
		}
		catch(Exception e){
			System.out.println("UserDAO SelectOne() printed!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return data;
	}

}

