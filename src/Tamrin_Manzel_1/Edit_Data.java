package Tamrin_Manzel_1;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Edit_Data {

    static Scanner scanner = new Scanner(System.in);

    public void INSERT() throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String URL = "jdbc:oracle:thin:@localhost:1521:XE";

        Connection connection = DriverManager.getConnection(URL, "private", "12345");

        System.out.print("ID:");
        Long ID = scanner.nextLong();

        System.out.print("pass:");
        String Pass = scanner.next();

        System.out.print("Username:");
        String username = scanner.next();

        System.out.print("Email:");
        String Email = scanner.next();

        System.out.print("Age:");
        String Age = scanner.next();

        System.out.print("Degree:");
        String Degree = scanner.next();

        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into PERSON(ID , username, Email, Password, age, Degree) values(?, ?, ?, ?, ?, ?)");

        preparedStatement.setLong(1, ID);
        preparedStatement.setString(2, username);
        preparedStatement.setString(3, Email);
        preparedStatement.setString(4, Pass);
        preparedStatement.setString(5, Age);
        preparedStatement.setString(6, Degree);

        preparedStatement.executeUpdate();

        connection.setAutoCommit(false);

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
               =====================================
               username -> 1
               email -> 2
               password -> 3
               age -> 4
               degree -> 5
               =====================================
               """);

       String KEY = scanner.next();

        System.out.println("""
                PLEASE ENTER YOUR ID:
                """);

        Long ID = scanner.nextLong();

        System.out.println("""
                PLEASE ENTER YOUR NEW DESIRED DATA:
                """);

        String DATA = scanner.next();

        switch (KEY) {
            case "1" -> {
                PreparedStatement preparedStatement1 =
                        connection.prepareStatement("update PERSON set USERNAME = ? where ID = ?");
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
                        connection.prepareStatement("update PERSON set EMAIL = ? where ID = ?");
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
                        connection.prepareStatement("update PERSON set PASSWORD = ? where ID = ?");
                preparedStatement3.setString(1, DATA);
                preparedStatement3.setLong(2, ID);
                preparedStatement3.executeUpdate();
                connection.setAutoCommit(false);
                connection.commit();
                preparedStatement3.close();
                connection.close();
                break;
            }
            case "4" -> {
                PreparedStatement preparedStatement4 =
                        connection.prepareStatement("update PERSON set AGE = ? where ID = ?");
                preparedStatement4.setString(1, DATA);
                preparedStatement4.setLong(2, ID);
                preparedStatement4.executeUpdate();
                connection.setAutoCommit(false);
                connection.commit();
                preparedStatement4.close();
                connection.close();
                break;
            }
            case "5" -> {
                PreparedStatement preparedStatement5 =
                        connection.prepareStatement("update PERSON set DEGREE = ? where ID = ?");
                preparedStatement5.setString(1, DATA);
                preparedStatement5.setLong(2, ID);
                preparedStatement5.executeUpdate();
                connection.setAutoCommit(false);
                connection.commit();
                preparedStatement5.close();
                connection.close();
                break;
            }
            default -> System.out.println("invalid key!");
        }


        }

        /*PreparedStatement preparedStatement =
                connection.prepareStatement("update PERSON set EMAIL = ? where ID = ?");
        preparedStatement.setString(1, DATA);
        preparedStatement.setInt(2, ID);

        System.out.println("the DB has been updated!" + preparedStatement.executeUpdate());*/

}
