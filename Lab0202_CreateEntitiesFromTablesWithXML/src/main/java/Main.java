import dao.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        User user1 = new User();

        user1.setUserName("Asim");
        user1.setEmail("ahmedasim@gmail.com");
        user1.setAddress("Lol");
        user1.setPassword("1234");
        user1.setRegistrationDate(new Date());

        User user2 = new User();

        user2.setUserName("ahmed");
        user2.setEmail("ahmed@gmail.com");
        user2.setAddress("LolLol");
        user2.setPassword("1234");
        user2.setRegistrationDate(new Date());

        Seller seller = new Seller();
        seller.setValue("seller");
        seller.setUser(user1);

        Buyer buyer = new Buyer();
        buyer.setValue("buyer");
        buyer.setUser(user2);

        Product product = new Product();

        product.setName("BMW");
        product.setDescription("dsc");
        product.setQuantity(5);
        product.setSeller(seller);
        product.setFinishDate(new Date());
        product.setManufacturingDate(new Date());
        product.setManufacturingName("Lolololo");
        product.setOfferedDate(new Date());

        Category category = new Category();

        category.setValue("Cars");
        category.setDescription("dsvsdvsd");

        session.beginTransaction();
        session.save(user1);
        session.save(user2);

        session.save(seller);
        session.save(buyer);
        session.save(product);
        session.save(category);

        session.getTransaction().commit();

        System.out.println("Insertion");
    }
}
