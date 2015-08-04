package hellojpa;

import java.io.*;
import java.util.Collection;
import javax.ejb.EJB;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * ProductManager client.
 */
public class ProductManagerClient extends HttpServlet {
    @EJB
    private ProductManager productManager;
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("SERVLET CLIENT CONSOLE OUTPUT:\n");
        
        productManager.removeAllProducts();
        out.println("Cleaned up existing products.\n");
        
        out.println("Creating products...");
        Product p1 = productManager.createProduct("1", 10.00, "Ceramic Dog");
        Product p2 = productManager.createProduct("2", 13.00, "Wooden Duck");
        Product p3 = productManager.createProduct("3", 19.00, "Ivory Cat");
        Product p4 = productManager.createProduct("4", 33.00, "Ivory Cat");
        Product p5 = productManager.createProduct("5", 22.00, "Chrome Fish");
        
        Collection products;

        out.println("Created products:");
        products = productManager.findAllProducts();
        for(Object product : products){
            out.println(product);
        }
        out.println();
        
        out.println("Find product with productId 1:");
        Product pp1 = productManager.getProduct("1");
        out.println("Found = " + pp1.getDescription() + " $" + pp1.getPrice());
        
        out.println("Update the price of this product to 12.00");
        pp1.setPrice(12.00);
        productManager.updateProduct(pp1);
        
        Product pp2 = productManager.getProduct("1");
        out.println("Product " + pp2.getDescription() + " is now $" + pp2.getPrice());
        out.println();
        
        out.println("Find products with description:");
        products = productManager.findProductsByDescription("Ivory Cat");
        for(Object product : products){
            out.println(product);
        }
        out.println();
        
        out.println("Find products with price range between 10.00 and 20.00");
        products = productManager.findProductsInRange(10.00, 20.00);
        for(Object product : products){
            out.println(product);
        }
        out.println();
        
        out.println("Removed all products.");
        productManager.removeProduct(p1);
        productManager.removeProduct(p2);
        productManager.removeProduct(p3);
        productManager.removeProduct(p4);
        productManager.removeProduct(p5);
        
        out.close();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
