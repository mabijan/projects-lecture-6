package Tamrin_Manzel_3;

import java.sql.SQLException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("""
                WELCOME
                WHICH SERVICE YOU WANT TO CHOOSE:
                ENTERING NEW STUDENT -> S
                DELETING A STUDENT -> D
                EDITING A STUDENT -> E
                """);

        Scanner scanner = new Scanner(System.in);

        String KEY = scanner.next();

        Student OBJECT = new Student();

        if (KEY.equals("s")) {

            OBJECT.GETTER();

        } else if (KEY.equals("d")) {

            OBJECT.DELETE();

        } else if (KEY.equals("e")) {

            OBJECT.EDIT();

        } else {

            System.out.println("""
                   INVALID KEY!
                   """);
        }

    }
}
