package hellojpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Product entity.
 */
@Entity
@NamedQuery(name="findAllProducts", query="SELECT p FROM Product p")
public class Product implements Serializable {

    @Id
    private String productId;
    private double price;
    private String description;
    
    public Product() {
    }
    
    public Product(String productId, double price, String description){
        this.productId = productId;
        this.price = price;
        this.description = description;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String id) {
        this.productId = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String toString() {
        return "Product[productId=" + productId + ", price=" + price 
            + ", description=" + description + "]";
    }

}
