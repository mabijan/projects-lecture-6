package Tamrin_Manzel_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Edit_Data OBJECT = new Edit_Data();

        OBJECT.INSERT();

       /* System.out.println("""
                WANT TO CHANGE ANYTHING?(Y/N)
                """);

        String key = scanner.next();*


    if (key.equals("Y")) {

            OBJECT.EDIT();

        }*/
    }
}
