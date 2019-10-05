// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class Hello extends HttpServlet {

   private String message;

   public void init() throws ServletException {
      // Do required initialization
      message = "Hello World: src/main/java/Hello.java";
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      // Set response content type
      response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.println("<h1>" + message + "</h1>" + "<img alt="Spring Team" src="//fgl.scene7.com/is/image/FGLSportsLtd/FGL_TheDrop_Helly_Hansen_Puma_CMS_1732x310?wid=1920&amp;fit=fit,1&amp;op_sharpen=1&amp;resMode=sharp2&amp;qlt=85,1">");
   }
}
