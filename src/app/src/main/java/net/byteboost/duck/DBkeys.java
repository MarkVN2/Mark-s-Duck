package net.byteboost.duck;

/**
 * Contains key information about the database like SQL user  and SQL password.
 */
public class DBkeys {
    private static String SQLUser = "root";
    private static String SQLPassword = "";

    public static String getSQLUser(){
        return SQLUser;
    }
    public static String getSQLPassword(){
        return SQLPassword;
    }
    public void setSQLUser(String user){
        this.SQLUser = user;
    }
    public void setSQLPassword(String password){
        this.SQLPassword = password;
    }
}
