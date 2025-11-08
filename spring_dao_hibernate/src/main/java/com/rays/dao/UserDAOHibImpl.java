package com.rays.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDto;

@Repository
public class UserDAOHibImpl implements UserDAOInt {

	@Autowired
	private SessionFactory sessionFactory = null;

	public long add(UserDto dto) {

		Session session = sessionFactory.getCurrentSession();
		long pk = (Long) session.save(dto);

		return pk;
	}

	public void update(UserDto dto) {

		Session session = sessionFactory.getCurrentSession();

		session.update(dto);

	}

	public void delete(UserDto dto) {

		Session session = sessionFactory.getCurrentSession();

		session.delete(dto);

	}

	public List search(UserDto dto, int pageNo, int pageSize) {

		List list = null;

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(UserDto.class);

		if (dto != null) {

			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName()));

			}

		}

		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;

			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}

		list = criteria.list();
		return list;
	}

	public UserDto findByLogin(String login) {

		List list = null;

		UserDto dto = null;
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(UserDto.class);
		criteria.add(Restrictions.eq("login", login));
		list = criteria.list();

		if (list.size() == 1) {

			dto = (UserDto) list.get(0);
		}
		return dto;
	}

	public UserDto aunthenticate(String login, String password) {

		UserDto dto = null;

		List list = null;

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(UserDto.class);

		criteria.add(Restrictions.eq("login", login));

		criteria.add(Restrictions.eq("password", password));

		list = criteria.list();

		if (list.size() == 1) {

			dto = (UserDto) list.get(0);
		}

		return dto;

	}
}
