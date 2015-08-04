package webpages;

import java.io.PrintWriter;

public class  PageTemplate{
	public final static String NO_LINK = null;
	public static void flushMainPageHeader(PrintWriter out, String headTitle, String subLink, String subLinkTitle){
		out.println("<html>");
		out.println("<head>");
		out.println("	<title>"+headTitle+"</title>");
		out.println("	<link rel='stylesheet' type='text/css' href='infolink.css'>");
		out.println("</head>");
		out.println("<body BGCOLOR='#FFFFFF' TEXT='#000000' LINK='#0000EE' VLINK='#551A8B' ALINK='#FF0000' leftmargin='0' topmargin='0' marginwidth='0' marginheight='0'>");
		out.println("	<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
		out.println("		<tr>");
		out.println("			<td height='67' background='images/bgColor.gif'><img src='images/logo.gif' width='237' height='67'></td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td height='11' background='images/bgline.gif'></td>");
		out.println("		</tr>");
		out.println("	</table>");
		out.println("	<br>");
		out.println("	<table width='760' border='0' align='left' cellpadding='1' cellspacing='1' bgcolor='#FFFFFF'>	");
		out.println("		<tr bgcolor=\"#999999\"> ");
		out.println("			<td  width=\"30%\" height=\"27\" align=\"center\" onMouseover=\"this.style.backgroundColor='#0099cc'\" onMouseout=\"this.style.backgroundColor='#999999'\"> ");
		out.println("				<a href=\"/security/mainpage\"><b><font color=\"#FFFFFF\" face=\"Arial\">home</font></b></a>");
		out.println("			</td>");
		out.println("			<td  width=\"40%\" align=\"center\" onMouseover=\"this.style.backgroundColor='#0099cc'\" onMouseout=\"this.style.backgroundColor='#999999'\">");
		if(subLink != NO_LINK && !subLink.trim().equals(""))
			out.println("				<a href=\""+subLink+"\"><b><font color=\"#FFFFFF\" face=\"Arial\">"+subLinkTitle+"</font></b></a>");
		out.println("			</td>	");
		out.println("			<td  width=\"30%\" align=\"center\" onMouseover=\"this.style.backgroundColor='#0099cc'\" onMouseout=\"this.style.backgroundColor='#999999'\"></td>");
		out.println("		</tr> ");
	}

	public static void flushMessage(PrintWriter out, String message){
		out.println("		<tr>");
		out.println("			<td colspan='4' class='tdpadding'>");
		out.println("				<br><h3>"+message+"</h3><br>");
		out.println("			</td>");
		out.println("		</tr>");

	}

	public static void flushMainPageTail(PrintWriter out){
		out.println("	</table>");
		out.println("</body>");
		out.println("</html>");
	}

	public static void flushMainBody(PrintWriter out){
		out.println("		<tr>");
		out.println("			<td colspan='4' class='tdpadding'>");
		out.println("				<br><h3>JEUS Security Sample</h3>");
		out.println("				We offer this sample for the purpose of seeing how security configuration is working in war or ejb module <Br>");
		out.println("				Web urls and ejb methods are the resources needs to access control ");
		out.println("				<br>				");
		out.println("			</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td colspan='4' class='tdpadding'>");
		out.println("				<br><h3>Servlet Sample</h3>");
		out.println("			</td>");
		out.println("		</tr>");
		out.println("		<tr bgcolor='#046FB2'>");
		out.println("			<td  width=\"30%\" align=\"center\" >");
		out.println("				<b><font color='#FFFFFF' face='Arial'>servlet-name</font></b>");
		out.println("			</td>");
		out.println("			<td  width=\"40%\" align=\"center\">");
		out.println("				<b><font color='#FFFFFF'><b>authorization</b></font>");
		out.println("			</td>");
		out.println("			<td  width=\"30%\" align=\"center\"><b><font color='#FFFFFF'>servlet-class</b></font>");
		out.println("			</td>");
		out.println("		</tr>");
		out.println("		<tr bgcolor='#999999' onMouseover=\"this.style.backgroundColor='#0099cc'\" onMouseout=\"this.style.backgroundColor='#999999'\">");
		out.println("			<td align=\"center\">");
		out.println("				<a href='/security/unchecked'><b><font color='#FFFFFF' face='Arial'>unchecked</font></b></a>");
		out.println("			</td>");
		out.println("			<td align=\"center\">");
		out.println("				<b><font color='#FFFFFF'><b>unchecked</b></font>");
		out.println("			</td>");
		out.println("			<td align=\"center\"><b><font color='#FFFFFF'>webpages.JoinUs</b></font>");
		out.println("			</td>");
		out.println("		</tr>");
		out.println("		<tr bgcolor='#999999' onMouseover=\"this.style.backgroundColor='#0099cc'\" onMouseout=\"this.style.backgroundColor='#999999'\">");
		out.println("			<td align=\"center\">");
		out.println("				<a href='/security/checked'><b><font color='#FFFFFF' face='Arial'>checked</font></b></a>");
		out.println("			</td>");
		out.println("			<td align=\"center\">");
		out.println("				<b><font color='#FFFFFF'><b>checked</b></font>");
		out.println("			</td>");
		out.println("			<td align=\"center\"><b><font color='#FFFFFF'>webpages.OnlyOne</b></font>");
		out.println("			</td>");
		out.println("		</tr>");
		out.println("		<tr bgcolor='#999999' onMouseover=\"this.style.backgroundColor='#0099cc'\" onMouseout=\"this.style.backgroundColor='#999999'\">");
		out.println("			<td align=\"center\">");
		out.println("				<a href='/security/excluded'><b><font color='#FFFFFF' face='Arial'>excluded</font></b></a>");
		out.println("			</td>");
		out.println("			<td align=\"center\">");
		out.println("				<b><font color='#FFFFFF'><b>excluded</b></font>");
		out.println("			</td>");
		out.println("			<td align=\"center\"><b><font color='#FFFFFF'>webpages.WithYou</b></font>");
		out.println("			</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td colspan='4' class='tdpadding'>");
		out.println("				<br><h3>EJB Sample</h3>");
		out.println("			</td>");
		out.println("		</tr>");
		out.println("		<tr bgcolor='#046FB2' >");
		out.println("			<td  width=\"30%\" align=\"center\" >");
		out.println("				<b><font color='#FFFFFF' face='Arial'>method-name</font></b>");
		out.println("			</td>");
		out.println("			<td  width=\"40%\" align=\"center\">");
		out.println("				<b><font color='#FFFFFF'><b>authorization</b></font>");
		out.println("			</td>");
		out.println("			<td  width=\"30%\" align=\"center\"><b><font color='#FFFFFF'>ejb-name</b></font>");
		out.println("			</td>");
		out.println("		</tr>");
		out.println("		<tr bgcolor='#999999' onMouseover=\"this.style.backgroundColor='#0099cc'\" onMouseout=\"this.style.backgroundColor='#999999'\">");
		out.println("			<td align=\"center\">");
		out.println("				<a href='/security/mainpage?public'><b><font color='#FFFFFF' face='Arial'>message</font></b></a>");
		out.println("			</td>");
		out.println("			<td align=\"center\">");
		out.println("				<b><font color='#FFFFFF'><b>unchecked</b></font>");
		out.println("			</td>");
		out.println("			<td align=\"center\"><b><font color='#FFFFFF'>ejbwork.PublicCall</b></font>");
		out.println("			</td>");
		out.println("		</tr>");
		out.println("		<tr bgcolor='#999999' onMouseover=\"this.style.backgroundColor='#0099cc'\" onMouseout=\"this.style.backgroundColor='#999999'\">");
		out.println("			<td align=\"center\">");
		out.println("				<a href='/security/mainpage?admin'><b><font color='#FFFFFF' face='Arial'>message</font></b></a>");
		out.println("			</td>");
		out.println("			<td align=\"center\">");
		out.println("				<b><font color='#FFFFFF'><b>checked</b></font>");
		out.println("			</td>");
		out.println("			<td align=\"center\"><b><font color='#FFFFFF'>ejbwork.Admin</b></font>");
		out.println("			</td>");
		out.println("		</tr>");
		out.println("		<tr bgcolor='#999999' onMouseover=\"this.style.backgroundColor='#0099cc'\" onMouseout=\"this.style.backgroundColor='#999999'\">");
		out.println("			<td align=\"center\">");
		out.println("				<a href='/security/mainpage?excluded'><b><font color='#FFFFFF' face='Arial'>excludedMSG</font></b></a>");
		out.println("			</td>");
		out.println("			<td align=\"center\">");
		out.println("				<b><font color='#FFFFFF'><b>excluded</b></font>");
		out.println("			</td>");
		out.println("			<td align=\"center\"><b><font color='#FFFFFF'>ejbwork.Secret</b></font>");
		out.println("			</td>");
		out.println("		</tr>");
		out.println("		<tr bgcolor='#999999' onMouseover=\"this.style.backgroundColor='#0099cc'\" onMouseout=\"this.style.backgroundColor='#999999'\">");
		out.println("			<td align=\"center\">");
		out.println("				<a href='/security/mainpage?secret'><b><font color='#FFFFFF' face='Arial'>callsecret</font></b></a>");
		out.println("			</td>");
		out.println("			<td align=\"center\">");
		out.println("				<b><font color='#FFFFFF'><b>applied run-as</b></font>");
		out.println("			</td>");
		out.println("			<td align=\"center\"><b><font color='#FFFFFF'>ejbwork.PublicCall</b></font>");
		out.println("			</td>");
		out.println("		</tr>");
		//dlehddnr2008-03-18
	}
}
