package ejb.ejb3.statefulSession;

import java.rmi.*;

import javax.naming.*;

import javax.rmi.*;


public class Client
{
   public static void main(String[] args) throws Exception
   {
      Object objref;
      Context initial = new InitialContext();


      System.out.println("");
      System.out.println("<< Testing EJB 3 Stateful Session Bean >>");
      System.out.println("");
      
      objref = initial.lookup("counter");

      Counter counter1 = (Counter)PortableRemoteObject.narrow(objref, Counter.class);

      System.out.println("counter1(first value) : " + counter1.getCount());
      counter1.increase();

      System.out.println("counter1(after increasing once) : " + counter1.getCount());
      counter1.decrease();

      System.out.println("counter1(after decreasing once) : " + counter1.getCount());
      for (int i = 0; i < 20; i++)
      {
         counter1.increase();
      }

      System.out.println("counter1(after increasing 20 times) : " + counter1.getCount());
      System.out.println("");

		
		objref = initial.lookup("counter");
      Counter counter2 = (Counter)PortableRemoteObject.narrow(objref, Counter.class);
      System.out.println("counter2(first value) : " + counter2.getCount());

      counter2.increase();

      System.out.println("counter2(after increasing once) : " + counter2.getCount());
      System.out.println("cf) counter1 : " + counter1.getCount());
      System.out.println("");

      counter1.decrease();
      counter1.decrease();

      System.out.println("counter1(after decreasing twice) : " + counter1.getCount());
      System.out.println("cf) counter2 : " + counter2.getCount());

      counter1.remove();
      counter2.remove();
   }
}
