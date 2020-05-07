package com.db.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.db.entity.EmpPos;
import org.springframework.stereotype.Component;

@Component
public class EmpPosTableManager
{
	private static SessionFactory sessionFactory = null;

	public EmpPosTableManager()
	{
		if (sessionFactory == null)
		{
			sessionFactory = SessionFactoryFactory.getSessionFactory();
		}
	}

	public void save(EmpPos empPos)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.save(empPos);

		session.getTransaction().commit();
		session.close();
	}

	public void update(EmpPos empPos)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.update(empPos);

		session.getTransaction().commit();
		session.close();
	}

	public void delete(EmpPos empPos)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.delete(empPos);

		session.getTransaction().commit();
		session.close();
	}

	public EmpPos getById(int id)
	{

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		EmpPos ret = session.get(EmpPos.class, id);

		session.getTransaction().commit();

		session.close();

		return ret;
	}
}
