package pl.strefakursu.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursu.hibernatedemo.entity.Employee;

import java.util.List;

public class getAllEntitiesApp {

    public static void main(String[] args) {
        // stworzyc obiekt Configuration
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");

        // wczytanie adnotacji
        conf.addAnnotatedClass(Employee.class);

        // stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();

        // pobranie sesji
        Session session = factory.getCurrentSession();

        //wczytuje list z pracowanika
        List<Employee> resultList = session.createQuery("FROM Employee").getResultList();
        for(Employee employee : resultList){
            System.out.println(employee);
        }

        // rozpoczęcie transakcji
        session.beginTransaction();

        // zakończenie transakcji
        session.getTransaction().commit();

        // zamknięcie obiektu SessionFactory
        factory.close();
    }

}
