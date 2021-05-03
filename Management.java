import java.sql.SQLException;
import java.text.ParseException;
// import java.sql.Connection;
// import java.sql.ResultSet;
import java.text.SimpleDateFormat;
// import java.text.DateFormat;
import java.util.*;
import java.io.*;

class Management {
    // Credentials=======================================================================
    public static String MySQLURL = "jdbc:mysql://127.0.0.1:3306/MyInformation";
    public static String databaseUserName = "user";
    public static String databasePassword = "pass";
    // ===================================================================================

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Database database = new Database(MySQLURL, databaseUserName, databasePassword);

    // MyInformation
    // Datas======================================================================
    public static String Name, Email, Address, BloodGroup, Gender, Qualification, LongTermIllness, PancardNo;
    public static int PhoneNo, Age, AadhaarNo;
    public static Date DOB;
    static MyInformation std;
    // ===================================================================================

    // Color
    // Codes========================================================================
    final static String ANSI_RESET = "\u001B[0m";
    final static String ANSI_BLACK = "\u001B[30m";
    final static String ANSI_RED = "\u001B[31m";
    final static String ANSI_GREEN = "\u001B[32m";
    final static String ANSI_YELLOW = "\u001B[33m";
    final static String ANSI_BLUE = "\u001B[34m";
    final static String ANSI_PURPLE = "\u001B[35m";
    final static String ANSI_CYAN = "\u001B[36m";
    final static String ANSI_WHITE = "\u001B[37m";
    // ===================================================================================

    public static void main(String[] args)throws SQLException,IOException, ParseException{
        if(database.conn!=null){
            System.out.println(ANSI_CYAN+"\n Connection Successful !"+ANSI_RESET);
            int loop=1;
            int Case;
            while(loop==1){
                System.out.print(ANSI_YELLOW+"\n =====COMMANDS=====\n \n 1 Create Information \n 2 Print The Database\n 3 Update Information Age \n\n Option : "+ANSI_RESET);
                Case=Integer.parseInt(br.readLine());                   
                boolean res;
                switch(Case)
                {
                    case 1:CreateInformation();                           
                            break;
                    case 2:database.printDatabase();
                            break;
                    case 3:
                            System.out.print(ANSI_PURPLE+" Enter Age : "+ANSI_RESET);
                            Age=Integer.parseInt(br.readLine());
                            res = database.handleUpdate(Age);     
                            System.out.println(
                                res?
                                ANSI_GREEN+"\n Information Updated!"+ANSI_RESET:
                                ANSI_RED+"\n OPPS! Information Not Updated !"+ANSI_RESET
                            );                      
                            break;
                    default:
                        System.out.println(ANSI_RED+"\n Invalid Choice !"+ANSI_RESET);
                }
                System.out.print(ANSI_BLUE+"\n Press 1 to continue , else 0 to terminate : "+ANSI_RESET);
                loop=Integer.parseInt(br.readLine());
            }
            database.closeConnection();          
        }            
        else
            System.out.println(ANSI_RED+"\n Connection Not Succesful !"+ANSI_RESET);
    }

    public static void CreateInformation() throws IOException, ParseException {
        System.out.println(ANSI_BLUE + "\n =====Enter Information Credentials=====" + ANSI_RESET);
        System.out.print(ANSI_CYAN + " Enter Name : " + ANSI_RESET);
        Name = br.readLine();
        System.out.print(ANSI_CYAN + "\n Enter Phone No : " + ANSI_RESET);
        PhoneNo = Integer.parseInt(br.readLine());
        System.out.print(ANSI_CYAN + " Enter Age : " + ANSI_RESET);
        Age = Integer.parseInt(br.readLine());
        System.out.print(ANSI_CYAN + " Enter Email : " + ANSI_RESET);
        Email = br.readLine();
        System.out.print(ANSI_CYAN + " Enter Address : " + ANSI_RESET);
        Address = br.readLine();
        System.out.print(ANSI_CYAN + " Enter Blood Group : " + ANSI_RESET);
        BloodGroup = br.readLine();
        System.out.print(ANSI_CYAN + " Enter Date of Birth : " + ANSI_RESET);
        DOB = new SimpleDateFormat("dd/mm/yyyy").parse(null);
        System.out.print(ANSI_CYAN + " Enter Gender : " + ANSI_RESET);
        Gender = br.readLine();
        System.out.print(ANSI_CYAN + " Enter Qualification : " + ANSI_RESET);
        Qualification = br.readLine();
        System.out.print(ANSI_CYAN + " Enter Long Term Illness : " + ANSI_RESET);
        LongTermIllness = br.readLine();
        System.out.print(ANSI_CYAN + " Enter Aadhaar No : " + ANSI_RESET);
        AadhaarNo = Integer.parseInt(br.readLine());
        System.out.print(ANSI_CYAN + " Enter Pancard No : " + ANSI_RESET);
        PancardNo = br.readLine();
        std = new MyInformation(Name,PhoneNo,Age,Email,Address,BloodGroup,DOB,Gender,Qualification,LongTermIllness,AadhaarNo,PancardNo);
        boolean result = database.insertData(std);
        System.out.println(result ? ANSI_GREEN + "\n Information Created !" + ANSI_RESET
                : ANSI_RED + "\n Information Not Created !" + ANSI_RESET);
    }

}