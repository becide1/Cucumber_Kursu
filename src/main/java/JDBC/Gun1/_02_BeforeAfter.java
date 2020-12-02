package JDBC.Gun1;

import org.testng.annotations.*;
import java.sql.*;

public class _02_BeforeAfter {

    private Connection connection;
    private Statement statement;
    @BeforeTest
    public void beforeTest() throws SQLException {
        String url = "jdbc:mysql://test.medis.mersys.io:33306/sakila";
        // Veri tabanina ulasabilmek icin JDBC ye : db nin tipi (mysql), db nin yolu (test.medis.mersys.io)
        // db nin bulundugu bilgisayarin icindeki mysql db nin port numarsai (33306) ve db nin adi verildi.
        String username = "technostudy";
        String password = "zhTPis0l9#$&";

        connection = DriverManager.getConnection(url, username, password);   // Baglanti saglandi
        statement = connection.createStatement();   // Sorgularimi calistirabilmek icin bir yol olustur.
    }

    @AfterTest
    public void  afterTest() throws SQLException {
        connection.close();
    }

    @Test
    private void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        rs.next();
        String name = rs.getString("name");
        System.out.println(name);

        rs.next();
        name = rs.getString("name");
        System.out.println(name);

        rs.next();
        name = rs.getString("name");
        System.out.println(name);
    }

    @Test
    private void test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        rs.next();
        String name = rs.getString(2);   // indexler 1 den basliyor,
        System.out.println(name);                   // colon adi yerine index kullanilabilir

        rs.next();
        name = rs.getString(2);
        System.out.println(name);

        rs.next();
        name = rs.getString(2);
        System.out.println(name);
    }

    @Test
    private void test3() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        rs.next();   //English yazdi
        String name = rs.getString(2);
        System.out.println(name);

        rs.next();   // Italian yazdi
        name = rs.getString(2);
        System.out.println(name);

        rs.previous();   // bir yukari geriye gitti kayit göstergesi ve English yazdi
        name = rs.getString(2);
        System.out.println(name);
    }
}
