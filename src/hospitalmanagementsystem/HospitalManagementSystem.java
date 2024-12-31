
package hospitalmanagementsystem;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;



public class HospitalManagementSystem {
     private static final String url = "jdbc:mysql://localhost:3306/hospital";
       private static final String user = "root";
        private static final String password = "29344";
        
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println("Failed to load driver"+e.getMessage());
            e.printStackTrace();          
        }
        
       
        
        try(Connection connection = DriverManager.getConnection(url,user,password)){
            Patient patient = new Patient(connection,scanner);
            Doctor doctor = new Doctor(connection,scanner);
            while(true){
                System.out.println("              HOSPITAL MANAGEMENT SYSTEM"                );
                System.out.println("--------------------------------------------------------");
                System.out.println("1. Add Patient");
                System.out.println("2. View Patients");
                System.out.println("3. View Doctors");
                System.out.println("4. Book Appointment");
                System.out.println("5. Exit");
                System.out.print("Enter your choice : ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch(choice){
                    case 1:// add patient
                        patient.addPatient();
                        break;
                    case 2: // view patients
                        patient.viewPatients();
                        break;
                    case 3: // view Doctors
                        doctor.viewDoctors();
                        break;
                    case 4: // Book Appointment
                        break;
                    case 5 :
                        System.out.println("Thank you to use our service");
                        return;
                    default:
                        System.out.println("Enter valid choice!! Try again");    
                        
                }
            }
        }catch(SQLException e){
            System.err.println("Database connection failed"+e.getMessage());
            e.printStackTrace();
        }
   
    }
    
    
}
