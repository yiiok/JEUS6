package webpages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jeus.security.base.Subject;
import jeus.security.spi.LoginService;
import webpages.PageTemplate;

public class JoinUs extends HttpServlet{
	public static final long serialVersionUID = 29131023L;
	
	public void flush(HttpServletRequest req,HttpServletResponse res)
						throws ServletException,IOException{
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		PageTemplate.flushMainPageHeader(out, "JEUS Security Samples", "/security/excluded", "excluded");
		PageTemplate.flushMessage(out, "This page is allowed to all");
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
