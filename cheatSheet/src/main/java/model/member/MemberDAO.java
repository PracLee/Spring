package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.JDBC;


@Repository
public class MemberDAO {
	private final String insertSQL = "insert into member(id, pw, name) values (?,?,?)";
	private final String updateSQL = "update member set pw = ?, name =? where id = ?";
	private final String deleteSQL = "delete from member where id = ?";
	private final String getOneSQL = "select * from member where id =?";
	private final String getAllSQL = "select * from member";

	public MemberVO getOne(MemberVO vo) {
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		MemberVO data=null;
		try{
			pstmt=conn.prepareStatement(getOneSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new MemberVO();
				data.setId(rs.getString("id"));
				data.setPw(rs.getString("pw"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
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

	public List<MemberVO> getAll() {
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		MemberVO data=null;
		ArrayList<MemberVO> datas = null;
		try{
			pstmt=conn.prepareStatement(getAllSQL);
			ResultSet rs=pstmt.executeQuery();
			datas = new ArrayList<MemberVO>();
			if(rs.next()){
				data=new MemberVO();
				data.setId(rs.getString("id"));
				data.setPw(rs.getString("pw"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
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
	
	public void insert(MemberVO vo) {
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.executeUpdate();
		}
		catch(Exception e){
			System.out.println("UserDAO SelectOne() printed!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return;
	}
	
	public void delete(MemberVO vo) {
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
		}
		catch(Exception e){
			System.out.println("UserDAO SelectOne() printed!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return;
	}
	
	public void update(MemberVO vo) {
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getId());
			pstmt.executeUpdate();
		}
		catch(Exception e){
			System.out.println("UserDAO SelectOne() printed!");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return;
	}
}
