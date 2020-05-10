package com.db.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.db.entity.Position;
import org.springframework.stereotype.Component;

@Component
public class PositionTableManager
{
	private static SessionFactory sessionFactory = null;

	public PositionTableManager()
	{
		if (sessionFactory == null)
		{
			sessionFactory = SessionFactoryFactory.getSessionFactory();
		}
	}

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

// listLike(pr.getGetName(), pr.getGetResponsibilities(), pr.getGetDivisionId(), pr.getGetDivisionName());

	public List<Position> listLike(String name, String responsibilities, int divisionId, String divisionName)
	{
		if (name == null) { name = ""; }
		if (responsibilities == null) { responsibilities = ""; }
		if (divisionName == null) { divisionName = ""; }
        String divIdFilter = (divisionId != 0) ? " and div.id = " + divisionId : "";


		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<Position> listPositions = session.createQuery(
            "from Position p left join fetch p.division div"
            + " where p.name like '%" + name +"%'"
            + " and p.responsibilities like '%" + responsibilities + "%'"
            + divIdFilter
            + " and div.name like '%" + divisionName + "%'"
        ).list();

		session.getTransaction().commit();
		session.close();

		return listPositions;
	}

	public List<Position> listAllPositions() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<Position> listPositions = session.createQuery("from Position").list();

		session.getTransaction().commit();
		session.close();

		return listPositions;
	}

}
