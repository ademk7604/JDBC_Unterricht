package jdbcPractice;

import java.sql.*;

public class Query05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "Ademk");
        // Statement st = con.createStatement(); bunun nyerine prepared statement kullanmak daha faydali bos yer saglamiyor.
        Statement st = con.createStatement();

        //SORU: Öğrenciler tablosuna yen bir kayıt ekleyin (300, 'Sena Can', 12, 'K'
      // int s1 = st.executeUpdate("insert into ogrenciler values (302, 'Sena Can', 12, 'K')");
       // System.out.println(s1 + " Satir database'e eklendi");

        //SORU: Öğrenciler tablosuna birden fazla veri ekleyin
        // (400, 'Sena Can', 12, 'K'), (401, 'Sena Can', 12, 'K'), (402, 'Sena Can', 12, 'K')
        //1.Yol
        /*
        String [] veri = {"insert into ogrenciler values (401, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (402, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (403, 'Sena Can', 12, 'K')"};
        int count=0;
        for (String each: veri) {
           count = count + st.executeUpdate(each);// count ilk sifir ile geldi. ilk update ile count 1 oldu en son 3 olacak
        }
        System.out.println(count + " Satir Eklendi");
         */
        //2,yol
        String [] veri2 = {"insert into ogrenciler values (500, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (501, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (502, 'Sena Can', 12, 'K')"};
        for (String each:veri2){
            st.addBatch(each); // yukaridaki datalarin hepsini birlestiriyor.
        }
        st.executeBatch(); // Datalari tek seferde gonderiyor.
        System.out.println("Dtalar eklendi.");
    }
}
