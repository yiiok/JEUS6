package loginModule;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUtils;

import ejbwork.Admin;
import ejbwork.PublicCall;
import ejbwork.Secret;

import webpages.PageTemplate;

public class MainPage extends HttpServlet{
	public static final long serialVersionUID = 691909L;
	private PrintWriter out ;
	
	public void flush(HttpServletRequest req,HttpServletResponse res)
					throws ServletException,IOException{
		res.setContentType("text/html;charset=euc-kr");
		out = res.getWriter();
		PageTemplate.flushMainPageHeader(out, "JEUS Security Samples", PageTemplate.NO_LINK, PageTemplate.NO_LINK);
		if(req.getParameterMap().size() == 0){
			PageTemplate.flushMainBody(out);
		}else{
			boolean hasEJB = false;
			Enumeration call = req.getParameterNames();
			res.setContentType("text/html;charset=euc-kr");
			String obj = (String) call.nextElement();

			try{
				int base_port = Integer.parseInt(System.getProperty("jeus.baseport","21000"));				
				PublicCall pub = (PublicCall) Calljeus.connect("public", base_port);
				if (obj.equals("public")){
					PageTemplate.flushMessage(out, pub.message());
					hasEJB = true;
				} else if (obj.equals("admin")){
					Admin admin = (Admin) Calljeus.connect("admin", base_port);
					PageTemplate.flushMessage(out, admin.message());
					hasEJB = true;
				} else if (obj.equals("excluded")){
					Secret secret = (Secret) Calljeus.connect("secret", base_port);
					PageTemplate.flushMessage(out, secret.excludedMSG());
					hasEJB = true;
				} else if (obj.equals("secret")){
					PageTemplate.flushMessage(out, pub.callsecret());
					hasEJB = true;
				}
			} catch(Exception e){
				PageTemplate.flushMessage(out, "Authorization Failed(You are not allowd to access this resource");
				out.println("		<tr>");
				out.println("			<td colspan='4' class='tdpadding'>");
				out.println("       <br>Your account is not allowed to this resource<br>");
				out.println(" 		<br>If you want to see this page with same account, modify some xml files to do that<br>");
				out.println("       <br>Reference : web.xml, ejb-jar.xml and security manual<br>");
				out.println("			</td>");
				out.println("		</tr>");
				PageTemplate.flushMainPageTail(out);
				return;
			}
			if(!hasEJB)
				res.sendRedirect("/security/noejb");
		}
		PageTemplate.flushMainPageTail(out);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
						throws ServletException, IOException{
		flush(req,res);				
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
						throws ServletException, IOException{
		flush(req,res);
	}
	
}

