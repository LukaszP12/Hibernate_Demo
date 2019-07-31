package pl.strefakursu.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursu.hibernatedemo.entity.Employee;

public class UpdateManagedEntityApp {

    public static void main(String[] args) {
        // stworzyc obiekt Configuration
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");

        // wczytanie adnotacji
        conf.addAnnotatedClass(Employee.class);

        // stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();

        // pobranie sesji
        Session session = factory.getCurrentSession();

        // rozpoczęcie transakcji
        session.beginTransaction();

        Employee employee = session.get(Employee.class, 30);

        //zmiana imienia jest wykonywana zaraz po wczytaniu encji
        employee.setFirstName("Tadeusz");

        session.getTransaction().commit();


        System.out.println("Zaktualizowane Dane pracownika:" + employee);

        // zamknięcie obiektu SessionFactory
        factory.close();
    }

}
