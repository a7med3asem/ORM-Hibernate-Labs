package dao;

import jakarta.validation.constraints.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @Column(name = "author_id")
    private int id;

    @NotNull(message = "name cannot be null")
    @Column(name = "author_name")
    private String authorName;

//    @ManyToOne
//    @JoinColumn(name = "book_id")
//    private Book book;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
