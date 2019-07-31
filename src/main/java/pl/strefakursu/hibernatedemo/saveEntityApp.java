package pl.strefakursu.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.strefakursu.hibernatedemo.entity.Employee;

public class saveEntityApp {

    public static void main(String args[]){
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
        employee.setIdEmployee(1);
        employee.setFirstName("Jan");
        employee.setLastName("Kowalski");
        employee.setSalary(10000);

        // rozpoczęcie transakcji
        session.beginTransaction();

        // zapisanie transakcji
        session.save(employee);

        // zakończenie transakcji
        session.getTransaction().commit();

        // zamknięcie obiektu SessionFactory
        factory.close();

    }

}
