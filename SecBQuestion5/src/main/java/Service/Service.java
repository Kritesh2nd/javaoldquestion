package Service;
import java.sql.*;
import java.util.*;
import Model.User;
import DBConnection.DBConnection;
public class Service {
    public void create(User u){
        String query = "insert into userinfo(fullname,username,password) values (?,?,?)";
        PreparedStatement ps = new DBConnection().getStatement(query);
        try{
            ps.setString(1,u.getName());
            ps.setString(2,u.getUsername());
            ps.setString(3,u.getPassword());
            ps.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public List<User> read(){
        List<User> userlist = new ArrayList<>();
        String query = "select*from userinfo";
        PreparedStatement ps = new DBConnection().getStatement(query);
        try{
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("fullname"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                userlist.add(user);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return userlist;
    }
    public void update(User u){
        String query = "update userinfo set fullname=?, username=?, password=? where id=?";
        
        PreparedStatement ps = new DBConnection().getStatement(query);
        try{
            ps.setString(1,u.getName());
            ps.setString(2,u.getUsername());
            ps.setString(3,u.getPassword());
            ps.setInt(4,u.getId());
            ps.execute();
        }
        catch (SQLException e){
            System.out.println("ERROR "+e);
            e.printStackTrace();
        }
    }
    public void delete(int id){
        String query = "delete from userinfo where id=?";
        PreparedStatement ps = new DBConnection().getStatement(query);
        try{
            ps.setInt(1, id);
            ps.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Service s = new Service();
        User u = new User();
        u.setId(1);
        u.setName("nnn");
        u.setPassword("ppp");
        u.setUsername("u");
        s.update(u);
    }
}
