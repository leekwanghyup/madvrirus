package chap03.spring.rowMember;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import chap03.spring.Member;

public class MemberMapper implements RowMapper<Member>{

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member member = new Member(
				rs.getString("email"),
				rs.getString("password"),
				rs.getString("name"), 
				rs.getTimestamp("REGDATE")
		); 
		member.setId(rs.getLong("id"));
		return member;
	}

}
