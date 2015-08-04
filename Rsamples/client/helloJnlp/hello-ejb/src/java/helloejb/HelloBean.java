/*
 * HelloBean.java
 *
 * Created on June 20, 2006, 7:45 PM
 */

package helloejb;

import javax.ejb.Stateless;

/**
 * Hello bean implementation.
 *
 * @author Wonseok Kim (guruwons@tmax.co.kr)
 */
@Stateless(mappedName="helloejb.Hello")
public class HelloBean implements Hello {

    public String sayHello() {
        return "Hello EJB!";
    }
    
}
