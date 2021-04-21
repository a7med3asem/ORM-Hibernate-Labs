package dao;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_name")
    private String bookName;

//    @Column(name = "authors")
//    @OneToMany(mappedBy = "book")
//    private Set<Author> bookAuthors = new HashSet<>();

    @OneToOne
    private Publisher publisher = new Publisher();

    @OneToOne
    private Author author = new Author();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

//    public Set<Author> getBookAuthors() {
//        return bookAuthors;
//    }
//
//    public void setBookAuthors(Set<Author> bookAuthors) {
//        this.bookAuthors = bookAuthors;
//    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
