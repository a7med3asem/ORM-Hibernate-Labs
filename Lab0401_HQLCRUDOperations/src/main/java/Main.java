import dao.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        User user1 = new User();
        user1.setUserName("Asim");
        user1.setEmail("ahmedasim@gmail.com");
        user1.setAddress("Cairo");
        user1.setPassword("1234");
        user1.setRegistrationDate(new Date());

        User user2 = new User();
        user2.setUserName("ahmed");
        user2.setEmail("ahmed@gmail.com");
        user2.setAddress("Giza");
        user2.setPassword("1234");
        user2.setRegistrationDate(new Date());

        Seller carsSeller = new Seller();
        carsSeller.setValue("Cars Seller");
        carsSeller.setUser(user1);

        Seller seller2 = new Seller();
        seller2.setValue("Bikes Seller");
        seller2.setUser(user2);

        Buyer buyer = new Buyer();
        buyer.setValue("Cars buyer");
        buyer.setUser(user2);

        Product product1 = new Product("BMW", "BMW", new Date(), 5, new Date(), new Date());
        Product product2 = new Product("Audi", "Audi", new Date(), 5, new Date(), new Date());
        Product product3 = new Product("Honda", "Honda", new Date(), 5, new Date(), new Date());
        Product product4 = new Product("Dodge", "Dodge", new Date(), 5, new Date(), new Date());
        Product product5 = new Product("Mercedes", "Mercedes", new Date(), 5, new Date(), new Date());

        Category category1 = new Category();
        category1.setValue("Cars");
        category1.setDescription("Sedan cars");

        Category category2 = new Category();
        category2.setValue("Bikes");
        category2.setValue("Motor bikes");

        Set<Category> categorySet = new HashSet<>();
        categorySet.add(category1);
        categorySet.add(category2);

        Set<Product> products = new HashSet<>();
        products.add(product1);
        products.add(product2);
//        products.add(product3);
        products.add(product4);
        products.add(product5);

        carsSeller.setProducts(products);
        category1.setProducts(products);

        session.beginTransaction();
        session.save(user1);
        session.save(user2);
        session.save(carsSeller);
        session.save(seller2);
        session.save(buyer);
        session.persist(product1);
        session.persist(product2);
        session.persist(product3);
        session.persist(product4);
        session.persist(product5);
        session.save(category1);

        session.getTransaction().commit();

        BuyerBuyProductId buyProductId = new BuyerBuyProductId(buyer.getId(), product1.getId());
        BuyerBuyProduct buyProduct = new BuyerBuyProduct(buyProductId, buyer, product1, new Date(), 30000, 200);

        BuyerBidProductId bidProductId = new BuyerBidProductId(buyer.getId(), product2.getId());
        BuyerBidProduct bidProduct = new BuyerBidProduct(bidProductId, buyer, product2, new Date(), 300, 1000);

        session.beginTransaction();
        session.persist(buyProduct);
        session.persist(bidProduct);
        session.getTransaction().commit();

        Query hqlQuery = session.createQuery("from Product");
        printResult(hqlQuery);

        System.out.println("\n\n\n\" Restriction \" Specific product\n");
        String queryString = "from Product p where p.name like :name";
        Query query = session.createQuery(queryString).setString("name", "BMW");
        List list1 = query.list();
        Product product = (Product) list1.get(0);
        System.out.println(product);

        String queryString2 =
                "from Product p where p.name IN ('mercedes', 'BMW')";
        Query query2 = session.createQuery(queryString2);
        printResult(query2);

        String queryString3 =
                "from BuyerBidProduct  bid where bid.amount between 200 and 500";
        Query query3 = session.createQuery(queryString3);
        printResult(query3);

        String queryString4 =
                "from Product p where p.name like 'H%'";
        Query query4 = session.createQuery(queryString4);
        printResult(query4);

        String queryString5 =
                "from Product p where upper(p.name) like 'H%' or\n" +
                        "p.manufacturingName like 'M%'";
        Query query5 = session.createQuery(queryString5);
        printResult(query5);



        System.out.println("Done");
    }

    private static void printResult(Query query) {
        List list = query.list();
        Iterator iterator = list.iterator();

        System.out.println("Retrieved result");
        iterator.forEachRemaining(o -> {
            if (o instanceof Product) {
                Product product = (Product) o;
                System.out.println(product.getName());
            } else if (o instanceof BuyerBidProduct) {
                BuyerBidProduct bidProduct = (BuyerBidProduct) o;
                System.out.println(bidProduct.getId());
            }
        });
    }
}
