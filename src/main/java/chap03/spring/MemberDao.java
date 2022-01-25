package chap03.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import chap03.spring.rowMember.MemberMapper;

@Component
public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao() {}
	
	@Autowired
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Member selectByEmail(String email) {
		// Connection conn = null; getDriv
		List<Member> members = jdbcTemplate.query("select * from member where email = ?",new MemberMapper(),email);
		return members.isEmpty() ? null : members.get(0);
		// finally ~
	}

	public Collection<Member> selectAll() {
		return jdbcTemplate.query("select * from member", new MemberMapper());
	}

	public void update(Member member) {
		jdbcTemplate.update("update member set name=?, password =? where email=?",
				member.getName(),member.getPassword(),member.getEmail());	
	}

	public void insert(Member member) {
		jdbcTemplate.update("insert into member(email, password, name, regdate) values(?,?,?,?)",
				member.getEmail(),member.getPassword(), member.getName(), new Date());
	}
}
