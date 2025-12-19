package hibernate;

import java.util.Date;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grn")
public class GRN implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private int id;

    @JoinColumn(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(mappedBy = "grn", cascade = CascadeType.ALL)
    private List<GRNItem> grnItems;

    public GRN() {
    }

    public GRN(int id, Date date, Supplier supplier) {
        this.id = id;
        this.date = date;
        this.supplier = supplier;
    }

    public List<GRNItem> getGrnItems() {
        return grnItems;
    }

    public void setGrnItems(List<GRNItem> grnItems) {
        this.grnItems = grnItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

}