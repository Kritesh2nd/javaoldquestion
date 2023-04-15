package Controller;
import Model.Model;
import Service.Service;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Controller", urlPatterns = {"/user"})
public class Controller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String page = request.getParameter("page");
        
        if(page.equals("login")){
            Model user = new Model();
            
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            
            Model md = new Service().validateUser(user);
            
            if(md == null){
                out.print("Username or password is incorrect");
            }
            else{
                out.print("You are loged in.");
            }
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}
