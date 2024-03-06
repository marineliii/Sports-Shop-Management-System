/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.Serializable;
import operation.Operation;


/**
 *
 * @author Veljko
 */
public class ClientRequest implements Serializable{
    private final Operation operation;
    private final Object argument;
    private final Object filter;
    

    public ClientRequest(Object argument ,Operation operation, Object filter) {
        this.operation = operation;
        this.argument = argument;
        this.filter=filter;
    }

    public Operation getOperation() {
        return operation;
    }

    

    public Object getArgument() {
        return argument;
    }

    public Object getFilter() {
        return filter;
    }

   
    
    
}
