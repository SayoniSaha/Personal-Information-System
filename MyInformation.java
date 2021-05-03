// import java.util.*;
// import java.sql.Date;

public class MyInformation {
    int Age;
    String Name, PhoneNo, Email, Address, BloodGroup, Qualification, Gender, LongTermIllness, AadhaarNo, PancardNo;
    String DOB;

    MyInformation(String Name, String PhoneNo, int Age, String Email, String Address, String BloodGroup, String DOB,
            String Gender, String Qualification, String LongTermIllness, String AadhaarNo, String PancardNo) {
        this.Name = Name;
        this.PhoneNo = PhoneNo;
        this.Age = Age;
        this.Email = Email;
        this.Address = Address;
        this.BloodGroup = BloodGroup;
        this.DOB = DOB;
        this.Gender = Gender;
        this.Qualification = Qualification;
        this.LongTermIllness = LongTermIllness;
        this.AadhaarNo = AadhaarNo;
        this.PancardNo = PancardNo;
    }
}