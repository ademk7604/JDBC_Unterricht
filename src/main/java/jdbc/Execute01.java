package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1. Adım: Driver'a kaydol
        Class.forName("org.postgresql.Driver");

        //2. Adım: Database'e bağlan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Ademk");

        //3. Adım: Statement oluştur.
        Statement st = con.createStatement();

        //4. Adım: Query çalıştır.

        //1.Örnek: "workers" adında bir table oluşturup "worker_id,worker_name, worker_salary" sütunlarını ekleyin.
        String sql1 = "CREATE TABLE workers(worker_id VARCHAR(50), worker_name VARCHAR(50), worker_salary INT)";
       // boolean result = st.execute(sql1);
        // System.out.println(result);//False return yapar, çünkü data çağrılmadı.

        //2.Örnek: Table'a worker_address sütunu ekleyerek alter yapın.
        String sql2 = "ALTER TABLE workers ADD worker_address VARCHAR(80)";
        st.execute(sql2);

        //3.Örnek: Drop workers table
        String sql3 = "DROP TABLE workers";
        st.execute(sql3);

        //5. Adım: Bağlantı ve Statement'ı kapat.
        con.close();
        st.close();

    }
}



/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.adim: driver a kaydol
        Class.forName("org.postgresql.Driver");

        //2.Adim: Database'e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Ademk"); // farkli methodlarmis gibi davraniyor. 3 parametreli kullaniyoruz
        // connecting con a atadim // DriverManager, surucu yonetiminden//
        // driver e baglanmadan bu baglantiyi olusturamiyorum.
        //3.Adim: Statement olustur. // e2e: end-to-end, uctan uca.
        Statement st = con.createStatement(); // createStatement():ifade olustur dedik. // burdan sonra postgree bagliyiz. // st conteinerimiz

        // 4. Adim : Query calisitr.
        //1.Example: "workers" adında bir table oluşturup "worker_id,worker_name, worker_salary" sütunlarını ekleyin

        st.execute("CREATE TABLE workers(worker_id VARCHAR(50), worker_name VARCHAR(50), worker_salary INT )");  // execute, calistir
        ///2.Örnek: workers tablosuna worker_address sütununu ekleyerek alter yapin.
        String sql2 = "ALTER TABLE workers ADD worker_address VARCHAR(80)";
        st.execute(sql2);

        ////3.Example: Drop workers table
        String sql3 = "DROP TABLE workers"; // herzaman tablo yu once siliyoruz sonra bu kodlari calistiriyoruz.
       // st.execute(sql3);

        //5.Adim : Baglanti ve Statement i kapat.
        con.close();
        st.close(); // bu son iki kod  guvenlik amacli, yapamamiz gerekir.


    }
}

 */
