/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodels;

//import repository.db.impl.DatabaseRepositoryWorker;
import controller.Controller;
import domain.Worker;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Veljko
 */
public class TableModelWorker extends AbstractTableModel{
    private List<Worker> workers;
    private String[] columns = {"RadnikID", "Ime", "Prezime", "Email", "KontaktTelefon", "KorisnickoIme",};

    public TableModelWorker(List<Worker> workers) {
        this.workers=workers;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    

    @Override
    public int getRowCount() {
        if(workers==null){
            return 0;
        }
        return workers.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Worker worker = workers.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return worker.getWorkerID();
            case 1:
                return worker.getFirstname();
            case 2:
                return worker.getLastname();
            case 3:
                return worker.getEmail();
            case 4:
                return worker.getPhoneNumber();
            case 5:
                return worker.getUsername();
            default:
                return "n/a";
        }
    }

    public void deleteWorker(int index) throws Exception {
        Controller.getInstance().deleteWorker(workers.get(index));
        workers.remove(index);
        fireTableDataChanged();
    }

    public Worker getWorker(int row) {
        return workers.get(row);
    }

    public void remove(int index) {
        workers.remove(index);
        fireTableDataChanged();
    }
    
    public boolean isWorkerDeleted(int index){
        return workers.get(index).isDeleted();
    }
    
    
    
}
