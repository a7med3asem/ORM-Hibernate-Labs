import dao.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Person person = new Person("Ahmed", "Ali");
        Student student = new Student("Ahmed", "Asim", "Science");
        Teacher teacher = new Teacher("Mohamed", "Ali", new Date());

        session.beginTransaction();

        session.persist(person);
        session.persist(student);
        session.persist(teacher);

        session.getTransaction().commit();

        System.out.println("Committed");
    }
}
