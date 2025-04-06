

1. **Setup MySQL Database**  
   - Ensure MySQL is installed and running.  
   - Create a database and an `Employee` table with columns `EmpID`, `Name`, and `Salary`.

2. **Update Database Credentials**  
   - Replace `your_database`, `your_username`, and `your_password` in the code with actual database credentials.

3. **Add MySQL JDBC Driver**  
   - Download and add `mysql-connector-java.jar` to your project’s classpath.

4. **Compile and Run the Program**  
   - Compile: `javac MySQLConnection.java`  
   - Run: `java MySQLConnection`

5. **Verify Output**  
   - Ensure that employee records are displayed correctly from the database.

//CODE

  package JavaExp7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnection {
    public static void main(String[] args) {
        // Step 2: Update these with your actual database credentials
        String url = "jdbc:mysql://localhost:3306/CompanyDB";
        String username = "root";
        String password = "Dipendra@1232";

        try {
            // Step 3: Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 4: Establish connection
            Connection connection = DriverManager.getConnection(url, "root", "Dipendra@1232");
            System.out.println("Connected to the database successfully!");

            // Execute SQL query
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Employee";
            ResultSet resultSet = statement.executeQuery(query);

            // Step 5: Verify Output
            System.out.println("Fetching employee records from database...\n");
            while (resultSet.next()) {
                int empId = resultSet.getInt("EmpID");
                String name = resultSet.getString("Name");
                double salary = resultSet.getDouble("Salary");

                System.out.println("EmpID: " + empId + ", Name: " + name + ", Salary: " + salary);
            }



            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 


   //OUTPUT
Connected to the database successfully!
Fetching employee records from database...

EmpID: 101, Name: Dipendra, Salary: 50000.0
EmpID: 102, Name: Yubraj, Salary: 60000.0
EmpID: 103, Name: Om, Salary: 55000.0

