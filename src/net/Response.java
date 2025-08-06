/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net;

import enums.ResultType;
import java.io.Serializable;

/**
 *
 * @author Uros
 */
public class Response implements Serializable {

    private ResultType resultType;
    private Object argument;
    private Exception exception;

    public Response() {
    }

    public Response(ResultType resultType, Object argument, Exception exception) {
        this.resultType = resultType;
        this.argument = argument;
        this.exception = exception;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public void setResultType(ResultType resultType) {
        this.resultType = resultType;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

}
