package com.db.DAO;

import java.util.List;

import com.db.entity.Division;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DivisionTableManager
{

	private static SessionFactory sessionFactory = null;

	public DivisionTableManager()
	{
		if (sessionFactory == null)
		{
			sessionFactory = new Configuration()
					   		 .configure("hibernate.cfg.xml")
					   		 .addAnnotatedClass(Division.class)
					   		 .buildSessionFactory();
		}
	}

	// public List<Division> hqlRequest(String query)
	// {
	// 	Session session = sessionFactory.getCurrentSession();
	// 	session.beginTransaction();
	//
	// 	List<Division> listDivisions = session.createQuery(query).list();
	//
	// 	session.getTransaction().commit();
	// 	session.close();
	//
	// 	return listDivisions;
	// }

	public Division getById(int id)
	{

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		Division myDivision = session.get(Division.class, id);

		session.getTransaction().commit();
		session.close();

		return myDivision;
	}

	public int save(Division division)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		int id = (int) session.save(division);

		session.getTransaction().commit();
		session.close();

		return id;
	}

	public void update(Division division)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.update(division);

		session.getTransaction().commit();
		session.close();
	}

	public void delete(Division division)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.delete(division);


		session.getTransaction().commit();
		session.close();

	}

	// unchecked

	public List<Division> listAllDivisions()
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<Division> listDivisions = session.createQuery("from Division").list();

		session.getTransaction().commit();
		session.close();

		return listDivisions;
	}

	public List<Division> listByChiefId(int chiefId)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<Division> listDivisions = session.createQuery("from Division where chiefId=" + chiefId).list();

		session.getTransaction().commit();
		session.close();

		return listDivisions;
	}

	public List<Division> listByName(String name)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<Division> listDivisions = session.createQuery("from Division d where d.name like '%" + name + "%'").list();

		session.getTransaction().commit();
		session.close();

		return listDivisions;
	}

	public List<Division> listByHeadDivId(int headDivId)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<Division> listDivisions = session.createQuery("from Division where headDivId=" + headDivId).list();

		session.getTransaction().commit();
		session.close();

		return listDivisions;
	}

}
