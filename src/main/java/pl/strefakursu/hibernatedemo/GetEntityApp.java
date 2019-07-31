package pl.strefakursu.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursu.hibernatedemo.entity.Employee;

import javax.persistence.criteria.CriteriaBuilder;

public class GetEntityApp {

    public static void main(String[] args) {
        // stworzyc obiekt Configuration
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");

        // wczytanie adnotacji
        conf.addAnnotatedClass(Employee.class);

        // stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();

        // pobranie sesji
        Session session = factory.getCurrentSession();

        // stworzenie obiektu
        Employee employee = new Employee();
        employee.setFirstName("Tadeusz");
        employee.setLastName("Wisniewski");
        employee.setSalary(10000);

        // rozpoczęcie transakcji
        session.beginTransaction();

        // zapisanie pracownik
        Integer id = (Integer) session.save(employee);

        // zakończenie transakcji
        session.getTransaction().commit();

        // wczytujemy pracownika
        session = factory.getCurrentSession();

        session.beginTransaction();

        Employee retrivedEmployee = session.get(Employee.class, id);

        session.getTransaction().commit();

        System.out.println("Dane pracownika: " + retrivedEmployee);

        // zamknięcie obiektu SessionFactory
        factory.close();
    }

}
