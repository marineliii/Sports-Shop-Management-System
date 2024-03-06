/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.db;

import repository.Repository;

/**
 *
 * @author Veljko
 */
public interface DBRepository<T, K> extends Repository<T, K>{
    
    default void connect() throws Exception{
        DBConnectionFactory.getInstance().getConnection();
    }
    
    default void disconnect() throws Exception{
        DBConnectionFactory.getInstance().getConnection().close();
    }
    
    default void commit() throws Exception{
        DBConnectionFactory.getInstance().getConnection().commit();
    }
    
    default void rollback() throws Exception{
        DBConnectionFactory.getInstance().getConnection().rollback();
    }
    
}
