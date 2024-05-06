import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InfoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Información relevante
        String formData = request.getQueryString();
        String clientInfo = request.getRemoteAddr();
        LocalDateTime currentDate = LocalDateTime.now();
        String uri = request.getRequestURI();
        String method = request.getMethod();

        // Construir el mensaje de registro
        String logMessage = "Datos del formulario: " + formData + " " +
                            "Información del cliente: " + clientInfo + " " +
                            "Fecha actual: " + currentDate + " " +
                            "URI: " + uri + " " +
                            "Método: " + method;

        // Registrar el mensaje en el registro del servidor
        getServletContext().log(logMessage);

        // Enviar la respuesta al cliente
        response.setContentType("text/plain");
        response.getWriter().println(logMessage);
    }
}
