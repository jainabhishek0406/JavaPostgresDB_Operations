# Java Postgres Connection
# Java code to connect with postgres db
# Java postgres database
# postgres db operations- create, insert and select.

code with postgres db connection implementation using java code

Steps to connect.

1. postgres should be install on your local system or server.

2. clone code and update below values according to your postgres setup under PostgresConnection.java file

    private final String url = "jdbc:postgresql://localhost:5432/AbhishekTest";
    
    private final String user = "postgres";
    
    private final String password = "postgres";
    
3. I alraedy commited postgres dependent jar under lib folder, kindly update your IDE classpath for this.

4. after code execution with above steps you should be able to connect with postgres db and all operations will work like select, insert and create..
    
