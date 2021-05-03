// import java.util.*;
import java.sql.Date;

public class MyInformation {
    int PhoneNo, Age, AadhaarNo;
    String Name, Email, Address, BloodGroup, Qualification, Gender, LongTermIllness,PancardNo;
    Date DOB;

    MyInformation(String Name, int PhoneNo, int Age, String Email, String Address, String BloodGroup, java.util.Date DOB,
            String Gender, String Qualification, String LongTermIllness, int AadhaarNo, String PancardNo) {
        this.Name = Name;
        this.PhoneNo = PhoneNo;
        this.Age = Age;
        this.Email = Email;
        this.Address = Address;
        this.BloodGroup = BloodGroup;
        this.DOB = (Date) DOB;
        this.Gender = Gender;
        this.Qualification = Qualification;
        this.LongTermIllness = LongTermIllness;
        this.AadhaarNo = AadhaarNo;
        this.PancardNo = PancardNo;
    }
}