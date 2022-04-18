package Tamrin_Manzel_2;

import java.sql.SQLException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Staff staff = new Staff();

        Scanner scanner =
                new Scanner(System.in);

        System.out.println("""
                WELCOME!
                IF YOU WANT TO REGISTER A NEW STAFF ENTER "s"
                OR IF YOU WANT TO DELETE A STAFF DATA ENTER "D"
                """);

        String key = scanner.next();

        if (key.equals("S")) {

            staff.GET_INFO();
        } else if (key.equals("D")) {

            staff.DELETE();
        } else {

            System.out.println("invalid key!");
        }
    }
}
