package Controller;
import Model.User;
import Service.Service;
import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
@WebServlet(name = "Controller", urlPatterns = {"/user"})
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String page = request.getParameter("page");
        if(page.equals("create")){
            try{
                User user = new User();
                user.setName(request.getParameter("name"));
                user.setUsername(request.getParameter("username"));
                user.setPassword(request.getParameter("password"));
                new Service().create(user);
            }
            catch(Exception e){
                out.print(e);
            }
        }
        else if(page.equals("update")){
            User user = new User();
            user.setId(Integer.parseInt(request.getParameter("id")));
            user.setName(request.getParameter("name"));
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            new Service().update(user);
        }
        else if(page.equals("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            new Service().delete(id);
        }
        List<User> userlist = new Service().read();
        request.setAttribute("userlist", userlist);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request,response);
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        doPost(request,response);
    }
}
