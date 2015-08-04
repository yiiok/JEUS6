package loginModule;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Hashtable;

public class Calljeus {
	
	public static Object connect(String name,int host) throws NamingException,IOException{
		Context ctx;
		Hashtable<String , Object> env = new Hashtable<String, Object>();
		InetAddress local = InetAddress.getLocalHost();
		String address = local.getHostAddress();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "jeus.jndi.JNSContextFactory");
		env.put(Context.URL_PKG_PREFIXES, "jeus.jndi.jns.url");
		env.put(Context.PROVIDER_URL,address+":"+host);	
		ctx = new InitialContext(env);
		Object obj = ctx.lookup(name);
		ctx.close();
		return obj;
	}			
}