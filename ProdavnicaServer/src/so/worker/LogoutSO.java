/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.worker;

import domain.Worker;
import so.AbstractSO;

/**
 *
 * @author Veljko
 */
public class LogoutSO extends AbstractSO {

    @Override
    protected void preconditions(Object param) throws Exception {
        if(!((Worker)param).isLoggedIn()){
            throw new Exception("Korisnik nije ulogovan");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        ((Worker)param).setLoggedIn(false);
        repository.update((Worker)param);
    }
    
}
