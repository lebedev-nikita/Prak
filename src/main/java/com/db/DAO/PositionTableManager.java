package com.db.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.db.entity.Position;

public class PositionTableManager
{
	private static SessionFactory sessionFactory = null;

	public PositionTableManager()
	{
		if (sessionFactory == null)
		{
			sessionFactory = new Configuration()
					   		 .configure("hibernate.cfg.xml")
					   		 .addAnnotatedClass(Position.class)
					   		 .buildSessionFactory();
		}
	}

	// public List<Position> hqlRequest(String query)
	// {
	// 	Session session = sessionFactory.getCurrentSession();
	// 	session.beginTransaction();
	//
	// 	List<Position> listPositions = session.createQuery(query).list();
	//
	//
	// 	session.getTransaction().commit();
	// 	session.close();
	//
	// 	return listPositions;
	// }

	public Position getById(int id)
	{

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		Position myPosition = session.get(Position.class, id);

		session.getTransaction().commit();

		session.close();

		return myPosition;
	}

	public void save(Position position)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.save(position);

		session.getTransaction().commit();
		session.close();
	}

	public void update(Position position)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.update(position);

		session.getTransaction().commit();
		session.close();
	}

	public void delete(Position position)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.delete(position);


		session.getTransaction().commit();
		session.close();
	}

	public List<Position> listByDivisionId(int divisionId)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<Position> listPositions = session.createQuery("from Position where divisionId=" + divisionId).list();

		session.getTransaction().commit();
		session.close();

		return listPositions;
	}

	public List<Position> listByName(String name)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<Position> listPositions = session.createQuery("FROM Position WHERE name LIKE '%" + name +"%'").list();

		session.getTransaction().commit();
		session.close();

		return listPositions;
	}

}
