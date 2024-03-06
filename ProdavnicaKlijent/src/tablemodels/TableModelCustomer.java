/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodels;

import domain.Customer;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Veljko
 */
public class TableModelCustomer extends AbstractTableModel {
    
    private List<Customer> customers;
    private String[] columns = {"ID","Ime","Prezime","Email","Kontakt telefon"};

    public TableModelCustomer(List<Customer> customers) {
        this.customers=customers;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    

    @Override
    public int getRowCount() {
        if(customers==null){
            return 0;
        }
        return customers.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer customer = customers.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return customer.getCustomerID();
            case 1:
                return customer.getFirstname();
            case 2:
                return customer.getLastname();
            case 3:
                return customer.getEmail();
            case 4:
                return customer.getPhoneNumber();
            default:
                return "n/a";
        }
    }
    
    public void remove(int index){
        customers.remove(index);
        fireTableDataChanged();
    }

    public List<Customer> getCustomers() {
        return customers;
    }
    
    public Customer getCustomer(int index){
        return customers.get(index);
    }
    
}
