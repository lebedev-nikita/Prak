package com.db.DAO;

import java.util.List;

import com.db.entity.Division;
import com.db.entity.EmpPos;
import com.db.entity.Employee;
import com.db.entity.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DivisionTableManager
{

	private static SessionFactory sessionFactory = null;

	public DivisionTableManager()
	{
		if (sessionFactory == null)
		{
			sessionFactory = SessionFactoryFactory.getSessionFactory();
		}
	}

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

	public List<Division> listByName(String name)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<Division> listDivisions = session.createQuery("from Division d where d.name like '%" + name + "%'").list();

		session.getTransaction().commit();
		session.close();

		return listDivisions;
	}

	public List<Division> listLike(String divName)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<Division> listDivisions = session.createQuery("from Division where name like '%" + divName + "%'").list();

		session.getTransaction().commit();
		session.close();

		return listDivisions;
	}

}
