/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.worker;

import domain.Worker;
import java.util.List;
import repository.db.DBRepository;
import so.AbstractSO;

/**
 *
 * @author Veljko
 */
public class GetAllWorkersSO extends AbstractSO {
    
    private List<Worker> workers;

    @Override
    protected void preconditions(Object param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        workers=repository.getAll((Worker)param);
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    
    
    
    
}
