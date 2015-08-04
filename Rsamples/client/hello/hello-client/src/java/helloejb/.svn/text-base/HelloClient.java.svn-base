package helloejb;

import java.io.*;
import javax.ejb.EJB;

/**
 * HelloEJB application client
 */
public class HelloClient {
    @EJB
    private static Hello hello;
    
    public static void main(String[] args) {
        System.out.println("EJB output : " + hello.sayHello());
    }
}
