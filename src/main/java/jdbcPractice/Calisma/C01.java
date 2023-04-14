package jdbcPractice.Calisma;

import java.sql.*;

public class C01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1) Driver yukle
        Class.forName("org.postgresql.Driver");
        //2) Baglanti olustur.
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres","Ademk");
        //3) Statament
        Statement st = con.createStatement();
        //4 ResultSet
        ResultSet rs = st.executeQuery("select * from ogrenciler");
        //5 Sonuc Al
        while (rs.next()){
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+
                    rs.getString(3)+" "+rs.getString(4));
        }
        con.close();
        st.close();
        rs.close();

    }
}
