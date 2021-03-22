import dao.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Product product1 = new Product();
        product1.setName("Audi");
        product1.setDescription("description");
        product1.setQuantity(3);
        product1.setFinishDate(new Date());
        product1.setManufacturingDate(new Date());
        product1.setManufacturingName("Audi");
        product1.setOfferedDate(new Date());

        Product product2 = new Product();
        product2.setName("BMW");
        product2.setDescription("dsc");
        product2.setQuantity(5);
        product2.setFinishDate(new Date());
        product2.setManufacturingDate(new Date());
        product2.setManufacturingName("BMW");
        product2.setOfferedDate(new Date());

        Product product3 = new Product();
        product3.setName("BMW");
        product3.setDescription("dsc");
        product3.setQuantity(5);
        product3.setFinishDate(new Date());
        product3.setManufacturingDate(new Date());
        product3.setManufacturingName("BMW");
        product3.setOfferedDate(new Date());

        Set<Product> products = new HashSet<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        User user1 = new User();
        user1.setUserName("Asim");
        user1.setEmail("ahmedasim@gmail.com");
        user1.setAddress("Lol");
        user1.setPassword("1234");
        user1.setRegistrationDate(new Date());

        Seller seller = new Seller();
        seller.setValue("seller");
        seller.setUser(user1);

        Seller seller2 = new Seller();
        seller2.setValue("Seller2");

        seller.setProducts(products);

        session.beginTransaction();
        session.save(seller);
        session.save(product1);
        session.save(product2);
        session.save(product3);

        Seller seller1 = session.get(Seller.class, 16);
        Set<Product> productSet = seller1.getProducts();

//        for (Product product : productSet) {
//            System.out.println("Product name" + product.getName());
//        }
//        for (int i = 0 ; i < 1 ; i++) {
        Optional<Product> product = productSet.stream().findFirst();
        if (product.isPresent())
            System.out.println(product.get().getName());
        else System.out.println("Not found");
//        }
//        productSet.forEach(product -> System.out.println("Product name" + product.getName()));

        session.getTransaction().commit();
        session.close();

        System.out.println("Insertion");
    }
}