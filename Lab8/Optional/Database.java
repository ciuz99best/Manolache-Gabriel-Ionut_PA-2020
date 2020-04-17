import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
        private static Database singleton = new Database( );
        private static Connection connection;
        private Database() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/musicalbums", "dba", "sql");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        public static Database getInstance( ) {
            return singleton;
        }
        protected static Connection getConnection() {
            return connection;
        }
}
