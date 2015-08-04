package ejb.ejb3.statelessSession;

import javax.ejb.EJB;

public class Client
{
   @EJB
   private static Calc calc;

   public static void main(String[] args) throws Exception
   {
      System.out.println("");
      System.out.println("<< Testing Calc EJBBean Using EJB 3.0 Stateless Session Bean >>");
      System.out.println("");

      // add
      System.out.println("Adding 11.11 and 22.22..");

      double result = calc.add(11.11, 22.22);

      System.out.println("result : " + result);

      // modified add
      System.out.println("Adding 11.11 and 22.22..");

      result = calc.modifiedAdd(11.11, 22.22);

      System.out.println("result : " + result);

      // subtract
      System.out.println("Subtracting 22.22 from 11.11..");

      result = calc.subtract(11.11, 22.22);

      System.out.println("result : " + result);

      // multiply
      System.out.println("Multiplying 11.11 by 22.22..");

      result = calc.multiply(11.11, 22.22);

      System.out.println("result : " + result);

      // divide
      System.out.println("Dividing 11.11 by 22.22..");

      result = calc.divide(11.11, 22.22);

      System.out.println("result : " + result);
   }
}
