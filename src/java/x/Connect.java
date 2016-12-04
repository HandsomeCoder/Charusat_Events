package x;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Harsh Shah
 */
public class Connect {

    private Connection con = null;


    public Connect() {
    }

    public Connect(String url, String uname, String pass) {
        System.out.println("--------Connect--------------");
        System.out.println("url " + url + " uname = " + uname + " pass = " + pass);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, uname, pass);
            System.out.println("con " + con);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public int createUser(String enrol, String fname, String mname, String lname,
            String dob, String institue, String branch, String email, String password) throws SQLException {
        PreparedStatement pst = con.prepareStatement("insert into information values (?,?,?,?,?,?,?,?,?,?,?,?)");
        pst.setString(1, enrol);
        pst.setString(2, fname);
        pst.setString(3, mname);
        pst.setString(4, lname);
        pst.setString(5, dob);
        pst.setString(6, institue);
        pst.setString(7, branch);
        pst.setString(8, email);
        pst.setString(9, password);
        pst.setString(10, "N");
        pst.setInt(11, 0);
        pst.setString(12, "N");
        return pst.executeUpdate();
    }

    public int verifiedUser(String enrol) throws SQLException {
        PreparedStatement pst = con.prepareStatement("UPDATE information SET verified='Y' WHERE enrolno = ?");
        pst.setString(1, enrol);
        return pst.executeUpdate();
    }

    public ResultSet AuthenticateUser(String enrol, String pass) throws SQLException {
        PreparedStatement pst = con.prepareStatement("select * from login where enrolno = ? and password = ?");
        pst.setString(1, enrol);
        pst.setString(2, pass);
        ResultSet rs = pst.executeQuery();
        return rs;
    }

    public ResultSet getPermission(String enrol) throws SQLException {
        PreparedStatement pst = con.prepareStatement("SELECT permission FROM information WHERE enrolno = ?");
        pst.setString(1, enrol);
        return pst.executeQuery();
    }

    public ResultSet getEventsTitle(String category) throws SQLException {
        System.out.println(category);
        ResultSet rs = null;
        PreparedStatement pst = con.prepareStatement("select id,title from eventsrecord where category = ?");
        pst.setString(1, category);
        rs = pst.executeQuery();
        return rs;
    }

    public ResultSet getEventDetail(int id) throws SQLException {
        System.out.println(id);
        ResultSet rs = null;
        PreparedStatement pst = con.prepareStatement("select * from eventsrecord where ID = ?");
        pst.setInt(1, id);
        rs = pst.executeQuery();
        return rs;
    }

    public ResultSet isUserRegistar(int id, String enrol) throws SQLException {
        PreparedStatement pst = con.prepareStatement("select * from registrationrecord where enrol = ? and ID = ?");
        pst.setString(1, enrol);
        pst.setInt(2, id);
        return pst.executeQuery();
    }
    
    public int registarUser(int id, String enrol) throws SQLException {
        PreparedStatement pst = con.prepareStatement("insert into registrationrecord values (?,?)");
        pst.setString(1, enrol);
        pst.setInt(2, id);
        return pst.executeUpdate();
    }

    public int createEvent(String createby,String title,String detail,
            String category,String venue,String date,String time) throws SQLException {
        PreparedStatement pst = con.prepareStatement("insert into eventsrecord (createby,title,detail,category,venue,edate,etime) values (?,?,?,?,?,?,?)");
        pst.setString(1, createby);
        pst.setString(2, title);
        pst.setString(3, detail);
        pst.setString(4, category);
        pst.setString(5, venue);
        pst.setString(6, date);
        pst.setString(7, time);
        return pst.executeUpdate();
    }
    
    public ResultSet getBasicInfo(String enrol) throws SQLException {
        PreparedStatement pst = con.prepareStatement("select * from information where enrolno = ?");
        pst.setString(1, enrol);
        return pst.executeQuery();
    }
    
