package ejb.ejb3.statefulSession;


import javax.ejb.*;


@Stateful(name="counter", mappedName="counter")
public class CounterEJB implements Counter
{
   private int count = 0;


   public void increase()
   {
      count++;
   }

   public void decrease()
   {
      count--;
   }

   public int getCount()
   {
      return count;
   }

	@Remove
   public void remove()
   {
      System.out.println("### Counter is removed. ###");
   }
}
