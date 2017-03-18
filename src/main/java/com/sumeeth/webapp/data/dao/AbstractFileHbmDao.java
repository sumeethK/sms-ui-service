package com.sumeeth.webapp.data.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sumeeth kumar kanojia
 *
 */
public abstract class AbstractFileHbmDao<T> {

	@Autowired
	protected SessionFactory sessionFactory;

	public void save(T dto) throws Exception {

		sessionFactory.getCurrentSession()
				.beginTransaction();
		insert(sessionFactory.getCurrentSession(), dto);
		sessionFactory.getCurrentSession()
				.beginTransaction().commit();
	}

	public abstract void insert(Session session, T dto)
			throws Exception;

}
