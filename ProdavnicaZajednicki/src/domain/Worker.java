/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Veljko
 */
public class Worker implements GenericEntity {
    private int workerID;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
    private boolean loggedIn;
    private boolean deleted;

    public Worker() {
    }

    public Worker(int workerID, String firstname, String lastname, String email, String phoneNumber, String username, String password, boolean loggedIn, boolean deleted) {
        this.workerID = workerID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.loggedIn = loggedIn;
        this.deleted = deleted;
    }
    
    

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return username;
    }

    
    public String getFullName(){
        return firstname+" "+lastname;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    

    @Override
    public String getTableName() {
        return "radnik";
    }

    @Override
    public String getInsertColumns() {
        return "ime, prezime, email, kontaktTelefon, korisnickoIme, lozinka";
    }

    @Override
    public String getInsertValues() {
        return "'"+firstname+"','"+lastname+"','"+email+"','"+phoneNumber+"','"+username+"','"+password+"'";
    }

    @Override
    public void setId(int id) {
        this.workerID=id;
    }

    @Override
    public String getUpdateQuery() {
        return "ime='"+firstname+"',prezime='"+lastname+"', email='"+email+"',kontaktTelefon='"+phoneNumber+
                "',korisnickoIme='"+username+"',lozinka='"+password+"',"+"ulogovan="+loggedIn+", obrisan="+deleted;
    }

    @Override
    public String getWhereQuery() {
        return "radnikID="+workerID;
    }

    @Override
    public List<GenericEntity> getAllObjects(ResultSet rs) {
        List<GenericEntity> workers=new ArrayList<>();
        try {
            while(rs.next()){
                int workerID = rs.getInt("radnikID");
                String firstname = rs.getString("ime");
                String lastname = rs.getString("prezime");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("kontaktTelefon");
                String username = rs.getString("korisnickoIme");
                String password = rs.getString("lozinka");
                Boolean loggedIn = rs.getBoolean("ulogovan");
                Boolean deleted = rs.getBoolean("obrisan");
                Worker worker = new Worker(workerID, firstname, lastname, email, phoneNumber, username, password, loggedIn, deleted);
                workers.add(worker);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return workers;
    }

    @Override
    public String getWhereQueryWithFilter(Object filter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereQueryWithObject(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.deleted = isDeleted;
    }

    
    
    
    

    

    
    
    
}
