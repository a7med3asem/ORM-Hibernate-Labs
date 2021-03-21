package dao;// default package
// Generated Mar 20, 2021, 11:48:12 PM by Hibernate Tools 6.0.0.Alpha2


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name="category"
    ,catalog="biddingschema"
)
public class Category  implements java.io.Serializable {


     private Integer id;
     private String description;
     private String value;

    public Category() {
    }

	
    public Category(String value) {
        this.value = value;
    }
    public Category(String description, String value) {
       this.description = description;
       this.value = value;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="description", length=150)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="value", nullable=false, length=45)
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }




}


