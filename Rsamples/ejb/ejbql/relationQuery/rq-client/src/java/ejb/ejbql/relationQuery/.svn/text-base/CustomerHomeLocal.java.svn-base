package ejb.ejbql.relationQuery;

import java.util.*;

import javax.ejb.*;

import ejb.ejbql.relationQuery.CustomerLocal;


public interface CustomerHomeLocal extends EJBLocalHome
{
   public CustomerLocal create(Integer id, String name) throws CreateException, EJBException;

   public CustomerLocal findByPrimaryKey(Integer id) throws FinderException, EJBException;

   public Collection findAll() throws FinderException, EJBException;
}
