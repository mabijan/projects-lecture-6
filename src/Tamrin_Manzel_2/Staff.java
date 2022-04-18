package Tamrin_Manzel_2;

import java.util.*;
import java.sql.*;

public class Staff {

    public void GET_INFO() throws SQLException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("ID:");
        Long ID = scanner.nextLong();

        System.out.print("Name:");
        String Name = scanner.next();

        System.out.print("ID_code:");
        String Id_code = scanner.next();

        System.out.print("Father_name:");
        String Father_name = scanner.next();

        System.out.print("Position:");
        String Position = scanner.next();

        System.out.print("Salary:");
        String Salary = scanner.next();

        System.out.print("Work_experience:");
        Long Work_experience = scanner.nextLong();

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String URL = "jdbc:oracle:thin:@localhost:1521:XE";

        Connection connection = DriverManager.getConnection(URL, "private", "12345");

        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into STAFF(ID , Name, IDcode, Father_name, position, Salary, work_experience) values(?, ?, ?, ?, ?, ?, ?)");

        preparedStatement.setLong(1, ID);
        preparedStatement.setString(2, Name);
        preparedStatement.setString(3, Id_code);
        preparedStatement.setString(4, Father_name);
        preparedStatement.setString(5, Position);
        preparedStatement.setString(6, Salary);
        preparedStatement.setLong(7, Work_experience);

        connection.setAutoCommit(false);

        preparedStatement.executeUpdate();

        connection.commit();

        preparedStatement.close();
        connection.close();

    }

    public void DELETE() throws ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String URL = "jdbc:oracle:thin:@localhost:1521:XE";

        Connection connection = DriverManager.getConnection(URL, "private", "12345");

        PreparedStatement preparedStatement =
                connection.prepareStatement("delete from STAFF where ID = ?");

        System.out.print("ENTER THE STAFF ID YOU WANT TO DELETE:");

        int KEY = scanner.nextInt();

        preparedStatement.setInt(1, KEY);

        connection.setAutoCommit(false);

        preparedStatement.executeUpdate();

        connection.commit();

        preparedStatement.close();
        connection.close();

    }
}