    public ResultSet getPassword(String enrol) throws SQLException {
        PreparedStatement pst = con.prepareStatement("select password from information where enrolno = ?");
        pst.setString(1, enrol);
        return pst.executeQuery();
    }
    
    public int updatePassword(String enrol,String newpass) throws SQLException {
        PreparedStatement pst = con.prepareStatement("UPDATE information SET password=? WHERE enrolno = ?");
        pst.setString(1, newpass);
        pst.setString(2, enrol);
        return pst.executeUpdate();
    }
    
    public ResultSet getMyEvents(String enrol) throws SQLException {
        PreparedStatement pst = con.prepareStatement("select * from eventsrecord where createby = ?");
        pst.setString(1, enrol);
        return pst.executeQuery();
    }
    
    public ResultSet getMyEventsRegistry(String enrol) throws SQLException {
        PreparedStatement pst = con.prepareStatement("select * from eventsrecord natural "
                + "join registrationrecord where enrol = ?");
        pst.setString(1, enrol);
        return pst.executeQuery();
    }
    
    public int updateBasicInfo(String enrol,String fname,String mname,String lname,String dob,String institute,String branch) throws SQLException {
        PreparedStatement pst = con.prepareStatement("UPDATE information SET fname = ?,mname = ?,lname = ?,dob = ?,institute = ?,branch = ? WHERE enrolno = ?");
        System.out.println(enrol);
        pst.setString(1, fname);
        pst.setString(2, mname);
        pst.setString(3, lname);
        pst.setString(4, dob);
        pst.setString(5, institute);
        pst.setString(6, branch);
        pst.setString(7, enrol);
        return pst.executeUpdate();
    }
    
    public ResultSet getEventInfo(int id) throws SQLException {
        PreparedStatement pst = con.prepareStatement("select * from eventsrecord where ID = ?");
        pst.setInt(1, id);
        return pst.executeQuery();
    }

    public int editEvent(int id,String title,String detail,String category,String venue,String date,String time) throws SQLException {
        PreparedStatement pst = con.prepareStatement("UPDATE eventsrecord SET title = ?,detail = ?,category = ?,venue = ?,edate = ?,etime = ? WHERE ID = ?");
        pst.setString(1, title);
        pst.setString(2, detail);
        pst.setString(3, category);
        pst.setString(4, venue);
        pst.setString(5, date);
        pst.setString(6, time);
        pst.setInt(7, id);
        return pst.executeUpdate();
    }
    
    public ResultSet getRegistration(int id) throws SQLException{
        PreparedStatement pst = con.prepareStatement("select * from basicinfo natural join registrationrecord where basicinfo.enrolno = registrationrecord.enrol and id = ?");
        pst.setInt(1, id);
        return pst.executeQuery();
    }
    
    public ResultSet getRegistrationEmail(int id) throws SQLException{
        PreparedStatement pst = con.prepareStatement("select email from basicinfo natural join registrationrecord where basicinfo.enrolno = registrationrecord.enrol and id = ?");
        pst.setInt(1, id);
        return pst.executeQuery();
    }
    
    public int closeEvent(int id) throws SQLException {
        PreparedStatement pst = con.prepareStatement("UPDATE eventsrecord SET active='N' WHERE ID = ?");
        pst.setInt(1, id);
        return pst.executeUpdate();
    }
    
    public int deleteEvent(int id) throws SQLException {
        PreparedStatement pst = con.prepareStatement("DELETE FROM eventsrecord WHERE ID = ?");
        pst.setInt(1, id);
        return pst.executeUpdate();
    }
    
    public ResultSet isActive(int id) throws SQLException{
        PreparedStatement pst = con.prepareStatement("select active from eventsrecord where id = ?");
        pst.setInt(1, id);
        return pst.executeQuery();
    }
    
    public ResultSet isAdmin(String enrol) throws SQLException{
        PreparedStatement pst = con.prepareStatement("select admin from information where enrolno = ?");
        pst.setString(1, enrol);
        return pst.executeQuery();
    }
}
