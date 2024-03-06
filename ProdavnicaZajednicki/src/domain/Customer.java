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
public class Customer implements GenericEntity {
    private int customerID;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;

    public Customer() {
    }

    public Customer(int customerID, String firstname, String lastname, String email, String phoneNumber) {
        this.customerID = customerID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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

    @Override
    public String toString() {
        return getFullName();
    }

    public String getFullName(){
        return firstname+" "+lastname;
    }

    @Override
    public String getTableName() {
        return "kupac";
    }

    @Override
    public String getInsertColumns() {
        return "ime, prezime, email, kontaktTelefon";
    }

    @Override
    public String getInsertValues() {
        return "'"+firstname+"','"+lastname+"','"+email+"','"+phoneNumber+"'";
    }

    @Override
    public void setId(int id) {
        this.customerID=id;
    }

    @Override
    public String getUpdateQuery() {
        return "ime='"+firstname+"',prezime='"+lastname+"', email='"+email+"',kontaktTelefon='"+phoneNumber+"'";
    }

    @Override
    public String getWhereQuery() {
        return "kupacID="+customerID;
    }

    @Override
    public List<GenericEntity> getAllObjects(ResultSet rs) {
        List<GenericEntity> customers=new ArrayList<>();
        try {
            while(rs.next()){
                int customerID = rs.getInt("kupacID");
                String firstname = rs.getString("ime");
                String lastname = rs.getString("prezime");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("kontaktTelefon");
                Customer customer = new Customer(customerID, firstname, lastname, email, phoneNumber);
                customers.add(customer);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }

    @Override
    public String getWhereQueryWithFilter(Object filter) {
        return "ime LIKE '%"+filter+"%' OR prezime LIKE '%"+filter+"%' OR email LIKE '%"+filter+"%' OR "
                    + "kontaktTelefon LIKE '%"+filter+"%'";
    }

    @Override
    public String getWhereQueryWithObject(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}
