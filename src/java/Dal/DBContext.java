package Dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

    protected Connection connection;

    public DBContext() {
        try {
            // Chỉnh sửa URL, tên người dùng và mật khẩu để xác thực với MS SQL Server của bạn
            String url = "jdbc:sqlserver://localhost:1433;databaseName=motel";
            String username = "sa";
            String password = "123456";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    // Phương thức này sẽ trả về kết nối hiện tại
    public Connection getConnection() {
        return connection; // Trả về kết nối đã được thiết lập
    }

    public static void main(String[] args) {
        try {
            DBContext db = new DBContext();
            if (db.connection != null) {
                System.out.println("success");
            } else {
                System.out.println("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
