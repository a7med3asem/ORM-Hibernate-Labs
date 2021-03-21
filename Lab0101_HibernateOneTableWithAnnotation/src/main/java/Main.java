import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.service.ServiceRegistry;

import java.util.Date;


public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Account account = new Account();
        account.setUserName("Asim3");
        account.setPhone("01005425355");
        account.setFullName("Ahmed Amin");
        account.setPassword("1234");
        account.setBirthday(new Date());

        session.beginTransaction();
        session.persist(account);
        session.getTransaction().commit();
        System.out.println("Insertion done");

    }
}
