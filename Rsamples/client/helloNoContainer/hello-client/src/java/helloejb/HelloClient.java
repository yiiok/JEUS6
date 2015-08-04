package helloejb;

import java.io.*;
import javax.ejb.EJB;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Hashtable;

/**
 * HelloEJB application client
 */
public class HelloClient {
    private static Hello hello;
    
    public static void main(String[] args) {
	try {
            	Hashtable env = new Hashtable();
        	env.put(Context.INITIAL_CONTEXT_FACTORY, "jeus.jndi.JNSContextFactory");
        	Context context = new InitialContext(env);
        	hello = (Hello) context.lookup("helloejb.Hello");

        	System.out.println("EJB output : " + hello.sayHello());
	} catch (Exception ex) {
		ex.printStackTrace();
	}
    }
}
