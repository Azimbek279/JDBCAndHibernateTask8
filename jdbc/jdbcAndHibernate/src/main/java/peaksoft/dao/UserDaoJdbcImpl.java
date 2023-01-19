package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        String sql = "create table users(id serial primary key," +
                "name varchar(55)," +
                "last_name varchar(55)," +
                "age int)";
        try(Connection connection = Util.getConnection();
            Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println();
            System.out.println("Create Table!");
        }catch (SQLException e){
            System.out.println("there already  have table!");
        }

    }

    public void dropUsersTable() {
        String sql = "drop table users";

        try(Connection connection = Util.getConnection();
        Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("drop table!");
        }catch (SQLException e){
            System.out.println("not drop table!");
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "insert into users(name,last_name,age) values (?,?,?)";

        try(Connection connection = Util.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,name);
            statement.setString(2,lastName);
            statement.setInt(3,age);
            statement.executeUpdate();
            System.out.println(name+" save in table!");
        }catch (SQLException e){
            System.out.println("not save user!");
        }
    }

    public void removeUserById(long id) {
        String sql = "delete from users where id = ?";

        try(Connection connection = Util.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1,id);
            System.out.println("Remove user!");
        }catch (SQLException e){
            System.out.println("not remove user!");
        }
    }

    public List<User> getAllUsers() {
        String sql = "select * from users";
        ArrayList<User> userList = new ArrayList<>();

        try(Connection connection = Util.getConnection();
        Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getByte("age"));
                userList.add(user);
                return userList;
            }

        }catch (SQLException e){
            System.out.println("Doesn't work command getAllUsers!");
        }
        return userList;
    }

    public void cleanUsersTable() {
        String sql = "truncate table users";

        try(Connection connection = Util.getConnection();
        Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("clean users table!");
        }catch (SQLException e){
            System.out.println("not clean user table");
        }
    }
}