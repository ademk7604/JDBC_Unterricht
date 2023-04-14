package jdbc;

import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Ademk");
        Statement st =con.createStatement();
        //1. Örnek: companies tablosundan en yüksek ikinci number_of_employees değeri olan company ve number_of_employees değerlerini çağırın.
        //--1. yol OFFSET ve FETCH NEXT kullanarak
        String sql1 = "select company, number_of_employees\n" +
                "FROM companies\n" +
                "ORDER BY number_of_employees DESC\n" +
                "OFFSET 1 ROW\n" +
                "FETCH NEXT 1 ROW ONLY";

       // st.execute(sql1); bunu tablo olustururken yapiyoruz
        ResultSet result1 = st.executeQuery(sql1); // getir diyoruz

        while (result1.next()) {
            System.out.println(result1.getString(1)+"--"+result1.getInt("number_of_employees")); // index le de calisiyor company de diyebilirdik
        }
       // --2.yol sapquery kullanimi
        String sql2 ="select company, number_of_employees\n" +
                "FROM companies\n" +
                "WHERE number_of_employees = (SELECT MAX(number_of_employees)\n" +
                "FROM companies\n" +
                "WHERE number_of_employees < (SELECT MAX(number_of_employees)\n" +
                "FROM companies))";
        ResultSet result2 =  st.executeQuery(sql2);
        while (result2.next()) {
            System.out.println(result2.getString(1)+"--"+result2.getInt("number_of_employees")); // index le de calisiyor company de diyebilirdik
        }
        con.close();
        st.close();
        result1.close();
        result2.close();
    }
}
