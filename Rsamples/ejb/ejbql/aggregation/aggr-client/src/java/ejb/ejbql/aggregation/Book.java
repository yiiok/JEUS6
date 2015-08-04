package ejb.ejbql.aggregation;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface Book extends EJBObject {
   public String getTitle() throws RemoteException;

   public void setTitle(String title) throws Exception;

   public String getAuthor() throws RemoteException;

   public void setAuthor(String author) throws RemoteException;

   public double getPrice() throws RemoteException;

   public void setPrice(double price) throws RemoteException;

   public String getPublisher() throws RemoteException;

   public void setPublisher(String publisher) throws RemoteException;

   public String toBookString() throws RemoteException;
}
