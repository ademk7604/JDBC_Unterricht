package jdbcPractice.Calisma;

import java.sql.*;

public class C03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres","Ademk");
        // Statement st = con.createStatement(); bunun nyerine prepared statement kullanmak daha faydali bos yer alan icindir..
        PreparedStatement ps = con.prepareStatement("select * from ogrenciler");
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("Stun Sayisi =" + rsmd.getColumnCount());
        System.out.println("1. Stunun ismi ="+rsmd.getColumnName(1));
        System.out.println("2. Stunun ismi ="+rsmd.getColumnName(2));
        System.out.println("3. Stunun ismi ="+rsmd.getColumnName(3));
        System.out.println("4. Stunun ismi ="+rsmd.getColumnName(4));
        System.out.println("1. Stunun ismi ="+rsmd.getColumnTypeName(1));
        System.out.println("2. Stunun ismi ="+rsmd.getColumnTypeName(2));
        System.out.println("3. Stunun ismi ="+rsmd.getColumnTypeName(3));
        System.out.println("4. Stunun ismi ="+rsmd.getColumnTypeName(4));

        System.out.println("4. Stunun ismi : "+rsmd.getTableName(2));
        con.close();
        ps.close();
        rs.close();



    }
}
