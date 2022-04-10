package com.lipingzhou.dao;

import com.lipingzhou.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //insert ...into usertable --write code yourself
        String sql = "insert into usertable values(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, user.getId());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getEmail());
        ps.setString(5, user.getGender());
        ps.setDate(6, (java.sql.Date)user.getBirthDate());
        if (ps.executeUpdate()==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        //delete ...where id=?
        String sql = "delete from usertable where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, user.getId());
        int num = ps.executeUpdate();
        return num;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //update ...where id=?
        String sql = "update usertable set username=?, password=?, email=?, gender=?, birthdate=? where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getGender());
        //(java.sql.Date)向下转型
        ps.setDate(5, (java.sql.Date)user.getBirthDate());
        ps.setInt(6, user.getId());
        int num = ps.executeUpdate();
        return num;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        //select ...where id=? write jdbc yourself
        String sql = "Select * from usertable where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        User user = null;
        if (rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        //user for login
        //select --- where username=? and password=?
        String sql = "Select * from usertable where username = ? and password = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        User user = null;
        if (rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        //select --- where username=?
        String sql = "Select * from usertable where username = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        List<User> userList = new ArrayList<User>();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        //select --- where password=?
        String sql = "Select * from usertable where password = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, password);
        ResultSet rs = ps.executeQuery();
        List<User> userList = new ArrayList<User>();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        //select --- where email=?
        String sql = "Select * from usertable where email = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        List<User> userList = new ArrayList<User>();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        //select --- where gender=?
        String sql = "Select * from usertable where gender = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, gender);
        ResultSet rs = ps.executeQuery();
        List<User> userList = new ArrayList<User>();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        //select --- where birthDate=?
        String sql = "Select * from usertable where birthDate = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, (java.sql.Date)birthDate);
        ResultSet rs = ps.executeQuery();
        List<User> userList = new ArrayList<User>();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "Select * from usertable";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<User> userList = new ArrayList<User>();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }
}
