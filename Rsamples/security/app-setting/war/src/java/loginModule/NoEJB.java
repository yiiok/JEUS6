package loginModule;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webpages.PageTemplate;

public class NoEJB extends HttpServlet{
	public static final long serialVersionUID = -12391L;
	public void flush(HttpServletRequest req,HttpServletResponse res)
						throws ServletException,IOException{
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		PageTemplate.flushMainPageHeader(out, "JEUS Security Samples", PageTemplate.NO_LINK, PageTemplate.NO_LINK);
		PageTemplate.flushMessage(out, "Ejb module did not deploy");
		PageTemplate.flushMainPageTail(out);
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		flush(req,res);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		flush(req,res);
	}
}
