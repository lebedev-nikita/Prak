package com.db.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.db.entity.Employee;

public class EmployeeTableManager
{
	private static SessionFactory sessionFactory = null;

	public EmployeeTableManager()
	{
		if (sessionFactory == null)
		{
			sessionFactory = new Configuration()
					   		 .configure("hibernate.cfg.xml")
					   		 .addAnnotatedClass(Employee.class)
					   		 .buildSessionFactory();
		}
	}

	// public List<Employee> hqlRequest(String query)
	// {
	// 	Session session = sessionFactory.getCurrentSession();
	// 	session.beginTransaction();
	//
	// 	List<Employee> listEmployees = session.createQuery(query).list();
	//
	//
	// 	session.getTransaction().commit();
	// 	session.close();
	//
	// 	return listEmployees;
	// }

	public Employee getById(int id)
	{

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		Employee myEmployee = session.get(Employee.class, id);
		session.getTransaction().commit();

		session.close();

		return myEmployee;
	}

	public int save(Employee employee)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		int id = (int) session.save(employee);

		session.getTransaction().commit();
		session.close();

		return id;
	}

	public void update(Employee employee)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.update(employee);

		session.getTransaction().commit();
		session.close();
	}

	public void delete(Employee employee)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.delete(employee);


		session.getTransaction().commit();
		session.close();

	}

	public List<Employee> listByNameSurname(String name, String surname)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<Employee> listEmployees = session.createQuery("from Employee where name like '%" + name +
														   "%' and surname like '%" + surname + "%'").list();

		session.getTransaction().commit();
		session.close();

		return listEmployees;
	}

}
