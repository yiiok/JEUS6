package webpages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import jeus.security.base.Subject;
import jeus.security.spi.LoginService;

public class OnlyOne extends HttpServlet{
	public static final long serialVersionUID = 12384213L;
	
	public void flush(HttpServletRequest req, HttpServletResponse res)
						throws ServletException,IOException{
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		PageTemplate.flushMainPageHeader(out, "JEUS Security Samples", PageTemplate.NO_LINK, PageTemplate.NO_LINK);
		PageTemplate.flushMessage(out, "Only allowed to administrators");
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
