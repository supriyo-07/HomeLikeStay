import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.Client;
@WebServlet("/apply")
public class Apply extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public Apply() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			response.getWriter().append("Served at: ").append(request.getContextPath());
		 
	}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 HttpSession session= request.getSession();
		 String cli=(String) session.getAttribute("C");
		 String Appartment = request.getParameter("hname");
	
		 
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
				Statement st= con.createStatement();
				ResultSet r= st.executeQuery( "select email from landlord where add2='"+Appartment+"';");
				r.next();
				PreparedStatement ps= con.prepareStatement("insert into application values(?,?,?)");
				ps.setString(1, cli);
				ps.setString(2, r.getString(1));
				ps.setString(3, Appartment);
				int i= ps.executeUpdate();
				if(i>0) {
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
					out.println("<h2>You Have Successfully Applied for "+Appartment+" <h2><br>Your details will be sent to landlord, they will contact based on availability<br>");
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
			 
			 
			 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		 
	 }
		
		 
		 
	
}
