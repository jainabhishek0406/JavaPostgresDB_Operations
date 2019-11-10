import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Abhishek Jain
 */

class PostgresOperation {
    public String getQueryToCreateTable()
    {
        String queryString = "create table person " +
                "(name Char(20)," +
                "age INT," +
                "state Char(10))";
        return queryString;
    }

    public String getQueryToInsertData(){
        String queryString = "insert into person(name, age, state) values ('Abhishek Jain', 34, 'MP')" ;
        return queryString;
    }
}
public class EntryPoint {
    public static void main(String[] args) throws SQLException {
        System.out.println("#### Postgres DB connection Java implementation ####");

        Statement stmt = null;
        ResultSet resultSet = null;
        //creating PostgresConnection class object to get postgres db connection.
        PostgresConnection postgresConnection = new PostgresConnection();

        //calling getPostgresDBConnection() method to get connection
        Connection connection = postgresConnection.getPostgresDBConnection();

        //checking if connection is successful or not, and if success, closing also.
        if(connection != null) {
            System.out.println("Connected successfully with Postgres database.");
            connection.setAutoCommit(false);
            try {
                stmt = connection.createStatement();
                PostgresOperation postgresOperation = new PostgresOperation();

                //executing create query to create person table under postgres db.
                String queryToCreateTable = postgresOperation.getQueryToCreateTable();
                System.out.println("\nCreating PERSON table.");
                stmt.executeUpdate(queryToCreateTable);
                System.out.println("Table created successfully.");

                //executing insert query to insert data into postgres person table.
                String queryToInsertData = postgresOperation.getQueryToInsertData();
                System.out.println("\nInserting data into table.");
                stmt.executeUpdate(queryToInsertData);
                System.out.println("Data inserted successfully.");

                //executing select query to collect person table data in ResultSet
                System.out.println("\ngetting data from person table");
                resultSet = stmt.executeQuery( "SELECT * FROM person;" );

                System.out.println("printing data from person table");
                while ( resultSet.next() ) {
                    String  name = resultSet.getString("name");
                    int age  = resultSet.getInt("age");
                    String state = resultSet.getString("state");

                    //Printing data getting from postgress data base.
                    System.out.println( "\nNAME = " + name );
                    System.out.println( "AGE = " + age );
                    System.out.println( "state = " + state );
                    System.out.println();
                }

                //autocommit is false, because committing only if all above operations are successful, to avoid partial commit.
                connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                //closing all the connection or reference here.
                resultSet.close();
                stmt.close();
                connection.close();
            }
        }
    }
}
