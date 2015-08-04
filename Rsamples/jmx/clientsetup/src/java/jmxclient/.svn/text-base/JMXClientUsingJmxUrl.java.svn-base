package jmxclient;

import java.util.Set;
import java.util.Iterator;
import java.util.Hashtable;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXServiceURL;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.naming.Context;

/**
 * JMX Client which uses JMX Service URL.
 * RMI Connector should be turned on in JEUS 
 * and the JNDI name of it is required here.
 */
public class JMXClientUsingJmxUrl {

    public static void main(String args[]) throws Exception {
        if(args.length < 4) {
            System.out.println("Required arguments: " 
                + "hostname username password connector-exportname");
            return;
        }
        
        // Step 1. Setting Environments
        String hostname = args[0];
        String username = args[1];
        String password = args[2];

        // the JMX RMIConnector export name specified in the JEUSMain.xml
        String exportName = args[3];
        
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
            "jeus.jndi.JEUSContextFactory");
        env.put(Context.PROVIDER_URL, hostname);
        env.put(Context.SECURITY_PRINCIPAL, username);
        env.put(Context.SECURITY_CREDENTIALS, password);

        // Step 2. Getting MBeanServer
        JMXServiceURL url 
            = new JMXServiceURL("service:jmx:rmi:///jndi/" + exportName);
        JMXConnector connector = JMXConnectorFactory.newJMXConnector(url,env);
        connector.connect();
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
