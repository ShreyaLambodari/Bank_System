package Bank_sys_project.Connection_;
import java.sql.*;
public class Connection_ {
    public Connection c;
    public Statement s;
    public Connection_(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c =  DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem" , "root", "Uhpmylaptop8970");
            s=c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
