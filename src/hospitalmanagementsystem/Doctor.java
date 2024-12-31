package hospitalmanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {

    private Connection connection;
    private Scanner scanner;

    Doctor(Connection con, Scanner sc) {
        this.connection = con;
        this.scanner = sc;
    }

    // view all doctors details
    public void viewDoctors() {
        try {
            String query = "select * from doctors";
            PreparedStatement pre = connection.prepareStatement(query);
            ResultSet resultSet = pre.executeQuery();
            System.out.println("+---------------+-------------------------+--------------------+");
            System.out.println("| Doctors Id    | Name                    | Specialization     |");
            System.out.println("+---------------+-------------------------+--------------------+");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                System.out.printf("|%-15s|%-25s|%-20s|\n", id, name, specialization);
            }
            System.out.println("+---------------+-------------------------+--------------------+");
        } catch (SQLException e) {
            System.out.println("failed to load" + e.getMessage());
            e.printStackTrace();
        }

    }

    // check doctor
    public boolean getDoctorById(int dId) {

        String Query = "SELECT * FROM doctors WHERE id =?";
        try {
            PreparedStatement pre = connection.prepareStatement(Query);
            pre.setInt(1, dId);
            ResultSet resultSet = pre.executeQuery();
            if (resultSet.next()) {
                System.out.println("+---------------+-------------------------+--------------------+");
                System.out.println("| Doctor Id    | Name                    | Specialization     |");
                System.out.println("+---------------+-------------------------+--------------------+");
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                System.out.printf("|%-15s|%-25s|%-20s|\n", id, name, specialization);
                System.out.println("+---------------+-------------------------+--------------------+");
                return true;
            } else {
                System.out.println("Doctor id not found");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("failed to load " + e.getMessage());
            e.printStackTrace();

        }
        return false;

    }

}
