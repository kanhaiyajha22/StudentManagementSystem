import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class Shearch extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException
{
res.setContentType("text/html");
PrintWriter out = res.getWriter();
out.println("<html><body>");
String id = req.getParameter("id");

try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");
Statement s= c.createStatement();
//int x =s.executeUpdate("delete from student where name = '"+name+"' and id='"+id+"'");
String s1 = "select * from student where id='"+id+"'";

ResultSet rs = s.executeQuery(s1);
 ResultSetMetaData rsmd = rs.getMetaData();

out.println("<table bgcolor='lightgreen' border=1 width=800>");
 out.println("<tr>");
 for(int i=1;i<=rsmd.getColumnCount();i++)
 {
 out.println("<th>"+rsmd.getColumnName(i)+"</th>");
}
if(rs.next()){
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
}else{
    System.out.println("User is not found");
}


}catch(Exception e){System.out.println(e);}


out.println("</table>");
out.println("</body></html>");
}
}
