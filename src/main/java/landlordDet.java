

import javax.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class landlordDet
 */
@WebServlet("/landDet")
public class landlordDet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public landlordDet() {
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
		PrintWriter out = response.getWriter();
		String avai = "";
		String email = request.getParameter("email");
        String address =  request.getParameter("Add");
        String Address2= request.getParameter("Address2");
        String Location = request.getParameter("loc");
        String Zip = request.getParameter("Zip");
        String Type = request.getParameter("type");
       
        String bed = request.getParameter("bed");
        String rent= request.getParameter("rent");
        String avail[] = request.getParameterValues("avail");
        for(int x=0;x<avail.length;x++) {
        	avai+=avail[x]+"\n";
        }
        String des = request.getParameter("des");
try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
			
			PreparedStatement ps= con.prepareStatement("insert into landlord values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, email);
			ps.setString(2, address);
			ps.setString(3, Address2);
			ps.setString(4, Location);
			ps.setString(5, Zip);
			ps.setString(6, Type);
			ps.setString(7, bed);
			ps.setString(8, avai);
			ps.setString(9, des);
			ps.setString(10, rent);
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
				out.println("<h2>Details Saved Successfully!!!!!<h2>");
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
			
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
