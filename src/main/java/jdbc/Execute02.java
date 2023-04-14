package jdbc;
import java.sql.*;

public class Execute02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Ademk");
        Statement st =con.createStatement();

        //1. Örnek:  region id'si 1 olan "country name" değerlerini çağırın.
        String sql1 = "SELECT country_name FROM countries WHERE region_id = 1";
        boolean r1 = st.execute(sql1);
        System.out.println(r1);//true yada false verir. çünkü data çağırma işlemi yaptık.

        //REcordları görmek için executeQuery() methodu kullanmalıyız.
        ResultSet result1 = st.executeQuery(sql1);

        while (result1.next()){

            System.out.println(result1.getString("country_name"));


        }

        //2.Örnek: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.
        String sql2 = "SELECT country_id, country_name FROM countries WHERE region_id > 2";
        ResultSet result2 = st.executeQuery(sql2);
        while (result2.next()){

            System.out.println(result2.getString("country_id")+"-->"+result2.getString("country_name"));

        }

        //3.Örnek: "number_of_employees" değeri en düşük olan satırın tüm değerlerini çağırın.

        String sql3 = "SELECT * FROM companies WHERE number_of_employees = (SELECT MIN(number_of_employees) FROM companies)";
        ResultSet result3 = st.executeQuery(sql3);

        while (result3.next()){
            System.out.println(result3.getInt("company_id")+"--"+result3.getString("company")+"--"+result3.getInt("number_of_employees"));
        }

        con.close();
        st.close();
    }
}
/*

import java.sql.*;

public class Execute02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","Ademk");
        Statement st = con.createStatement();
        //1. Example:  region id'si 1 olan "country name" değerlerini çağırın
        String sql1= "SELECT country_name FROM countries WHERE region_id =1"; // select data cagirmak demektir.
       boolean r1 = st.execute(sql1); // sadece olusup olusmadigini gostermek icin biilean verdi.
        System.out.println(r1); // true yada false verir. cunku data cagirma islemi yaptik.

        ResultSet result1 = st.executeQuery(sql1); // REcordlari gormek icin executequery kullaniyoruz
        while(result1.next()){ // pointerim siradaki data oldugu surece
            System.out.println(result1.getString("country_name"));
        }
        System.out.println("");
        //2.Örnek: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.
        String sql2= "SELECT country_id, country_name FROM countries WHERE region_id >2"; // select data cagirmak demektir.

        ResultSet result2 = st.executeQuery(sql2); // REcordlari gormek icin executequery kullaniyoruz
        while(result2.next()){ // pointerim siradaki data oldugu surece
            System.out.println(result2.getString("country_id")+"-->"+result2.getString("country_name"));
        }
        //3.Example: "number_of_employees" değeri en düşük olan satırın tüm değerlerini çağırın.
        /String sql3= "SELECT * FROM companies WHERE number_of_employees = (SELECT MIN(number_of_employees) FROM companies)";
        ResultSet result3= st.executeQuery(sql3);
        while (result3.next()) {
            System.out.println(result3.getInt("company_id")+"--"+result3.getString("company")+"--"+result3.getString("number_of_employees"));
            System.out.println(result3.getInt(1)+"--"+result3.getString(2)+"--"+result3.getString(3)); // bu sekilde de olur :)
        }
        con.close();
        st.close();
    }
}

 */
