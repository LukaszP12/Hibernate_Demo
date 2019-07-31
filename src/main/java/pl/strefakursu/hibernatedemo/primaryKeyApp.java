package pl.strefakursu.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursu.hibernatedemo.entity.Employee;

public class primaryKeyApp {
    public static void main(String[] args){
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
        employee.setFirstName("Krzysztof");
        employee.setLastName("Nowak");
        employee.setSalary(10000);


        Employee employee2 = new Employee();
        employee.setFirstName("Janina");
        employee.setLastName("Kowalska");
        employee.setSalary(10000);


        Employee employee3 = new Employee();
        employee.setFirstName("Andrzej");
        employee.setLastName("Sienkiewicz");
        employee.setSalary(10000);

        // rozpoczęcie transakcji
        session.beginTransaction();

        // zapisanie 3 pracowników
        session.save(employee);
        session.save(employee2);
        session.save(employee3);

        // zakończenie transakcji
        session.getTransaction().commit();

        // zamknięcie obiektu SessionFactory
        factory.close();
    }

}
