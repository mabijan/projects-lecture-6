package Tamrin_Manzel_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.*;

public class Student {

    String DATA;
    Long ID;

    static Scanner scanner = new Scanner(System.in);

    public void GETTER() throws SQLException, ClassNotFoundException {

     System.out.print("CODE:");
    Long CODE = scanner.nextLong();

        System.out.print("NAME:");
    String NAME = scanner.next();

        System.out.print("ENTRY_YEAR:");
    Long ENTRY_YEAR = scanner.nextLong();

        System.out.print("SCORE:");
    Long SCORE = scanner.nextLong();

        Class.forName("oracle.jdbc.driver.OracleDriver");

    String URL = "jdbc:oracle:thin:@localhost:1521:XE";

    Connection connection = DriverManager.getConnection(URL, "private", "12345");

    PreparedStatement preparedStatement =
            connection.prepareStatement("insert into STUDENT(CODE , NAME, ENTRY_YEAR, SCORE) values(?, ?, ?, ?)");

        preparedStatement.setLong(1,CODE);
        preparedStatement.setString(2, NAME);
        preparedStatement.setLong(3, ENTRY_YEAR);
        preparedStatement.setLong(4, SCORE);

        connection.setAutoCommit(false);

        preparedStatement.executeUpdate();

        connection.commit();

        preparedStatement.close();
        connection.close();

    }

    public void DELETE() throws SQLException, ClassNotFoundException {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String URL = "jdbc:oracle:thin:@localhost:1521:XE";

        Connection connection = DriverManager.getConnection(URL, "private", "12345");

        PreparedStatement preparedStatement =
                connection.prepareStatement("delete from STUDENT where CODE = ?");

        System.out.println("ENTER THE CODE YOU WANT TO DELETE:");

        Long KEY = scanner.nextLong();

        preparedStatement.setLong(1, KEY);

        connection.setAutoCommit(false);

        preparedStatement.executeUpdate();

        connection.commit();

        preparedStatement.close();
        connection.close();

    }

    public void EDIT() throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String URL = "jdbc:oracle:thin:@localhost:1521:XE";

        Connection connection = DriverManager.getConnection(URL, "private", "12345");


        System.out.println("""
               WHICH PROPERTY YOU WANT TO CHANGE?
               name -> 1
               entry_year -> 2
               score -> 3
               """);

        String KEY = scanner.next();

        System.out.println("""
                PLEASE ENTER YOUR ID:
                """);

        Long ID = scanner.nextLong();
        this.ID = ID;

        System.out.println("""
                PLEASE ENTER YOUR NEW DESIRED DATA:
                """);

        String DATA = scanner.next();
        this.DATA = DATA;


        switch (KEY) {
            case "1" -> {
                PreparedStatement preparedStatement1 =
                        connection.prepareStatement("update STUDENT set NAME = ? where CODE = ?");
                preparedStatement1.setString(1, DATA);
                preparedStatement1.setLong(2, ID);
                preparedStatement1.executeUpdate();
                connection.setAutoCommit(false);
                connection.commit();
                preparedStatement1.close();
                connection.close();
                break;
            }
            case "2" -> {
                PreparedStatement preparedStatement2 =
                        connection.prepareStatement("update STUDENT set ENTRY_YEAR = ? where CODE = ?");
                preparedStatement2.setString(1, DATA);
                preparedStatement2.setLong(2, ID);
                preparedStatement2.executeUpdate();
                connection.setAutoCommit(false);
                connection.commit();
                preparedStatement2.close();
                connection.close();
                break;
            }
            case "3" -> {
                PreparedStatement preparedStatement3 =
                        connection.prepareStatement("update STUDENT set SCORE = ? where CODE = ?");
                preparedStatement3.setString(1, DATA);
                preparedStatement3.setLong(2, ID);
                preparedStatement3.executeUpdate();
                connection.setAutoCommit(false);
                connection.commit();
                preparedStatement3.close();
                connection.close();
                break;
            }
            default -> System.out.println("invalid key!");
        }
    }
}
