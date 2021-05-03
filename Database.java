// import java.sql.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 


public class Database {
    Connection conn;
    public static String insertStatement = "insert into `MyInformation`(`Name`,PhoneNo,Age,`Email`,`Address`,`BloodGroup`,`DOB`,`Gender`,`Qualification`,`LongTermIllness`,AadhaarNo,`PancardNo`) values(?,?,?,?,?,?,?,?,?,?,?,?)";
    public static String printInformation = "select * from `MyInformation`";
    public static String updateAge = "update `MyInformation` set Age=DATEDIFF(yy, DOB, getDate())";

    final static String ANSI_RESET = "\u001B[0m";
    final static String ANSI_BLACK = "\u001B[30m";
    final static String ANSI_RED = "\u001B[31m";
    final static String ANSI_GREEN = "\u001B[32m";
    final static String ANSI_YELLOW = "\u001B[33m";
    final static String ANSI_BLUE = "\u001B[34m";
    final static String ANSI_PURPLE = "\u001B[35m";
    final static String ANSI_CYAN = "\u001B[36m";
    final static String ANSI_WHITE = "\u001B[37m";

    Database(String url, String user, String pass) {
        try {
            this.conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            this.conn = null;
            e.printStackTrace();
        }
    }

    public void closeConnection() throws SQLException {
        this.conn.close();
        System.out.println(ANSI_CYAN + "\n Database Connection Closed!" + ANSI_RESET);
    }

    public boolean insertData(MyInformation std) {
        try {
            PreparedStatement statement = this.conn.prepareStatement(insertStatement);
            statement.setString(1, std.Name);
            statement.setInt(2, std.PhoneNo);
            statement.setInt(3, std.Age);
            statement.setString(4, std.Email);
            statement.setString(5, std.Address);
            statement.setString(6, std.BloodGroup);
            statement.setDate(7, std.DOB);
            statement.setString(8, std.Gender);
            statement.setString(9, std.Qualification);
            statement.setString(10, std.LongTermIllness);
            statement.setInt(11, std.AadhaarNo);
            statement.setString(12, std.PancardNo);
            int rows = statement.executeUpdate();
            return rows > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void printDatabase() throws SQLException {
        Statement statement = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet res = statement.executeQuery(printInformation);
        printResultSet(res);
    }

    public boolean handleUpdate(int Age) throws SQLException {
        PreparedStatement statement = this.conn.prepareStatement(updateAge);
        return statement.executeUpdate() > 0 ? true : false;
    }

    public void printResultSet(ResultSet res) throws SQLException {
        int numberOfRows = 0;
        while (res.next()) {
            numberOfRows++;
        }
        if (numberOfRows > 0) {
            res.beforeFirst();
            System.out.println(ANSI_CYAN + "\n =====My Information======" + ANSI_RESET);
            int counter = 0;
            while (res.next()) {
                counter++;
                System.out.println(ANSI_PURPLE + "\n MyInformation " + counter + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "\n Name : " + res.getString("Name") + ANSI_RESET);
                System.out.println(ANSI_YELLOW + " Phone No : " + res.getString("PhoneNo") + ANSI_RESET);
                System.out.println(ANSI_YELLOW + " Age : " + res.getString("Age") + ANSI_RESET);
                System.out.println(ANSI_YELLOW + " Email : " + res.getString("Email") + ANSI_RESET);
                System.out.println(ANSI_YELLOW + " Address :" + res.getString("Address") + ANSI_RESET);
                System.out.println(ANSI_YELLOW + " Blood Group :" + res.getString("BloodGroup") + ANSI_RESET);
                System.out.println(ANSI_YELLOW + " Date of Birth :" + res.getDate("DOB") + ANSI_RESET);
                System.out.println(ANSI_YELLOW + " Gender :" + res.getString("Gender") + ANSI_RESET);
                System.out.println(ANSI_YELLOW + " Qualification :" + res.getString("Qualification") + ANSI_RESET);
                System.out.println(ANSI_YELLOW + " Long Term Illeness :" + res.getString("LongTermIllness") + ANSI_RESET);
                System.out.println(ANSI_YELLOW + " Aadhaar No : " + res.getString("AadhaarNo") + ANSI_RESET);
                System.out.println(ANSI_YELLOW + " Pan Card No :" + res.getString("PancardNo") + ANSI_RESET);
            }
        } else {
            System.out.println(ANSI_RED + "\n =====No Information Found======" + ANSI_RESET);
        }
    }
}
