package com.rays.dao;

import java.util.List;

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

	public long add(UserDTO dto) {

		String sql = "insert into st_user1 values(?, ?, ?, ?, ?)";

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

	public UserDTO authenticate(String login, String password) {

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

	public List search(UserDTO dto) {

		String sql = "select * from st_user";

		List list = jdbcTemplate.query(sql, new UserMapper());
		return list;

	}

	public List search(UserDTO dto, int pageNo, int pageSize) {

		StringBuffer sql = new StringBuffer("select * from st_user where 1=1");

		if (dto != null) {

			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {

				sql.append(" and firstName like '" + dto.getFirstName() + "%'");
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {

				sql.append(" and lastName like '" + dto.getLastName() + "%'");
			}

			if (dto.getLogin() != null && dto.getLogin().length() > 0) {
				sql.append(" and login like '" + dto.getLogin() + "%'");
			}
			if (dto.getPassword() != null && dto.getPassword().length() > 0) {
				sql.append(" and password like '" + dto.getPassword() + "%'");

			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);

		}

		List list = jdbcTemplate.query(sql.toString(), new UserMapper());
		return list;
	}


	public UserDTO findByPK(long pk) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDTO findbylogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}


}
