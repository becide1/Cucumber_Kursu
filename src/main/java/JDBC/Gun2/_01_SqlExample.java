package JDBC.Gun2;

import JDBC._Parent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _01_SqlExample extends _Parent {

    @Test
    public void relativeExample() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from city");

        rs.relative(5);   // en son bulunulan yerden 5 adim ilerideki satirin bilgisini aldik
        String cityName = rs.getString(2);
        System.out.println(cityName);

        rs.relative(6);   // en son bulunulan yerden 6 adim ilerideki row a gitti.
        cityName = rs.getString(2);
        System.out.println(cityName);
    }

    @Test
    public void lastFirstKeyword() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from city");

        rs.last();   // en son row a gidiyor
        String cityName = rs.getString("city");
        Integer countryId = rs.getInt("country_Id");

        System.out.println(cityName + " -- " + countryId);

        rs.first();   // en son row a gidiyor
        cityName = rs.getString("city");
        countryId = rs.getInt("country_Id");

        System.out.println(cityName + " -- " + countryId);
    }

    // address tablosundaki district alanini önce 10. satirdakini, sonra 22. satirdaki,
    // sonra en son satirdaki bilgisini yazdiriniz.

    @Test
    public void task1() throws SQLException {

        ResultSet rs = statement.executeQuery("select district from address");

        rs.absolute(10);
        String district = rs.getString(1);
        System.out.println(district);

        rs.relative(12);
        district = rs.getString(1);
        System.out.println(district);

        rs.last();
        district = rs.getString(1);
        System.out.println(district);

    }
}
