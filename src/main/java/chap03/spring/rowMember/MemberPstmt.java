package chap03.spring.rowMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;

public class MemberPstmt implements PreparedStatementCreator{

	@Override
	public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		String sql = "insert into member(email, password, name, regdate) values(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"id"});
//		pstmt.setString(1, );
		return null;
	}

}
