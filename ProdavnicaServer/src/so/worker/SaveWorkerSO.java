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
import so.customer.SaveCustomerSO;

/**
 *
 * @author Veljko
 */
public class SaveWorkerSO extends AbstractSO {

    @Override
    protected void preconditions(Object param) throws Exception {
        if(param == null || !(param instanceof Worker)){
            throw new Exception("Objekat nije radnik");
        }
        Worker worker = (Worker) param;
        String error=doesExist(worker);
        if(error!=null){
            throw new Exception(error);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.save((Worker)param);
    }
    
    private String doesExist(Worker worker) {
        List<Worker> workers = new ArrayList<>();
        try {
            workers=Controller.getInstance().getAllWorkers();
        } catch (Exception ex) {
            Logger.getLogger(SaveWorkerSO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Worker workerHelp : workers) {
            if(workerHelp.getEmail().equals(worker.getEmail())){
                return "Radnik sa unetim emailom vec postoji";
            }
            if(workerHelp.getPhoneNumber().equals(worker.getPhoneNumber())){
                return "Radnik sa unetim brojem telefona vec postoji";
            }
            if(workerHelp.getUsername().equals(worker.getUsername())){
                return "Radnik sa unetim korisnckim imenom vec postoji";
            }
        }
        return null;
    }
    
}
