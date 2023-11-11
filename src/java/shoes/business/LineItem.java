/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/licenseprivate Stringdefault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes.business;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.OneToOne;
    
@Entity
public class LineItem implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int lineItemID;
    
    @OneToOne
    private Shoes product;
    private int quantity;
    private double priceUnit;

//    public double getTotal(){
//        return 0;
//    }
//    public String getTotalCurrencyFormat(){
//        return null;
//    }

    public int getLineItemID() {
        return lineItemID;
    }

    public void setLineItemID(int lineItemID) {
        this.lineItemID = lineItemID;
    }

    public Shoes getProduct() {
        return product;
    }

    public void setProduct(Shoes product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(double priceUnit) {
        this.priceUnit = priceUnit;
    }
    
    
}
