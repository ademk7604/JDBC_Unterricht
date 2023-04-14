package jdbc;

import java.sql.*;
import java.util.Scanner;

public class PreparedStatement01 {
    public static <scanner> void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scan = new Scanner(System.in);
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Ademk");
        Statement st =con.createStatement();
        //1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin
        // dinamik bir cagirma olacak,
        //1. Adim: Prepared statement query'sini olustur. (hazirifade)

        String sql1 = "UPDATE companies SET number_of_employees = ? WHERE company = ?"; // ? degistirilebilir degerlerim olacak

        //2.Adim: PreparedStatement objesini olustur. (hazirifade)
       PreparedStatement pst1 = con.prepareStatement(sql1);

       //3. Adim: set....() methodlari ile soru isaretleri icin deger girecegiz.
        pst1.setInt(1,999);
        pst1.setString(2, "IBM");

        //4.Adim: Execute query
        int updateRowSayisi = pst1.executeUpdate();
        System.out.println(updateRowSayisi+" satir guncelledi.");

        String sql2 = "SELECT * FROM companies";
        ResultSet result1 = st.executeQuery(sql2);
        while (result1.next()) {
            System.out.println(result1.getInt(1)+"--"+result1.getString(2)+"--"+result1.getInt(3));
        }
        System.out.println();
        pst1.setInt(1,15000);
        pst1.setString(2, "GOOGLE");

        //4.Adim: Execute query
        int updateRowSayisi2 = pst1.executeUpdate();
        System.out.println(updateRowSayisi2+" satir guncelledi.");

        String sql3 = "SELECT * FROM companies";
        ResultSet result2 = st.executeQuery(sql3);
        while (result2.next()) {
            System.out.println(result2.getInt(1)+"--"+result2.getString(2)+"--"+result2.getInt(3));
        }
        //2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullanın.

        String sql4 = "SELECT * FROM ?";

        PreparedStatement pst2 = con.prepareStatement(sql4);
        scan.nextLine();
        pst2.setString(1,"companies");

        ResultSet result4 = pst2.executeQuery();

        while (result4.next()) {
            System.out.println(result4.getInt(1)+"--"+result4.getString(2)+"--"+result4.getInt(3));
        }

        //Bir tablonun istenilen datasını prepared statement ile çağırmak için kullanılan method.
       /* public static void read_data(Connection con, String tableName ){

            try {

                String query = String.format("SELECT * FROM %s",tableName);//Format() methodu dinamik String oluşturmak için kullanılır.

                Statement statement = con.createStatement();
                //SQL query'yi çalıştır.
                ResultSet rs = statement.executeQuery(query);//Datayı çağırıp ResultSet konteynırına koyuyoruz.

                while (rs.next()){//Tüm datayı çağıralım.

                    System.out.println(rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getInt(3));

                }

            }catch (Exception e){
                System.out.println(e);
            }

        */
        }
    }