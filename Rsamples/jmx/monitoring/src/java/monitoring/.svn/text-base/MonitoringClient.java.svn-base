/*
 * $Id: MonitoringClient.java 1952 2010-03-11 08:03:26Z bluewolf $
 * Created: Nov 5, 2008
 *
 * Copyright 2008, TmaxSoft Co., Ltd. All Rights Reserved.
 */
package monitoring;

import jeus.jndi.JNSConstants;
import jeus.management.RemoteMBeanServerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.management.MBeanServerConnection;
import java.util.Hashtable;

/**
 * JEUS monitoring sample.
 */
public class MonitoringClient {
    public static void main(String[] args) throws Exception {
        if(args.length < 4) {
            System.out.println("Required arguments: hostname username password target-name");
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

        env.put(Context.INITIAL_CONTEXT_FACTORY, "jeus.jndi.JNSContextFactory");
        env.put(Context.PROVIDER_URL, hostname);
        env.put(Context.SECURITY_PRINCIPAL, username);
        env.put(Context.SECURITY_CREDENTIALS, password);

	InitialContext ic = new InitialContext(env);
        MBeanServerConnection mbeanServer = RemoteMBeanServerFactory.getMBeanServer(env);

        JVMInfo jvmInfo = new JVMInfo();
        jvmInfo.showInfo(mbeanServer, targetName);

        ThreadPoolInfo threadPoolInfo = new ThreadPoolInfo();
        threadPoolInfo.showInfo(mbeanServer, targetName);

        ServletThreadInfo servetThreadInfo = new ServletThreadInfo();
        servetThreadInfo.showInfo(mbeanServer, targetName);

        DBConnectionPoolInfo dbPoolInfo = new DBConnectionPoolInfo();
        dbPoolInfo.showInfo(mbeanServer, targetName);
    }
}
