
package helloejb;

import javax.ejb.Remote;


/**
 * This is the business interface for Hello enterprise bean.
 */
@Remote
public interface Hello {
    String sayHello();
}
