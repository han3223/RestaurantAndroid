package com.example.restaurantandroid.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHandler {
    private Connection connection;

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
                    connection = DriverManager.getConnection("jdbc:postgresql://eu-central-1.aws.neon.tech/Restaurant?", "han3223", "NeHn48hTMSWB");
                    status = true;
                    System.out.println("Подключено к БД:" + status);
                }
                catch (Exception e)
                {
                    status = false;
                    System.out.print(e.getMessage() + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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
            c = DriverManager.getConnection("jdbc:postgresql://eu-central-1.aws.neon.tech/Restaurant?user=han3223&password=NeHn48hTMSWB");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return c;
    }
}
