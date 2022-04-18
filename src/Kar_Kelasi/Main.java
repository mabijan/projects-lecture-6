package Kar_Kelasi;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Registration OBJET = new Registration();
        OBJET.Get_Data();
        OBJET.Send_Info();
        OBJET.Loge_In();

    }
}
