package com.example.rest.exception.dto;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author tada
 */
@Named
@RequestScoped
public class ExceptionDto implements Serializable {

    private String errorType;
    
    private String[] messages;

    public ExceptionDto() {
        
    }
    
    /**
     * @return the errorType
     */
    public String getErrorType() {
        return errorType;
    }

    /**
     * @param errorType the errorType to set
     */
    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    /**
     * @return the messages
     */
    public String[] getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(String... messages) {
        this.messages = messages;
    }
    
}
