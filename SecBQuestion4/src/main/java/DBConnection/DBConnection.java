package DBConnection;
import java.sql.*;
public class DBConnection{
    Connection con = null;
    public DBConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/mydb";
            con = DriverManager.getConnection(dbUrl, "root", "");
            System.out.println("DB connnected");
        }
        catch (SQLException | ClassNotFoundException e){
            System.out.println("ERROR: "+e);
            e.printStackTrace();
        }
    }
    public PreparedStatement getStatement(String query){
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(query);
        }
        catch (SQLException e){
            System.out.println("ERROR: "+e);
            e.printStackTrace();
        }
        return ps;
    }
}