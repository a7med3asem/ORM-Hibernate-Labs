package dao;// default package
// Generated Mar 20, 2021, 11:48:12 PM by Hibernate Tools 6.0.0.Alpha2


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Seller generated by hbm2java
 */
@Entity
@Table(name="seller"
    ,catalog="biddingschema"
)
public class Seller  implements java.io.Serializable {


     private Integer id;
     private String value;

    public Seller() {
    }

    public Seller(String value) {
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

    
    @Column(name="value", nullable=false, length=100)
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }




}


