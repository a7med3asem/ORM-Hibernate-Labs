import dao.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Session session2 = sessionFactory.openSession();

//        Person person = new Person("Asim", "Ahmed");
//        Teacher teacher = new Teacher("Mahmoud", "Ali", new Date());
//        Student student = new Student("Ahmed", "Asim", "JETS");

//        session1.beginTransaction();
//        session2.beginTransaction();
//        session1.persist(person);
//        session1.persist(teacher);
//        session1.persist(student);

        Student student1 = session1.load(Student.class, 3);
        System.out.println(student1.getFirstName());
        session1.close();

        Student student2 = session2.load(Student.class, 3);
        System.out.println(student2.getFirstName());
        session2.close();

//        session1.getTransaction().commit();
//        session2.getTransaction().commit();

        System.out.println("Transaction executed");
    }
}
