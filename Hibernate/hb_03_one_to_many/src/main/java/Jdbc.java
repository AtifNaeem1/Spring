import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_01_one_to_one_uni?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            System.out.println("connection to database: " + jdbcUrl);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection Successful !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
