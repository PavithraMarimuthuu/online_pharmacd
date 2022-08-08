package com.usermanagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.usermanagement.model.Users;

public class UserDaoImpl implements UserDao {
	private JdbcTemplate jdbcTemplate;

	public UserDaoImpl(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public int save(Users user) {
		String sql = "INSERT into distributors(name,email,phone,itemno) VALUES ( ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPhone(), user.getItemno());

	}

	@Override
	public int update(Users user) {
		String sql = "UPDATE distributors SET name=?, email=?, phone=?, itemno=? WHERE id=?";
		return jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPhone(), user.getItemno(),
				user.getId());

	}

	@Override
	public Users get(int id) {
		String sql = "SELECT * FROM Users WHERE id=" + id;
		ResultSetExtractor<Users> extractor = new ResultSetExtractor<Users>() {

			@Override
			public Users extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {

					String name = rs.getString("name");
					String email = rs.getString("email");
					String phone = rs.getString("phone");
					String itemno = rs.getString("itemno");
					return new Users(id, name, email, phone, itemno);
				}

				return null;
			}

		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM distributors WHERE id=?";
		return jdbcTemplate.update(sql, id);

	}

	@Override
	public List<Users> list() {
		String sql = "SELECT * FROM distributors ";
		
		  RowMapper<Users> rowMapper=new RowMapper<Users>() {
			  
			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {

				    Integer id= rs.getInt("id");
				    String name= rs.getString("name");
	                String email= rs.getString("email");
	                String phone=rs.getString("phone");
	                String itemno= rs.getString("itemno");
	          
	                return new Users(id,name,email,phone,itemno);

         }

		};

		return jdbcTemplate.query(sql, rowMapper);
	}

}
