package working;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main{
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser("richblood");
            dataSource.setPassword("Truongduy1!");
            dataSource.setServerName("localhost");

            Connection conn = dataSource.getConnection();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM globalsuperstore.orders LIMIT 10");

            while (rs.next()) {
                System.out.println(rs.getString(7)); //or rs.getString("column name");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}