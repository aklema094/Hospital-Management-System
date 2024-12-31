
package hospitalmanagementsystem;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;



public class HospitalManagementSystem {
        
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String url = "jdbc:mysql://localhost:3306/hospital";
        String user = "root";
        String password = "29344";
        
        try(Connection connection = DriverManager.getConnection(url,user,password)){
            Patient patient = new Patient(connection,scanner);
            Doctor doctor = new Doctor(connection,scanner);
            //doctor.viewDoctors();
            doctor.getDoctorById(3);
            
            //patient.addPatient();
            //patient.viewPatients();
            //patient.getPatientById(10);
        }catch(SQLException e){
            System.err.println("Database connection failed"+e.getMessage());
            e.printStackTrace();
        }
   
    }
    
    
}
