import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet
{  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        out.println("<title>Employee Details Page</title>");
        out.println("<h1>Employees List</h1>");
        List<Emp> list=EmpDao.getAllEmployees();
        out.print("<table border='2' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");  
        for(Emp e:list)
        {  
         out.print("<tr><td><center>"+e.getId()+"</td><td><center>"+e.getName()+"</td><td><center>"+e.getPassword()+"</td><td><center>"+e.getEmail()+"</td><td><center>"+e.getCountry()+"</td><td>"
         + "<a href='EditServlet?id="+e.getId()+"'><center>edit</a></td><td>"
         + "<a href='DeleteServlet?id="+e.getId()+"'><center>delete</a></td></tr>");
        }
        out.print("</table>");
        out.print("<br></br>");
        out.println("<a href='FrontEnd.html'>Add New Employee</a>");
        out.close();  
    }  
}  