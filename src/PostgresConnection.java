import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Abhishek Jain
 */
public class PostgresConnection{
    //please modify below variables according to your postgres database setup
    private final String url = "jdbc:postgresql://localhost:5432/AbhishekTest";
    private final String user = "postgres";
    private final String password = "postgres";

    public Connection getPostgresDBConnection()
    {
        Connection connection = null;
        try {
            //I commited postgres dependent jar file under lib folder, kindly add this under classpath.
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        finally {
            //returning connection, when user is calling method getPostgresDBConnection()
            return connection;
        }
    }
}
