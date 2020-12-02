package JDBC.Gun2;

import JDBC._Parent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _03_GetAllRowColumn extends _Parent {

    @Test
    public void test1() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = rs.getMetaData();   // sorgu listesine iliskin temel bilgilere ulasabiliyoruz bu fonksiyon ile.
        int columnCount = rsmd.getColumnCount();     // column sayisina ulastik

        System.out.println(columnCount);

        while (rs.next()){
            for (int i = 1; i <= columnCount; i++) {
                System.out.println(rs.getString(i));
            }
            System.out.println();
        }
    }

    // Task 1 : film tablosundaki bütün bilgileri listeletiniz.

    @Test
    public void task1() throws SQLException {


    }

    // Task 2 : film tablosundaki bütün bilgileri DÜZENLi listeletiniz.

}
