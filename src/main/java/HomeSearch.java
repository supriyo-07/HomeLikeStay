

import javax.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeSearch
 */
@WebServlet("/HomeSearch")
public class HomeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String query2;
	   String loc=request.getParameter("search");
	   PrintWriter out= response.getWriter();
	   try {
		   
		   Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
			Statement st= con.createStatement();
			Statement state= con.createStatement();
			ResultSet r= st.executeQuery( "select * from landlord where location = '"+loc+"';");
			if(!r.next())
			{
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
				out.println("<h2>NO RECORD FOUND for "+loc+"<h2>");
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
			else {
				int count=0;
				String query1 = "select * from landlord where location= '"+loc+"';";
				out.print("<table width=150 border=1>");
				ResultSet rs= st.executeQuery(query1);
		
				out.print("<!DOCTYPE html>\n"
						+ "							<html>\n"
						+ "							 <head>\n"
						+ "							   <nav class=\"navbar navbar-inverse\">\n"
						+ "							     <div class=\"container-fluid\">\n"
						+ "							       <div class=\"navbar-header\">\n"
						+ "							         <a class=\"navbar-brand\" href=\"#\">Home Like Stay</a>\n"
						+ "							       </div>\n"
						+ "							       <ul class=\"nav navbar-nav\">\n"
						+ "							       <li><a href=\"login.html\">Home</a></li>\n"
						+ "							       <li><a href=\"#\">Contact Us</a></li>\n"
						+ "							       \n"
						+ "							       </ul>\n"
						+ "							     \n"
						+ "						\n"
						+ "							\n"
						+ "							\n"
						
						+ "							       </form>\n"
						+ "							        </div>\n"
						+ "							     </div>\n"
						+ "							   </nav>\n"
						+ "							 <div style= \"background-image:url('header2.jpeg');\">\n"
						+ "							 <a href=\"hlslogo.jpeg\" title=\"click this to view the logo\">\n"
						+ "							 <center> <img src=\"hlslogo.jpeg\" class=\"img-circle\" height=\"150px\" width=\"150px\" ><br><br><br><br></a>\n"
						+ "							 <font face=\"algerian\" size=\"8\" color=\"white\"><b>HOME LIKE STAY.</b></font><br>\n"
						+ "							 <hr align=\"center\" size=\"4%\" color=\"black\">\n"
						+ "							 <title>WeLcOmE_cLiEnT\n"
						+ "							 </title>\n"
						+ "							 <meta charset=\"utf-8\">\n"
						+ "							 <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
						+ "							 <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n"
						+ "							 <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n"
						+ "							 <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n"
						+ "							 <style>\n"
						+ "							   body {\n"
						+ "							       position: relative; \n"
						+ "							   }\n"
						+ "							   </style>\n"
						+ "							 \n"
						+ "							 </head>\n"
						+ "							 </div>\n"
						+ "							 \n"
						+ "							 <style>\n"
						+ "							 body {\n"
						+ "							   background-image: url('bg4.jpeg');\n"
						+ "							   background-repeat: no-repeat;\n"
						+ "							   background-attachment: fixed;  \n"
						+ "							   background-size: cover;\n"
						+ "							 }\n"
						+ "							 </style>\n"
						+ "							 <body data-spy=\"scroll\" data-target=\".navbar\" data-offset=\"50\">\n"
						+ "							  <div> <style>\n"
						+ "							     #myfooter {\n"
						+ "							     \n"
						+ "							           background-color:rgb(113, 89, 229);\n"
						+ "							   color: rgb(225, 219, 27);\n"
						+ "							   padding: 10px;\n"
						+ "							   text-align: center;\n"
						+ "							     } \n"
						+ "							     </style>\n"
						+ "							 \n"
						+ "							     <marquee id=\"myfooter\"><b> HERE YOU WILL FIND THE ROOM OF YOUR PREFERENCE....</b></marquee>\n"
						+ "							   </div> <br>\n"
						+ "							   <form >\n"
						+ "							       \n"
						+ "							 \n"
						+ "							   \n"
						+ "							 \n"
						+ "							 \n"
						+ "							 <font align=\"left\">\n"
						+ "							 \n"
						+ "							 \n"
						+ "							 </table>\n"
						+ "							 <font size=\"5\" color=\"darkblue\">\n"
						+ "							  \n"
						+ "							 \n"
						+ "							   <style>\n"
						+ "							   table, th,td{ \n"
						+ "							    border: 3px;\n"
						+ "							    padding: 5px;\n"
						+ "							   }\n"
						+ "							\n"
						+ "							     body {\n"
						+ "							       font-family: Arial, Helvetica, sans-serif;\n"
						+ "							     }\n"
						+ "							     \n"
						+ "							     .flip-card {\n"
						+ "							       background-color: transparent;\n"
						+ "							       width: 300px;\n"
						+ "							       height: 300px;\n"
						+ "							       perspective: 1000px;\n"
						+ "							     }\n"
						+ "							     \n"
						+ "							     .flip-card-inner {\n"
						+ "							       position: relative;\n"
						+ "							       width: 100%;\n"
						+ "							       height: 100%;\n"
						+ "							       text-align: center;\n"
						+ "							       transition: transform 0.6s;\n"
						+ "							       transform-style: preserve-3d;\n"
						+ "							       box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);\n"
						+ "							     }\n"
						+ "							     \n"
						+ "							     .flip-card:hover .flip-card-inner {\n"
						+ "							       transform: rotateY(180deg);\n"
						+ "							     }\n"
						+ "							     \n"
						+ "							     .flip-card-front, .flip-card-back {\n"
						+ "							       position: absolute;\n"
						+ "							       width: 100%;\n"
						+ "							       height: 100%;\n"
						+ "							       -webkit-backface-visibility: hidden;\n"
						+ "							       backface-visibility: hidden;\n"
						+ "							     }\n"
						+ "							     \n"
						+ "							     .flip-card-front {\n"
						+ "							       background-color: rgb(228, 242, 149);\n"
						+ "							       color: black;\n"
						+ "							     }\n"
						+ "							     \n"
						+ "							     .flip-card-back {\n"
						+ "							       background-color: #35c76d;\n"
						+ "							       color: white;\n"
						+ "							       transform: rotateY(180deg);\n"
						+ "							     }\n"
						+ "							     </style>\n"
						+ "							     </head>\n"
						+ "							     <body><h3> Search result for "+loc+"</h3><h6>Hover over to apply:<table cellpadding=\"5\" cellspacing=\"12\">");
						
				String query3;
			
				String email;
				 out.print("<tr>");
				 out.print("\n"
						 
								 		+ "<td><div class=\"flip-card\">\n"
								 		+ "      <div class=\"flip-card-inner\">\n"
								 		+ "        <div class=\"flip-card-front\">\n"
								 		+ "        <p> <h4><font color=\"blue\"><u>HAPPY SEARCHING !!!1</font></u>\n"
								 				
								 		+ "        </div>\n"
								 		+ "        <div class=\"flip-card-back\">\n"
								 		+ "          <h4><font color=\"red\"><u>HOME LIKE STAY...</u> </font>\n"
								 	
								 				
								 				
								 		
								 		+ "    </div>"
								 		
								 		+ "     </td>\n");
							             count++;
							             HttpSession session= request.getSession();
				 while(rs.next()) {
					
					 query3="select contact from register where email='"+rs.getString(1)+"';";
					 ResultSet result= state.executeQuery(query3);
					 count++;
					 result.next();
					
					
					 out.print("<form action=\"apply\"   Method=\"post\">"
						 		+ "<td><div class=\"flip-card\">\n"
						 		+ "      <div class=\"flip-card-inner\">\n"
						 		+ "        <div class=\"flip-card-front\">\n"
						 		+ "        <p> <h4>"+rs.getString(3)+"\n"
						 				+ "<p> <h4>"+rs.getString(2)+"\n"
						 						+ "<p> <h4>Nearby Transport Facilities:<br> \n"+rs.getString(8)+"\n"
						 								+ "<p> <h4>\n"+rs.getString(9)+"\n"
						 		+ "        </div>\n"
						 		+ "        <div class=\"flip-card-back\">\n"
						 		+ "          <h1></h1> \n"
						 		+ "          <p>Email: </p>"+rs.getString(1)+" \n"
						 		+ "          <p>CONTACT NO: "+result.getString(1)+"</p>\n"
						 				
						 				
						 		+ "<button name= \"hname\" value="+rs.getString(3)+" class=\"btn btn-danger \" role=\"button\" aria-pressed=\"true\" data-toggle=\"tooltip\" action=\"apply\" title=\"Click Apply\">APPLY</button></div>\n");
						
						email= (String) session.getAttribute("C");
						   session.setAttribute("C",email);
						 		out.print("  "
						 		+ "      </div>\n"
						 		+ "    </div>"
						 		
						 		+ "     </td></form>\n"
						 		+ "  ");
					// out.print("\t");
					
					   if(count%4==0)
						   out.print("</tr>");
						   
					 }
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
					 		+ "</form></center>\n"
					 		
					 		+ "</body>\n"
					 		+ "</html>");
				
			}
			

				
	} catch (Exception e) {
		out.println(e);
	}
	   
	   
	}

}
