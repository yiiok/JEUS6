package helloejb;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.applet.Applet;
import java.util.Hashtable;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class HelloClient extends JApplet {
    public void start() {
        try {
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "jeus.jndi.JNSContextFactory");
            Context context = new InitialContext(env);
            Hello hello = (Hello) context.lookup("helloejb.Hello");
       	    System.out.println("EJB output : " + hello.sayHello());

   	    JLabel label = new JLabel(hello.sayHello());
      	    label.setFont(new Font("Helevetica", Font.BOLD, 15));
            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(label, BorderLayout.CENTER);
            setSize(500, 250);
            setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
