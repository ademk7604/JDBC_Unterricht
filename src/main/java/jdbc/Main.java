package jdbc;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        //DBWork objesini olustur.
        DBWork db = new DBWork();

        //connection fonktionumu cagir
       Connection con = db.connect_to_db("postgres","postgres","Ademk");

       //yeni table olusturma methodunu cagir
        db.createTable(con, "employees");
    }
}
