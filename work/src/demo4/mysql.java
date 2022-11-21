package demo4;

        import java.sql.*;

public class mysql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///bookmanager?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8";
        Connection connection = DriverManager.getConnection(url, "root", "123456");
        String sql = "select * from book";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println(resultSet);
        statement.close();
        connection.close();
    }
}
