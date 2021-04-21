import dao.Author;
import dao.Book;
import dao.Publisher;
import jakarta.validation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("Lab0601");
        EntityManager manager = managerFactory.createEntityManager();

        manager.getTransaction().begin();

        Author author = new Author();
        author.setId(2);
//        author.setAuthorName("Amin");

        Publisher publisher = new Publisher();
        publisher.setId(2);
        publisher.setPublisherName("Asim");

//        Set<Author> authors = new HashSet<>();
//        authors.add(author);

        Book book = new Book();
        book.setId(2);
        book.setBookName("Clean code");
        book.setPublisher(publisher);
        book.setAuthor(author);
//        book.setBookAuthors(authors);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Author>> violations = validator.validate(author);

        for (ConstraintViolation<Author> violation : violations) {
            System.out.println(violation.getMessage());
        }

        manager.persist(author);
        manager.persist(publisher);
        manager.persist(book);

        manager.getTransaction().commit();

        System.out.println("Committed");
    }
}
