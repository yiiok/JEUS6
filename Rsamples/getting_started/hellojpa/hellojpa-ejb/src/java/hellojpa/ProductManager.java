
package hellojpa;

import java.util.Collection;
import javax.ejb.Local;


/**
 * This is the business interface for ProductManager enterprise bean.
 */
@Local
public interface ProductManager {
    Product createProduct(String productId, double price, String desc);
    
    Product getProduct(String productId);
    
    Collection findAllProducts();
    
    Collection findProductsByDescription(String desc);

    Collection findProductsInRange(double low, double high);
    
    void updateProduct(Product product);
    
    void removeProduct(Product product);
    
    void removeAllProducts();
}
