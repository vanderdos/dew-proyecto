

import java.io.*;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class log1
 */
public class log1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public log1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Información relevante
        String formData = request.getQueryString();
        String clientInfo = request.getRemoteAddr();
        LocalDateTime currentDate = LocalDateTime.now();
        String uri = request.getRequestURI();
        String method = request.getMethod();

        // Construir el mensaje de registro
        String logMessage = currentDate + formData + " " + clientInfo + " " + uri + " acceso" + method;

        // Registrar el mensaje en el registro del servidor
        getServletContext().log(logMessage);

        // Enviar la respuesta al cliente
        response.setContentType("text/plain");
        response.getWriter().println(logMessage);

       
        FileOutputStream archivo = new FileOutputStream("./tomcat/webapps/resultado.txt",true);
        PrintStream output = new PrintStream(archivo);
        System.setOut(output);
        System.out.println(logMessage);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Información relevante
        String formData = request.getQueryString();
        String clientInfo = request.getRemoteAddr();
        LocalDateTime currentDate = LocalDateTime.now();
        String uri = request.getRequestURI();
        String method = request.getMethod();

        // Construir el mensaje de registro
        String logMessage = currentDate + formData + " " + clientInfo + " " + uri + " acceso" + method;

        // Registrar el mensaje en el registro del servidor
        getServletContext().log(logMessage);

        // Enviar la respuesta al cliente
        response.setContentType("text/plain");
        response.getWriter().println(logMessage);
        
        FileOutputStream archivo = new FileOutputStream("./tomcat/webapps/resultado.txt",true);
        PrintStream output = new PrintStream(archivo);
        System.setOut(output);
        System.out.println(logMessage);
        
    }


}




