import dao.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Person person = new Person("Asim", "Ahmed");
        Teacher teacher = new Teacher("Mahmoud", "Ali", new Date());
        Student student = new Student("Ahmed", "Asim", "JETS");

        session.beginTransaction();
        session.persist(person);
        session.persist(teacher);
        session.persist(student);

        session.getTransaction().commit();
        session.close();

        System.out.println("Transaction executed");
    }
}
