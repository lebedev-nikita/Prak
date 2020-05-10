package com.db.DAO;

import java.util.List;

import com.db.entity.Division;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.db.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeTableManager
{
	private static SessionFactory sessionFactory = null;

	public EmployeeTableManager()
	{
		if (sessionFactory == null)
		{
			sessionFactory = SessionFactoryFactory.getSessionFactory();
		}
	}

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

	public List<Employee> listAllEmployees()
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<Employee> listEmployees = session.createQuery("from Employee").list();

		session.getTransaction().commit();
		session.close();

		return listEmployees;
	}

	public List<Employee> listLike(String name, String surname, String patronymic, String education)
	{
        if (name == null) { name = ""; }
        if (surname == null) { surname = ""; }
        if (patronymic == null) { patronymic = ""; }
        if (education == null) { education = ""; }
        String patronymicFilter = (!patronymic.equals("")) ? " and patronymic like '%" + patronymic + "%'" : "";

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<Employee> listEmployees = session.createQuery( "from Employee where"
            + " name like '%" + name + "%'"
            + " and surname like '%" + surname + "%'"
            + patronymicFilter
            + " and education like '%" + education + "%'"
        ).list();

		session.getTransaction().commit();
		session.close();

		return listEmployees;
	}

}
