package net.byteboost.duck.utils;

import javafx.scene.control.Alert;
import net.byteboost.duck.DBkeys;

import javafx.event.ActionEvent;
import net.byteboost.duck.gui.LoginController;

import java.sql.*;

/**
 * Contains all the database utilities used in Duck like signing up a user and login it in.
 */
public class DButils {
    public static void SingUpUser(ActionEvent event ,String username, String password, String access_level ){

        Connection connection  = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/duck",DBkeys.getSQLUser(), DBkeys.getSQLPassword());

            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE username =?");

            psCheckUserExists.setString(1, username);

            resultSet = psCheckUserExists.executeQuery();

            if (resultSet.isBeforeFirst()){
                System.out.print("user-already-taken");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot take this username.");
                alert.show();
            }else{
                psInsert = connection.prepareStatement("INSERT INTO users (username, password, access_level) VALUES (?, ? , ?)");
                psInsert.setString(1,username);
                psInsert.setString(2,password);
                psInsert.setString(3,access_level);
                psInsert.executeUpdate();

                GUIutils.changeScene(event,"/fxml/signup.fxml", "YOUARELOGGEDIN",username, null, access_level);
            }
        } catch (SQLException exception){
            exception.printStackTrace();
        } finally {
            if(resultSet != null){
                try{
                    resultSet.close();
                }catch(SQLException exception){
                    exception.printStackTrace();
                }
            }
            if(psInsert !=null){
                try{
                    psInsert.close();
                }catch (SQLException exception){
                    exception.printStackTrace();
                }
            }
            if(psCheckUserExists != null){
                try{
                    psCheckUserExists.close();
                }catch(SQLException exception){
                    exception.printStackTrace();
                }
            }
            if (connection != null){
                try{
                    connection.close();
                }catch (SQLException exception){
                    exception.printStackTrace();
                }
            }
        }

    }

    public static void LogInUser(ActionEvent event, String username, String password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ResultSet resultSetAccessLevel = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/duck",DBkeys.getSQLUser(), DBkeys.getSQLPassword());
            preparedStatement = connection.prepareStatement("SELECT password FROM users WHERE username = ?");
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();

            preparedStatement = connection.prepareStatement("SELECT access_level FROM users WHERE username = ?");
            preparedStatement.setString(1,username);
            resultSetAccessLevel = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()){
                System.out.println("User not found");
            }else {
                while(resultSet.next() && resultSetAccessLevel.next()){
                    String retrievedPassword = resultSet.getString("password");
                    String retrievedAccessLevel = resultSetAccessLevel.getString("access_level");
                    if (retrievedPassword.equals(password)){
                        GUIutils.changeScene(event,"/fxml/test.fxml", "YOUARELOGGEDIN!",username, null, retrievedAccessLevel);
                    }else{
                        System.out.print("Password does not match username");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Provided credentials are wrong");
                        alert.show();
                    }
                }
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }finally {
            if (preparedStatement != null){
                try{
                    preparedStatement.close();
                }catch(SQLException exception){
                    exception.printStackTrace();
                }
            }
            if (resultSet != null){
                try{
                    resultSet.close();
                }catch(SQLException exception){
                    exception.printStackTrace();
                }
            }
            if (resultSetAccessLevel != null){
                try{
                    resultSetAccessLevel.close();
                }catch(SQLException exception){
                    exception.printStackTrace();
                }
            }
            if (connection != null){
                try{
                    connection.close();
                }catch (SQLException exception){
                    exception.printStackTrace();
                }
            }
        }
    }

}
