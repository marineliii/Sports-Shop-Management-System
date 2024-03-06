/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.worker;

import controller.Controller;
import domain.Recommendation;
import domain.Worker;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AbstractSO;
import threads.ServerThread;

/**
 *
 * @author Veljko
 */
public class DeleteWorkerSO extends AbstractSO {

    @Override
    protected void preconditions(Object param) throws Exception {
        if(param == null || !(param instanceof Worker)){
            throw new Exception("Objekat nije radnik");
        }
        Worker worker = (Worker) param;
        if(!isInBase(worker)){
            throw new Exception("Radnik ne postoji");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        ((Worker)param).setDeleted(true);
        repository.update((Worker)param);
    }
    
    private boolean isInBase(Worker worker) {
        List<Worker> workers = new ArrayList<>();
        try {
            workers=Controller.getInstance().getAllWorkers();
        } catch (Exception ex) {
            Logger.getLogger(DeleteWorkerSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Worker workerHelp : workers) {
            if(workerHelp.getWorkerID()==worker.getWorkerID()){
                return true;
            }
        }
        return false;
    }
        
    
}
