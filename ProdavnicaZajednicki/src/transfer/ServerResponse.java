/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Veljko
 */
public class ServerResponse implements Serializable {
    
    private Object result;
    private Exception exception;

    public ServerResponse() {
    }

   
    
    
    public ServerResponse(Object result, Exception exception) {
        this.result = result;
        this.exception = exception;
    }


    public Object getResult() {
        return result;
    }

    public Exception getException() {
        return exception;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    
    
    
    
}
