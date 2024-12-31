package hospitalmanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient {

    private Connection connection;
    private Scanner scanner;

    Patient(Connection con, Scanner sc) {
        this.connection = con;
        this.scanner = sc;
    }

    public void addPatient() {
        System.out.print("Enter patient name : ");
        String name = scanner.nextLine();
        System.out.print("Enter patient age : ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter patient gender : ");
        String gender = scanner.nextLine();

        try {
            String Quary = "INSERT INTO patients(name,age,gender) VALUES(?,?,?)";
            PreparedStatement preparedstatment = connection.prepareStatement(Quary);
            preparedstatment.setString(1, name);
            preparedstatment.setInt(2, age);
            preparedstatment.setString(3, gender);
            int affectedRows = preparedstatment.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Patient added Successfully");
            } else {
                System.out.println("Failed to add patient !! Try again.");
            }

        } catch (SQLException e) {
            System.err.println("An error occurred while processing the database operation: " + e.getMessage());
            e.printStackTrace();

        }

    }

}
