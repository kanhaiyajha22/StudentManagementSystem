import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class DeleteServlet extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException
{
res.setContentType("text/html");
PrintWriter out = res.getWriter();
out.println("<html><body>");
String id = req.getParameter("id");
//String name = req.getParameter("name");
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");
Statement s= c.createStatement();
int x =s.executeUpdate("delete from student where id='"+id+"'");
System.out.println("Deleted Succesfully");
ResultSet rs = s.executeQuery("select * from student");
ResultSetMetaData rsmd = rs.getMetaData();
out.println("<table bgcolor='lightgreen' border=1 width=800>");
out.println("<tr>");
for(int i=1;i<=rsmd.getColumnCount();i++)
{
out.println("<th>"+rsmd.getColumnName(i)+"</th>");
}
while(rs.next()){
out.println("<tr>");
out.println("<td>"+rs.getString(1)+"</td>");
out.println("<td>"+rs.getString(2)+"</td>");
out.println("<td>"+rs.getString(3)+"</td>");
out.println("<td>"+rs.getString(4)+"</td>");
out.println("<td>"+rs.getString(5)+"</td>");
out.println("<td>"+rs.getString(6)+"</td>");
out.println("<td>"+rs.getString(7)+"</td>");
out.println("<td>"+rs.getString(8)+"</td>");
out.println("<td>"+rs.getString(9)+"</td>");
out.println("</tr>");
}
}catch(Exception e){System.out.println(e);}
out.println("</table>");
out.println("</body></html>");
}
}
