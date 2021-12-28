package com.solyha.bgitubot.driver;

import java.sql.*;

public class Driver {
    public String getCompliment(){
        String select = "SELECT TOP 1 Compliment FROM ComplimentsS.Compliments ORDER BY NEWID()";
        ResultSet resultSet = null;
        String compliment = new String();
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;user=ComplimentBot;password=12345;");
            System.out.println("Connection");
            PreparedStatement statement = connection.prepareStatement(select);
            resultSet = statement.executeQuery();
            if(resultSet.next())
                compliment = resultSet.getString("Compliment");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return compliment;
    }
}
