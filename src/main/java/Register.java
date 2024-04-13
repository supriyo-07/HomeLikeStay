

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/RegisterServer")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String firstname = request.getParameter("fname");
        String lastname =  request.getParameter("lname");
        String E_id = request.getParameter("Eid");
        String Password = request.getParameter("Pass");
        String adhar = request.getParameter("adhar");
        String contact = request.getParameter("con");
        String gender = request.getParameter("gen");
        String dob = request.getParameter("dob");
        String age = request.getParameter("age");
        String join_as = request.getParameter("join_as");
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
			
			PreparedStatement ps= con.prepareStatement("insert into register values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, E_id);
			ps.setString(4, Password);
			ps.setString(5, adhar);
			ps.setString(6, contact);
			ps.setString(7, gender);
			ps.setString(8, dob);
			ps.setString(9, age);
			ps.setString(10, join_as);
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
				out.println("<h2>USER SUCCESSFULLY REGISTERED!!!!! GO BACK TO LOGIN...<h2>");
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
