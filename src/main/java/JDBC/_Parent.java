package JDBC;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _Parent {

    public Connection connection;
    public Statement statement;
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
}
