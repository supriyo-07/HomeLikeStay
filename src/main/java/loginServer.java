

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.eclipse.jdt.internal.compiler.ast.AbstractVariableDeclaration;

import com.mysql.cj.exceptions.RSAException;
import com.mysql.cj.xdevapi.Client;

/**
 * Servlet implementation class loginServer
 */
@WebServlet("/loginServer")
public class loginServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String email, password,query,query2,query3;
	int j;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
	    email=req.getParameter("email");
		password=req.getParameter("password");
		
		PrintWriter out= res.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
			Statement stmt = con.createStatement();
			Statement st= con.createStatement();
			Statement state= con.createStatement();
			
			ResultSet r= st.executeQuery( "select join_as from register where email='"+email+"' and password='"+password+"';");
			// If admin logs in using his pre specified username and password
			if(email.equals("hls2229@hls.com") && password.equals("hlspass"))
			{
				
				query = "select * from register;";   //table for the client details
				out.print("<head>");
				out.print("<center>");
				out.print("<img src=hlslogo.jpeg class=\"rounded-circle\" height=\"150px\" width=\"150px\"height=150 width=150>");
				out.print("<title>");
				out.print("ADMIN");
				out.print("</title>"
						+"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
						+ "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n"
						+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n"
						+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
				out.print("</head>");
				out.print("<body>");
				out.print("<h1> Welcome admin : </h1><div class=\"container\">"
						+ "<table class=\"table\">\n"
						+ "    <thead>");
				 out.print("<h3> Client Details: </h3>");
				ResultSet rs= stmt.executeQuery(query);
				java.sql.ResultSetMetaData rsmd=  rs.getMetaData();
				 
				 int totalColumnC= rsmd.getColumnCount();
				 out.print("<tr>");
				 for(int i=1;i<=totalColumnC;i++) {
					 out.print("<th>"+rsmd.getColumnName(i)+"</th>");
					 
				 }
				 out.print("</tr></thread><tbody>");
				 int row=0;
				 while(rs.next()) { row++;
				      if(row%5==1) {
				    	  out.println("<tr class=\"success\">");
				      }
				      else if(row%5==2) {
				    	  out.println("<tr class=\"danger\">");
				      }
				      else if(row%5==3) {
				    	  out.println(" <tr class=\"info\">");
				      }
				      else if(row%5==4) {
				    	  out.println(" <tr class=\"warning\">");
				      }
				      else if(row%5==0) {
				    	  out.println("<tr class=\"active\">");
				      }
					 out.print("<td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td></tr>");
					 }
				 out.print("</tbody></table></div>");
				 Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
					Statement stat= conn.createStatement();
				 query2 = "select * from landlord;";       //table for the landlord details
					
					 out.print("<div class=\"container\">"
					 		+ "<table class=\"table\">\n"
					 		+ "  <thead>");
					 out.print("<h3> Landlord Details: </h3>");
					 ResultSet rs2= stat.executeQuery(query2);
					 java.sql.ResultSetMetaData rsm=  rs2.getMetaData();
					 int totalColumnL= rsm.getColumnCount();
					 out.print("<tr>");
					 for( j=1;j<=totalColumnL;j++) {
						 out.print("<th>"+rsm.getColumnName(j)+"</th>");
						 
					 }
					 out.print("</tr></thread><tbody>");
					int row1=0;
					 while(rs2.next()) { row1++;
						 if(row1%5==1) {
					    	  out.println("<tr class=\"success\">");
					      }
					      else if(row1%5==2) {
					    	  out.println("<tr class=\"danger\">");
					      }
					      else if(row1%5==3) {
					    	  out.println(" <tr class=\"info\">");
					      }
					      else if(row1%5==4) {
					    	  out.println(" <tr class=\"warning\">");
					      }
					      else if(row1%5==0) {
					    	  out.println("<tr class=\"active\">");
					      }
						 out.print("<td>"+rs2.getString(1)+"</td><td>"+rs2.getString(2)+"</td><td>"+rs2.getString(3)+"</td><td>"+rs2.getString(4)+"</td><td>"+rs2.getString(5)+"</td><td>"+rs2.getString(6)+"</td><td>"+rs2.getString(7)+"</td><td>"+rs2.getString(8)+"</td><td>"+rs2.getString(9)+"</td></tr>");
						 }
					 out.print("</tbody></table></div>");
				 
					
					 out.print("<style>\n"
								+ "  .button {\n"
								+ "    border: none;\n"
								+ "    color: white;\n"
								+ "    padding: 19px 65px;\n"
								+ "    text-align: center;\n"
								+ "    text-decoration: none;\n"
								+ "    display: inline-block;\n"
								+ "    font-size: 16px;\n"
								+ "    margin: 6px 2px;\n"
								+ "    cursor: pointer;\n"
								+ "  }\n"
								+ "  .button2 {background-color: #000080;} /* Blue */\n"
								+ "  </style>");
						out.println("<a href=\"login.html\" class=\"button button2\" role=\"button\" aria-pressed=\"true\">LOG OUT</a>");
						
					 out.print("</body>");
				}
					 
				
				
			
			else if(r.next()) {
			
			// If the person is a landlord
			if(r.getString(1).equals("landlord")){
			
				String Q="select * from landlord where email ='"+email+"';";
				ResultSet rSet= st.executeQuery(Q);
				if(rSet.next())
				{
					out.print("<head>"
							+ "<nav class=\"navbar navbar-inverse\">\n"
							+ "    <div class=\"container-fluid\">\n"
							+ "      <div class=\"navbar-header\">\n"
							+ "        <a class=\"navbar-brand\" href=\"#\">Home Like Stay</a>\n"
							+ "      </div>\n"
							+ "      <ul class=\"nav navbar-nav\">\n"
							+ "      <li><a href=\"HOME.html\">Home</a></li>\n"
							+ "      <li><a href=\"contact_us.html\">Contact Us</a></li>\n"
							+ "      \n"
							+ "      </ul>\n"
							+ "    \n"
							+ "    </div>\n"
							+ "  </nav>"
							+ " <div style= \"background-image:url('header2.jpeg');\">     \r\n"
							+ "<a href=\"hlslogo.jpeg\" title=\"click this to view the logo\">\r\n"
							+ "<center> <img src=\"hlslogo.jpeg\" class=\"img-circle\" height=\"150px\" width=\"150px\" ><br><br><br><br></a>\r\n"
							+ "<font face=\"algerian\" size=\"8\" color=\"white\"><b>HOME LIKE STAY.</b></font><br>\r\n"
							+ "<hr align=\"center\" size=\"4%\" color=\"black\">\r\n"
							+ "<title>LaNdLoRd\r\n"
							+ "</title>\r\n"
							+ "<meta charset=\"utf-8\">\r\n"
							+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
							+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n"
							+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\r\n"
							+ "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n"
							+ "<style>\r\n"
							+ "  body {\r\n"
							+ "      position: relative; \r\n"
							+ "  }body {\r\n"
							+ "  height: 1000px;\r\n"
							+ "  background: linear-gradient(141deg, #0fb8ad 0%, #1fc8db 51%, #2cb5e8 75%);\r\n"
							+ "}\r\n"
							+ "  </style></div>\r\n"
							+ "</head> ");
					
					
					
					out.print("<style>\n"
							+ "							body {\n  "
							+ "							  background-image: url('bg4.jpeg');\n"
							+ "							  background-repeat: no-repeat;\n"
							+ "							  background-attachment: fixed;\n"
							+ "							  background-size: cover;\n"
							+ "							}\n"
							+ "							</style><body>"
							+ "<style>\n"
							+ "        #myfooter {\n"
							+ "          background-color: rgb(113, 89, 229);\n"
							+ "  color: rgb(225, 219, 27);\n"
							+ "  padding: 5px;\n"
							+ "  text-align: center;\n"
							+ "} </style>\n"
							+ "        <hr color=\"darkblue\" size=\"2%\">\n"
							+ "        <font size=\"3\" color=\"darkblue\">\n"
							+ "        <marquee id=\"myfooter\"><b> WELCOME LANDLORD .PLEASE PROVIDE US WITH ALL DETAILS....</b>\n"
							+ "        </marquee></font>\n"
							+ "        <hr color=\"darkblue\" size=\"2%\">\n"
							
							+ " <center>");
					out.print("");
					
					out.print("<table width=150 border=5>");
					 out.print("<h3> Previous Details : </h3>");
					java.sql.ResultSetMetaData rsm=  rSet.getMetaData();
					 int totalCol= rsm.getColumnCount();
					 out.print("<tr>");
					 for(j=1;j<=totalCol;j++) {
						 out.print("<th><h3>  "+rsm.getColumnName(j)+"  </h3></th>");
						 
					 }
					 out.print("<tr>");
					 int row1=0;
					 while(rSet.next()) {
						 row1++;
						 if(row1%5==1) {
					    	  out.println("<tr class=\"success\">");
					      }
					      else if(row1%5==2) {
					    	  out.println("<tr class=\"danger\">");
					      }
					      else if(row1%5==3) {
					    	  out.println(" <tr class=\"info\">");
					      }
					      else if(row1%5==4) {
					    	  out.println(" <tr class=\"warning\">");
					      }
					      else if(row1%5==0) {
					    	  out.println("<tr class=\"active\">");
					      }
						 out.print("<tr><td>"+rSet.getString(1)+"</td><td>"+rSet.getString(2)+"</td><td>"+rSet.getString(3)+"</td><td>"+rSet.getString(4)+"</td><td>"+rSet.getString(5)+"</td><td>"+rSet.getString(6)+"</td><td>"+rSet.getString(7)+"</td><td>"+rSet.getString(8)+"</td><td>"+rSet.getString(9)+"</td><td>"+rSet.getString(10)+"</td></tr>");
						 }
				 
					 out.print("</table>"
					 		+ "<center>\n"
					 		+ "        \n"
					 		+ "        <form>\n"
					 		+ "            <font size=\"5\" color=\"darkblue\">\n"
					 		+ "            <table>\n"
					 		+ "              <tr><a href=\"landlord.html\" class=\"btn btn-info btn-lg\">\n"
					 		+ "                <span class=\"glyphicon glyphicon-plus\"></span> ADD MORE\n"
					 		+ "              </a>\n"
					 		+ "            \n"
					 		+ "            \n"
					 		+ "              <a href=\"#\" class=\"btn btn-info btn-lg\">\n"
					 		+ "                <span class=\"glyphicon glyphicon-hand-right\"></span> View apply list\n"
					 		+ "              </a>\n"
					 		+ "            \n"
					 		+ "\n"
					 		+ " \n"
					 		+ "\n"
					 		+ "<br><div class=\"container\" align=\"center\">\n"
					 		+ " <a href =\"login.html\" <button class=\"btn btn-danger btn-lg\"  aria-pressed=\"true\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Logout\"><span class=\"glyphicon glyphicon-log-out\"></span> Log Out</button></a>\n"
					 		+ " </div><BR><BR></tr></table>\n"
					 		+ "  <script>\n"
					 		+ "    $(document).ready(function(){\n"
					 		+ "      $('[data-toggle=\"tooltip\"]').tooltip();   \n"
					 		+ "    });\n"
					 		+ "    </script>\n"
					 		+ "    \n"
					 		+ "      \n"
					 		+ "      \n"
					 		+ "</font> \n"
					 		+ "</form>\n"
					 		+ "</center>\n"
					 		+ "\n"
					 		+ "</body>\n"
					 		+ "</html>");
					 
					 
				}
				else {
			
				   RequestDispatcher reqd= req.getRequestDispatcher("landlord.html");
				   reqd.forward(req, res);
			   }
			}
			// If the person is a client
			else if(r.getString(1).equals("client")) {
			    
					int count=0;
					
				String query1 = "select * from landlord;";
				String query3; 
				//ResultSet result= state.executeQuery(query3);
				
				out.print("<table width=150 border=1>");
				ResultSet rs= st.executeQuery(query1);
				
					out.print(" <!DOCTYPE html>\n"
							+ "<html>\n"
							+ "<head>\n"
							+ "  <nav class=\"navbar navbar-inverse\">\n"
							+ "    <div class=\"container-fluid\">\n"
							+ "      <div class=\"navbar-header\">\n"
							+ "        <a class=\"navbar-brand\" href=\"#\">Home Like Stay</a>\n"
							+ "      </div>\n"
							+ "      <ul class=\"nav navbar-nav\">\n"
							+ "      <li><a href=\"login.html\">Home</a></li>\n"
							+ "      <li><a href=\"#\">Contact Us</a></li>\n"
							+ "      \n"
							+ "      </ul>\n"
							+ "    \n"
							
						
							
							+"<ul>"
							+ "<form class=\"nav navbar-nav navbar-right\" action = \"HomeSearch\" method=\"post\">\n"
							+ "       <div class=\"searchbar\">\n"
							+ "      <form class=\"navbar-form navbar-left\">\n"
							+ "        <div class=\"input-group\">\n"
							+ "          <input type=\"search\" class=\"form-control\" placeholder=\"Search\" name=\"search\">\n"
							+ "         \n"
							+ "         \n"
							+ "          <div class=\"input-group-btn\">\n"
							+ "            <input type=\"submit\" class=\"btn btn-info\" role=\"button\" value=\"Search\">\n"
							+ "              <span class=\"glyphicon glyphicon-search\"><i class=\"fafa-search\" arial-hidden=\"true\"></i></span> Search\n"
							+ "            </button>\n"
							+ "          </div>\n"
							+ "        </div>\n"
							+ "      </form>\n"
							+ "       </div>\n"
							+ "      </ul>"
							+ "    </div>\n"
							+ "  </nav>\n"
							+ "<div style= \"background-image:url('header2.jpeg');\">\n"
							+ "<a href=\"hlslogo.jpeg\" title=\"click this to view the logo\">\n"
							+ "<center> <img src=\"hlslogo.jpeg\" class=\"img-circle\" height=\"150px\" width=\"150px\" ><br><br><br><br></a>\n"
							+ "<font face=\"algerian\" size=\"8\" color=\"white\"><b>HOME LIKE STAY.</b></font><br>\n"
							+ "<hr align=\"center\" size=\"4%\" color=\"black\">\n"
							+ "<title>WeLcOmE_cLiEnT\n"
							+ "</title>\n"
							+ "<meta charset=\"utf-8\">\n"
							+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
							+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n"
							+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n"
							+ "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n"
							+ "<style>\n"
							+ "  body {\n"
							+ "      position: relative; \n"
							+ "  }\n"
							+ "  </style>\n"
							+ "\n"
							+ "</head>\n"
							+ "</div>\n"
							+ "\n"
							+ "<style>\n"
							+ "body {\n"
							+ "  background-image: url('bg4.jpeg');\n"
							+ "  background-repeat: no-repeat;\n"
							+ "  background-attachment: fixed;  \n"
							+ "  background-size: cover;\n"
							+ "}\n"
							+ "</style>\n"
							+ "<body data-spy=\"scroll\" data-target=\".navbar\" data-offset=\"50\">\n"
							+ " <div> <style>\n"
							+ "    #myfooter {\n"
							+ "    \n"
							+ "          background-color:rgb(113, 89, 229);\n"
							+ "  color: rgb(225, 219, 27);\n"
							+ "  padding: 10px;\n"
							+ "  text-align: center;\n"
							+ "    } \n"
							+ "    </style>\n"
							+ "\n"
							+ "    <marquee id=\"myfooter\"><b> HERE YOU WILL FIND THE ROOM OF YOUR PREFERENCE....</b></marquee>\n"
							+ "  </div> <br>\n"
							+ "  <form >\n"
							+ "      \n"
							+ "\n"
							+ "  \n"
							+ "\n"
							+ "\n"
							+ "<font align=\"left\">\n"
							+ "\n"
							+ "\n"
							+ "</table>\n"
							+ "<font size=\"5\" color=\"darkblue\">\n"
							+ " \n"
							+ "\n"
							+ "  <style>\n"
							+ "  table, th,td{ \n"
							+ "   border: 3px;\n"
							+ "   padding: 5px;\n"
							+ "  }\n"
							
							+ "    body {\n"
							+ "      font-family: Arial, Helvetica, sans-serif;\n"
							+ "    }\n"
							+ "    \n"
							+ "    .flip-card {\n"
							+ "      background-color: transparent;\n"
							+ "      width: 300px;\n"
							+ "      height: 300px;\n"
							+ "      perspective: 1000px;\n"
							+ "    }\n"
							+ "    \n"
							+ "    .flip-card-inner {\n"
							+ "      position: relative;\n"
							+ "      width: 100%;\n"
							+ "      height: 100%;\n"
							+ "      text-align: center;\n"
							+ "      transition: transform 0.6s;\n"
							+ "      transform-style: preserve-3d;\n"
							+ "      box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);\n"
							+ "    }\n"
							+ "    \n"
							+ "    .flip-card:hover .flip-card-inner {\n"
							+ "      transform: rotateY(180deg);\n"
							+ "    }\n"
							+ "    \n"
							+ "    .flip-card-front, .flip-card-back {\n"
							+ "      position: absolute;\n"
							+ "      width: 100%;\n"
							+ "      height: 100%;\n"
							+ "      -webkit-backface-visibility: hidden;\n"
							+ "      backface-visibility: hidden;\n"
							+ "    }\n"
							+ "    \n"
							+ "    .flip-card-front {\n"
							+ "      background-color: rgb(228, 242, 149);\n"
							+ "      color: black;\n"
							+ "    }\n"
							+ "    \n"
							+ "    .flip-card-back {\n"
							+ "      background-color: #35c76d;\n"
							+ "      color: white;\n"
							+ "      transform: rotateY(180deg);\n"
							+ "    }\n"
							+ "    </style>\n"
							+ "    </head>\n"
							+ "    <body><h3>Hover over to apply:</h3>\n<table cellpadding=\"5\" cellspacing=\"12\">"
							+ "");
							out.print("<tr>");
							 out.print("\n"
								 
								 		+ "<td><div class=\"flip-card\">\n"
								 		+ "      <div class=\"flip-card-inner\">\n"
								 		+ "        <div class=\"flip-card-front\">\n"
								 		+ "        <p> <h4><font color=\"blue\"><u>HAPPY SEARCHING !!!</font></u>\n"
								 				
								 		+ "        </div>\n"
								 		+ "        <div class=\"flip-card-back\">\n"
								 		+ "          <h4><font color=\"red\"><u>HOME LIKE STAY...</u> </font>\n"
								 	
								 				
								 				
								 		
								 		+ "    </div>"
								 		
								 		+ "     </td>\n");
							             count++;
						  
							HttpSession session= req.getSession();
							
							while(rs.next()){
								 
									 
								
								 query3="select contact from register where email='"+rs.getString(1)+"';";
								 ResultSet result= state.executeQuery(query3);
								 count++;
								 result.next();
								
								 session.setAttribute("C", email);
								 out.print("\n"
								 		+ "<form action=\"apply\" method=\"post\">"
								 		+ "<td><div class=\"flip-card\">\n"
								 		+ "      <div class=\"flip-card-inner\">\n"
								 		+ "        <div class=\"flip-card-front\">\n"
								 		+ "        <p> <h4><font color=\"blue\"><u>"+rs.getString(3)+ "</font></u>\n"
								 				+ "<p> <h4>"+rs.getString(2)+"\n"
								 						+ "<p> <h4>Nearby Transport Facilities:<br> \n"+rs.getString(8)+"\n"
								 								+ "<p> <h4>\n"+rs.getString(9)+"\n"
								 		+ "        </div>\n"
								 		+ "        <div class=\"flip-card-back\">\n"
								 		+ "          <h4><font color=\"red\"><u>CONTACT DETAILS:</u> </font>\n"
								 		+ "          <p>Email: </p>"+rs.getString(1)+" \n"
								 		+ "          <p>CONTACT NO: "+result.getString(1)+"</p>"
								 			+ "<p> RENT PER MONTH: "+rs.getString(10)+"</p>\n"
								 				
								 				
								 		+ "<button name= \"hname\" value="+rs.getString(3)+" class=\"btn btn-danger \" role=\"button\" aria-pressed=\"true\" data-toggle=\"tooltip\" title=\"Click Apply\">APPLY</button></div>\n");
								
								  // session.setAttribute("C", email);
								 		out.print("  "
								 		+ "      </div>\n"
								 		+ "    </div>"
								 		
								 		+ "     </td></form>\n"
								 		+ "  ");
								// out.print("\t");
								
								   if(count%4==0)
									   out.print("</tr>");
								     
								 
									   
								 };
							 out.print("</tr></table><div class=\"container\" align=\"center\">\n"
							 		+ "    <a href=\"login.html\" class=\"btn btn-primary btn-lg\" role=\"button\" aria-pressed=\"true\" data-toggle=\"tooltip\" title=\"Click to Log Out\">LOG OUT</a>\n"
							 		+ "   </div><br><br>  \n"
							 		+ "   <script>\n"
							 		+ "    $(document).ready(function(){\n"
							 		+ "      $('[data-toggle=\"tooltip\"]').tooltip();   \n"
							 		+ "    });\n"
							 		+ "    </script> \n"
							 		+ "   \n"
							 		+ "     \n"
							 		+ "</center>\n"
							 		+ "\n"
							 		+ "</body>\n"
							 		+ "</html>");
							 }
							
						
											
				}
			
				
		 else {
			 out.print("<head>");
			 out.print("<center>");
				out.print("<img src=hlslogo.jpeg class=\"rounded-circle\" height=\"150px\" width=\"150px\" height=150 width=150>");
				out.print("<title>");
				out.print("ERROR");
				out.print("</title>");
				out.print("</head>");
				
				out.print("<body>");
				out.print("<style>\n"
						+ "body {\n"
						+ "  background-image: url('bg4.jpeg');\n"
						+ "  background-repeat: no-repeat;\n"
						+ "  background-attachment: fixed; \n"
						+ "  background-size: cover;\n"
						+ "}\n"
						+ "</style>");
			out.println("<h2>Login FAILED!!!Enter correct Email and Password<h2>");
			out.print("<style>\n"
					+ "  .button {\n"
					+ "    border: none;\n"
					+ "    color: white;\n"
					+ "    padding: 19px 65px;\n"
					+ "    text-align: center;\n"
					+ "    text-decoration: none;\n"
					+ "    display: inline-block;\n"
					+ "    font-size: 16px;\n"
					+ "    margin: 6px 2px;\n"
					+ "    cursor: pointer;\n"
					+ "  }\n"
					+ "  .button2 {background-color: #000080;} /* Blue */\n"
					+ "  </style>");
			out.println("<a href=\"login.html\" class=\"button button2\" role=\"button\" aria-pressed=\"true\">CLICK HERE TO GO BACK</a>");
			}
			
				
			}catch(Exception e) {
			out.println(e);
		}
	}

}
