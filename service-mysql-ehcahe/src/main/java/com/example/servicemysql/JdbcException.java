package com.example.servicemysql;

public class JdbcException extends RuntimeException {

    public JdbcException(String message){ super(message);}

    public JdbcException(String message, Throwable cause){ super(message, cause);}
}