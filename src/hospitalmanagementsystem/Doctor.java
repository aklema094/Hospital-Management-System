
package hospitalmanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {
    
    private Connection connection;
    private Scanner scanner;
    
    Doctor(Connection con, Scanner sc){  
        this.connection = con;
        this.scanner = sc;      
    }
    
      public void viewDoctors(){
       try{
            String query = "select * from doctors";
            PreparedStatement pre = connection.prepareStatement(query);
            ResultSet resultSet = pre.executeQuery();
            System.out.println("+---------------+-------------------------+--------------------+");
            System.out.println("| Doctors Id    | Name                    | Specialization     |");
            System.out.println("+---------------+-------------------------+--------------------+");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                System.out.printf("|%-15s|%-25s|%-20s|\n", id, name,specialization);      
            }
            System.out.println("+---------------+-------------------------+-----+----------+");  
       }catch(SQLException e){
           System.out.println("failed to load"+e.getMessage());
           e.printStackTrace();
       }    
        
    }
    
}
