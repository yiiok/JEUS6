package jmxclient;

import java.util.Set;
import java.util.Iterator;
import java.util.Hashtable;
import javax.management.ObjectName;
import javax.management.MBeanServerConnection;
import javax.naming.Context;

/**
 * JMX Client which uses JEUS utility class.
 */
public class JMXClientUsingJeusUtility {

    public static void main(String args[]) throws Exception {
        if(args.length < 3) {
            System.out.println("Required arguments: hostname username password");
            return;
        }
        
        // Step 1. Setting Environments
        String hostname = args[0];
        String username = args[1];
        String password = args[2];

        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
            "jeus.jndi.JEUSContextFactory");
        env.put(Context.PROVIDER_URL, hostname);
        env.put(Context.SECURITY_PRINCIPAL, username);
        env.put(Context.SECURITY_CREDENTIALS, password);

        // Step 2. Getting MBeanServer
        MBeanServerConnection mbeanServer 
            = jeus.management.RemoteMBeanServerFactory.getMBeanServer(env);

        // Step 3. Query
        ObjectName jeusScope = new ObjectName("JEUS:*");
        Set objectNames = mbeanServer.queryNames(jeusScope, null);

        // Step 4. Handling the Query Result
        for(Iterator i = objectNames.iterator(); i.hasNext();) {
            System.out.println("[MBean] " + i.next());
        }
    }
}
