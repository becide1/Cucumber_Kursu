package JDBC.Gun1;

import JDBC._Parent;
import org.testng.annotations.Test;
import java.sql.*;

public class _03_AbsoluteRelative extends _Parent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from film");

        rs.absolute(10);   // 10. satira git
        String title = rs.getString("title");
        System.out.println(title);

        rs.absolute(15);   // absolute verilen satira gider
        title = rs.getString("title");
        System.out.println(title);

        rs.relative(5);   // en son bulundugu yerden 5 ileri gider, yani 20. ye gider
        title = rs.getString("title");
        System.out.println(title);

        rs.relative(-3);   // en son bulundugu yerden 3 geriye gider, yani 17. ye gider
        title = rs.getString("title");
        System.out.println(title);
    }
}
