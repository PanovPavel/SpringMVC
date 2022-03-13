package org.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ImplDAOEmployee implements EmployeeDAO{


    public ImplDAOEmployee() {

    }

    @Override
    public List<Employee> getAllEmployee() {
        SessionFactory sessionFactory = new Configuration().configure("hibernateConfiguration.xml").addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<Employee> listEmploye;

        try {
            session.beginTransaction();
            listEmploye = session.createQuery("from Employee ", Employee.class).getResultList();
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
        return listEmploye;
    }

    @Override
    public void addEmployee(Employee employee) {
        SessionFactory sessionFactory = new Configuration().configure("hibernateConfiguration.xml").addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(employee);
        session.getTransaction().commit();
        sessionFactory.close();
        session.close();
    }
    @Override
    public void deleteEmployee(int id) {
        SessionFactory sessionFactory = new Configuration().configure("hibernateConfiguration.xml").addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Employee> query = session.createQuery("delete from Employee where id =: employeeID");
        query.setParameter("employeeID", id).executeUpdate();
        session.getTransaction().commit();
        sessionFactory.close();
        session.close();
    }

    @Override
    public Employee getEmployee(int id) {
        SessionFactory sessionFactory = new Configuration().configure("hibernateConfiguration.xml")
                .addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        session.getTransaction().commit();
        sessionFactory.close();
        session.close();
        return employee;
    }
}
