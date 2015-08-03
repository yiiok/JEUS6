package jmxclient;

import java.util.Set;
import java.util.Iterator;
import java.util.Hashtable;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * JMX Client which uses JNDI lookup.
 */
public class JMXClientUsingJndi {

    public static void main(String args[]) throws Exception {
        if(args.length < 4) {
            System.out.println("Required arguments: " 
                + "hostname username password target-name");
            return;
        }
        
        // Step 1. Setting Environments
        String hostname = args[0];
        String username = args[1];
        String password = args[2];

        // targetName could be node or container name,
        // for example, "johan", "johan_container1"
        String targetName = args[3];
        
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
            "jeus.jndi.JEUSContextFactory");
        env.put(Context.PROVIDER_URL, hostname);
        env.put(Context.SECURITY_PRINCIPAL, username);
        env.put(Context.SECURITY_CREDENTIALS, password);

        // Step 2. Getting MBeanServerConnection
        InitialContext ctx = new InitialContext(env);
        JMXConnector connector 
            = (JMXConnector)ctx.lookup("mgmt/rmbs/" + targetName);
        MBeanServerConnection mbeanServer 
            = connector.getMBeanServerConnection();

        // Step 3. Query
        ObjectName jeusScope = new ObjectName("JEUS:*");
        Set objectNames = mbeanServer.queryNames(jeusScope, null);

        // Step 4. Handling the Query Result
        for(Iterator i = objectNames.iterator(); i.hasNext();) {
            System.out.println("[MBean] " + i.next());
        }
    }
}
