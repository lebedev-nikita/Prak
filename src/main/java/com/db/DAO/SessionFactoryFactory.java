package com.db.DAO;

import com.db.entity.Division;
import com.db.entity.EmpPos;
import com.db.entity.Employee;
import com.db.entity.Position;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryFactory {
    static SessionFactory sf = null;

    public static SessionFactory getSessionFactory() {
        if (sf == null) {
            sf = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Division.class)
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(EmpPos.class)
                    .addAnnotatedClass(Position.class)
                    .buildSessionFactory();
        }
        return sf;
    }
}
