package ejb.ejb3.statelessSession;

import javax.ejb.Stateless;

@Stateless
public class CalcEJB3 implements Calc // Don't implement SessionBean interface
{
    public double modifiedAdd(double x, double y)
    {
        return x + y;
    }

    public double add(double x, double y)
    {
        return x + y;
    }

    public double subtract(double x, double y)
    {
        return x - y;
    }

    public double multiply(double x, double y)
    {
        return x * y;
    }

    public double divide(double x, double y)
    {
        return x / y;
    }
    
//
// Call back methods are deprecated in EJB 3
//    public void ejbCreate()
//    {
//    }
//
//    public void ejbRemove()
//    {
//    }
//
//    public void ejbActivate()
//    {
//    }
//
//    public void ejbPassivate()
//    {
//    }
//
//    public void setSessionContext(SessionContext ctx)
//    {
//    }
}
