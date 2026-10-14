package controllers.login;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogInController {

    Connection connection = DBConnection.getInstance().getConnection();


    public boolean checkUserNameAndPasswor(String userName, String userPassword) {
        String SQL = "SELECT 1 FROM  users WHERE user_name = ? AND  password = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPassword);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return true;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
