package com.example.restaurantandroid.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHandler {
    private Connection connection;

    private final static String DB_URL = "jdbc:postgresql://172.20.8.18/kp0091_05_restaurant";
    private final static String DB_USER = "st0091";
    private final static String DB_PASSWORD = "qwerty91";

    private boolean status;


    public void getConnection()
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try
                {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                    status = true;
                    System.out.println("Подключено к БД:" + status);
                }
                catch (Exception e)
                {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try
        {
            thread.join();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            this.status = false;
        }
    }

    public Connection getExtraConnection()
    {
        Connection c = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return c;
    }
}
