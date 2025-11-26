package org.example;

import java.sql.*;

public class Main {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "deni1234";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // PRINT ALL TABLES
            ResultSet tables = conn.getMetaData().getTables(null, null, "%", new String[]{"TABLE"});
            while (tables.next()) {
                System.out.println(tables.getString("TABLE_NAME"));
            }

            // SELECT FROM studentet
            Statement stmt1 = conn.createStatement();
            ResultSet rs1 = stmt1.executeQuery("SELECT * FROM studentet");
            while (rs1.next()) {
                System.out.println(rs1.getInt("student_id") + " | " + rs1.getString("emri"));
            }

            // JOIN example (nota > 10)
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(
                    "SELECT s.emri, n.nota FROM studentet s " +
                            "JOIN regjistrimet r ON s.student_id = r.student_id " +
                            "JOIN notat n ON r.regj_id = n.regj_id " +
                            "WHERE n.nota > 10"
            );

            while (rs2.next()) {
                System.out.println(rs2.getString("emri") + " | " + rs2.getInt("nota"));
            }

            // INSERT new student
            PreparedStatement insert = conn.prepareStatement(
                    "INSERT INTO studentet (student_id, emri) VALUES (?, ?)"
            );
            insert.setInt(1, 4);
            insert.setString(2, "Nora");
            insert.executeUpdate();
            System.out.println("\nStudent u shtua!");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
