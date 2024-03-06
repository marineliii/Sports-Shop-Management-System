/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import repository.db.DBRepository;
import repository.db.broker.DatabaseBroker;

/**
 *
 * @author Veljko
 */
public abstract class AbstractSO {
    protected final DBRepository repository;

    public AbstractSO() {
        this.repository = new DatabaseBroker();
    }

    public final void excecute(Object param) throws Exception {
        try {
            preconditions(param);
            startTransaction();
            executeOperation(param);
            commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            rollback();
            throw ex;
        } finally {
            disconnect();
        }
    }

    // Operation-specific method
    protected abstract void preconditions(Object param) throws Exception;

    // Operation-specific method
    protected abstract void executeOperation(Object param) throws Exception;

    private void startTransaction() throws Exception {
        repository.connect();
    }

    private void commit() throws Exception {
        repository.commit();
    }

    private void rollback() throws Exception {
        repository.rollback();
    }

    private void disconnect() throws Exception {
        repository.disconnect();
    }
}
