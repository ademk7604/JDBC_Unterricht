package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Query04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "Ademk");
        // Statement st = con.createStatement(); bunun nyerine prepared statement kullanmak daha faydali bos yer saglamiyor.
        PreparedStatement ps = con.prepareStatement("insert into ogrenciler values(?,?,?,?)"); // 4 tane veri girecegiz 4 stnumuz vardi
        // prepareStatement in statement farki prepared de daha az yer kapliyor ve daha dinamiktir. sadece yukardaki yapi uzerinden veri gonderiyoruz
        ps.setInt(1,200);
        ps.setString(2, "Veli Can");
        ps.setString(3, "12");
        ps.setString(4, "E");

        ps.executeUpdate();
        System.out.println("Veri girisi yapildi. ");


    }
}
