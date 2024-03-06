/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.worker;

import controller.Controller;
import domain.Worker;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AbstractSO;

/**
 *
 * @author Veljko
 */
public class LoginSO extends AbstractSO {
    
    private Worker activeWorker;

    @Override
    protected void preconditions(Object param) throws Exception {
        if(param == null || !(param instanceof Worker)){
            throw new Exception("Objekat nije radnik");
        }
        Worker worker = (Worker) param;
        if(!isInBase(worker)){
            throw new Exception("Ne postoji radnik sa unetim vrednostima");
        }
        if(worker.isDeleted()){
            throw new Exception("Izabrani korisnik je izbrisan iz sistema");
        }
        if(worker.isLoggedIn()==true){
            throw new Exception("Korisnik je vec ulogovan");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        activeWorker=(Worker) param;
        ((Worker)param).setLoggedIn(true);
        repository.update((Worker)param);
    }

    public Worker getActiveWorker() {
        return activeWorker;
    }
    
    private boolean isInBase(Worker worker) {
        List<Worker> workers = new ArrayList<>();
        try {
            workers=Controller.getInstance().getAllWorkers();
        } catch (Exception ex) {
            Logger.getLogger(LoginSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Worker workerHelp : workers) {
            if(workerHelp.getWorkerID()==worker.getWorkerID()){
                return true;
            }
        }
        return false;
    }
    
}
