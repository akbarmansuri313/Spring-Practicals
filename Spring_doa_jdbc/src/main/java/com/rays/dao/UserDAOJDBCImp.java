package com.rays.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOJDBCImp implements UserDAOInt {

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource = null;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public long add(UserDTO dto) throws Exception {

		String sql = "insert into st_user values(?, ?, ?, ?, ?)";

		int pk = jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(),
				dto.getPassword());

		return pk;
	}

	public void update(UserDTO dto) {

		String sql = "update st_user set firstName = ?, lastName = ?, login = ?, password = ?, id = ?";

		int i = jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(),
				dto.getId());

		System.out.println("Data Update " + i);

	}

	public void delete(UserDTO dto) {

		String sql = "delete from st_user where id = ?";

		int i = jdbcTemplate.update(sql, dto.getId());

		System.out.println("Data Delete " + i);

	}

	public UserDTO fingBylogin(String login) {

		UserDTO user = null;

		try {
			String sql = "select * from st_user where login = ?";

			Object[] params = { login };

			user = jdbcTemplate.queryForObject(sql, params, new UserMapper());

		} catch (EmptyResultDataAccessException e) {

			return null;
		}
		return user;
	}

	public UserDTO aunthenticate(String login, String password) {

		UserDTO user = null;

		try {
			String sql = "select * from st_user where login = ? and password = ?";

			Object[] params = { login, password };

			user = jdbcTemplate.queryForObject(sql, params, new UserMapper());

		} catch (EmptyResultDataAccessException e) {

			return null;
		}
		return user;

	}

	public UserDTO search(UserDTO dto) {

		return null;
	}

}
