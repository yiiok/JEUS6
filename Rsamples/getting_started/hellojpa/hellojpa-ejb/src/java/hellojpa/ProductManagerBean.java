package hellojpa;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * ProductManager session bean implementation.
 */
@Stateless(mappedName="hellojpa.ProductManager")
public class ProductManagerBean implements ProductManager {

    @PersistenceContext
    private EntityManager em;
    
    public ProductManagerBean() {
    }

    public Product createProduct(String productId, double price, String desc){
        Product product = new Product(productId, price, desc);
        em.persist(product);
        return product;
    }
    
    public Product getProduct(String productId){
        return (Product)em.find(Product.class, productId);
    }
    
    public Collection findAllProducts() {
        return em.createNamedQuery("findAllProducts").getResultList();
    }

    public Collection findProductsByDescription(String desc){
        Query query = em.createQuery("SELECT p FROM Product p WHERE p.description=:desc");
        query.setParameter("desc", desc);
        return query.getResultList();
    }

    public Collection findProductsInRange(double low, double high){
        Query query = em.createQuery("SELECT p FROM Product p WHERE p.price between :low and :high");
        query.setParameter("low", low).setParameter("high", high);
        return query.getResultList();
    }
    
    public void updateProduct(Product product){
        Product managed = em.merge(product);
        em.flush();
    }
    
    public void removeProduct(Product product){
        Product managed = em.merge(product);
        em.remove(managed);
    }
    
    public void removeAllProducts(){
        em.createQuery("DELETE FROM Product p").executeUpdate();
    }

}
