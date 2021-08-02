package unidade2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAutenficador
 */
@WebServlet("/ServletAutentificador")
public class ServletAutentificador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static String url = "jdbc:mysql://localhost:3306/curso_java";
	static String usuario = "root";
	static String senha = "88484803Da";
	static Connection conexao; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAutentificador() {
        super();
        
    }
    
    @Override
    public void init() throws ServletException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(url, usuario, senha);
			conexao.setAutoCommit(false);
		} catch (SQLException| ClassNotFoundException e) {
			e.getMessage();
		}
		
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cpfMascara = request.getParameter("cpf");

		cpfMascara = cpfMascara.replaceAll("[.-]", "");

		Double cpf = Double.parseDouble(cpfMascara);

		String senha = request.getParameter("senha");


		response.setContentType("text/html");


		PrintWriter out = response.getWriter();
		
		String consulta = "SELECT * FROM curso_java.Login where cpf = '"+cpf+"' and senha='"+senha+"'";
		Statement statement;
		try {
			statement = conexao.createStatement();
			ResultSet rs = statement.executeQuery(consulta);
			
			if(rs.next()) // Usuario autenticado
			{
				out.println("<h2>Usuário autenticado!</h2>");
			}
			else // Usuario não autenticado
			{
				out.println("<h2>Usuário não autenticado!</h2>");
			}
		} catch (SQLException e) {
			e.getMessage();
		}

	}

}
