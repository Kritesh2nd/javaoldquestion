package Service;
import DBConnection.DBConnection;
import Model.Model;
import java.sql.*;
public class Service {
    public Model validateUser(Model md){
        Model m = null;
        String query = "select*from userinfo where username=? and password=?";
        PreparedStatement ps = new DBConnection().getStatement(query);
        try{
            ps.setString(1,md.getUsername());
            ps.setString(2,md.getPassword());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                m = new Model();
                m.setUsername(rs.getString("username"));
                m.setPassword(rs.getString("password"));
            }
        }
        catch(SQLException e){
            System.out.println("ERROR: "+e);
        }
        return m;
    }
}
