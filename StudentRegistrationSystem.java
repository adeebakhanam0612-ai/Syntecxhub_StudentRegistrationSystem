import java.sql.*;

public class StudentRegistrationSystem {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String password = "root123"; // use your MySQL password

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Database Successfully!");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " "
                        + rs.getString("name") + " "
                        + rs.getString("email") + " "
                        + rs.getString("course"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}