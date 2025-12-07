package hibernate;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bill_histry")
public class BillHistry implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "sales_id")
    private Sale sale;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public Sale getSale() {
        return sale;
    }


    public void setSale(Sale sale) {
        this.sale = sale;
    }
    
}
