/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivate Stringdefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes.business;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Inventory implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int stockID;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Shoes> productList;
    private int quantity;

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Shoes> getProductList() {
        return productList;
    }

    public void setProductList(List<Shoes> productList) {
        this.productList = productList;
    }
    
    
}
