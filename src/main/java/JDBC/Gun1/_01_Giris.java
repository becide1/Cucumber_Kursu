package JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Giris {

    @Test
    public void test1() throws SQLException {
        String url = "jdbc:mysql://test.medis.mersys.io:33306/sakila";
        // Veri tabanina ulasabilmek icin JDBC ye : db nin tipi (mysql), db nin yolu (test.medis.mersys.io)
        // db nin bulundugu bilgisayarin icindeki mysql db nin port numarsai (33306) ve db nin adi verildi.
        String username = "technostudy";
        String password = "zhTPis0l9#$&";

        Connection  connection = DriverManager.getConnection(url, username, password);   // Baglanti saglandi
        Statement statement = connection.createStatement();   // Sorgularimi calistirabilmek icin bir yol olustur.

        ResultSet rs = statement.executeQuery("select * from actor");   // calistirildi, sonuclar rs degiskenine set edildi
        // fakat performans icin bütün sonuclar bir anda rs ye aktarilmiyor. Biz komut verdikce satir satir gelecek.

        rs.next();   // göstergeyi sonraki adima getir, orada satir varsa, bütün satiri rs ye at.

        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");

        System.out.println(firstName + " " + lastName);


        rs.next();

        firstName = rs.getString("first_name");
        lastName = rs.getString("last_name");

        System.out.println(firstName + " " + lastName);

        connection.close();
    }

}
