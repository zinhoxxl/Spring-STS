package com.oracle.oBootDBConnect.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import com.oracle.oBootDBConnect.domain.Member1;

// 방법1.
//@Repository
public class JdbcMemberRepository implements MemberRepository {
	// DB
	private final DataSource dataSource;
	// 생성자
	public JdbcMemberRepository(DataSource dataSource) {
		this.dataSource = dataSource; // application.properties의 정보를 읽어서 가져옴
	}
	
	private Connection getConnection() {
		return DataSourceUtils.getConnection(dataSource);
	}
	
	// 회원 가입 저장
	@Override
	public Member1 save(Member1 member1) {
		String sql = "insert into member(id, name) values(member_seq.nextval, ?)";
		System.out.println("JdbcMemberRepository sql -> " + sql);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member1.getName());
			pstmt.executeUpdate();
			System.out.println("JdbcMemberRepository pstmt.executeUpdate After");

			return member1;
			
		} catch(Exception e) {
			throw new IllegalStateException(e); 
		} finally {
			close(conn, pstmt, rs);
		}
		
		
	}

	// 회원 목록
	@Override
	public List<Member1> findAll() {
		String sql = "select * from member";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Member1> members = new ArrayList<>();
			while(rs.next()) {
				Member1 member = new Member1();
				member.setId(rs.getLong("id"));
				member.setName(rs.getString("name"));
				members.add(member);
			}
			
			return members;
			
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			close(conn, pstmt, rs);
		}
		
	}
	
	
	// 연결해제 만들어놓고 꺼내쓸수 있게 (역순으로 close)
	private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(conn != null) {
				close(conn); // close 자원해제 메소드 사용
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	
	// close 자원 해제(메모리 최적화)
	private void close(Connection conn) throws SQLException {
		DataSourceUtils.releaseConnection(conn, dataSource);
	}
	
	
	

}
