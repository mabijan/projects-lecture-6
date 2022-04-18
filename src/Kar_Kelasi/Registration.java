package Kar_Kelasi;

import java.sql.*;
import java.util.*;

public class Registration {

    String Name;
    Long Pass;
    String username;
    String Email;
    Long KEY_PASS;

    Scanner scanner = new Scanner(System.in);

    public void Get_Data() {

        System.out.println("""
                WELCOME!
                PLEASE ENTER YOUR INFO FOR REGISTRATION!
                """);

        System.out.print("Name:");
        String Name = scanner.next();
        this.Name = Name;

        System.out.print("pass:");
        Long Pass = scanner.nextLong();
        this.Pass = Pass;

        System.out.print("Username:");
        String username = scanner.next();
        this.username = username;

        System.out.print("Email:");
        String Email = scanner.next();
        this.Email = Email;

    }

    public void Send_Info() throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String URL = "jdbc:oracle:thin:@localhost:1521:XE";

        Connection connection = DriverManager.getConnection(URL, "private", "12345");

        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into CLIENT(name , pass, username, Email) values(?, ?, ?, ?)");

        preparedStatement.setString(1, Name);
        preparedStatement.setLong(2, Pass);
        preparedStatement.setString(3, username);
        preparedStatement.setString(4, Email);

        connection.setAutoCommit(false);

        preparedStatement.executeUpdate();

        connection.commit();

      // System.out.print("PLEASE ENTER YOUR USERNAME:");
      // String client_user = scanner.next();

      // System.out.print("PLEASE ENTRE YOUR PASSWORD:");
      // Long client_pass = scanner.nextLong();

      // String KEY = String.valueOf(connection.prepareStatement("select pass from CLIENT where user = ?"));

      // preparedStatement.setString(1,
      //         client_user);

      // if (Objects.equals(KEY, client_user)) {
      //     System.out.println("LOGGED IN!");
      // } else {
      //     System.out.println("INVALID DATA!");
      // }

      // preparedStatement.close();
      // connection.close();

    }

    public void Loge_In() throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String URL = "jdbc:oracle:thin:@localhost:1521:XE";

        Connection connection = DriverManager.getConnection(URL, "private", "12345");

        Statement statement = connection.createStatement();

        connection.setAutoCommit(true);

        System.out.print("PLEASE ENTER YOUR USERNAME:");
        String client_user = scanner.next();

        System.out.print("PLEASE ENTRE YOUR PASSWORD:");
        Long client_pass = scanner.nextLong();

        PreparedStatement preparedStatement =
        connection.prepareStatement("select pass from CLIENT where username = ? ");

        preparedStatement.setString(1, client_user);

        /*String query = "select pass from CLIENT where username = '%s'";
        ResultSet rs = statement.executeQuery("select pass from CLIENT where username = '%s'");
        query = String.format(query, client_user);*/

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            Long KEY_PASS = resultSet.getLong("PASS");
            this.KEY_PASS = KEY_PASS;
        }

        if (KEY_PASS.equals(client_pass)) {

            System.out.println("LOGGED IN!");

        }
        statement.close();
        connection.close();

    }
}
