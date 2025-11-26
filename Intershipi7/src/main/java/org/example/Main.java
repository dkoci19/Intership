package org.example;
import java.sql.*;

public class Main {

    private static final String URL = "jdbc:postgresql://localhost:5432/internshipdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "deni1234";

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            ResultSet tables = conn.getMetaData().getTables(null, null, "%", new String[]{"TABLE"});
            while (tables.next()) {
                System.out.println(tables.getString("TABLE_NAME"));
            }

            Statement stmt1 = conn.createStatement();
            ResultSet rs1 = stmt1.executeQuery("SELECT * FROM kursi");
            while (rs1.next()) {
                System.out.println(rs1.getInt("kursi_id") + " | " + rs1.getString("emri"));
            }

            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(
                    "SELECT s.emri, n.nota FROM studentet s " +
                            "JOIN notat n ON s.student_id = n.student_id " +
                            "WHERE n.nota > 10"
            );
            while (rs2.next()) {
                System.out.println(rs2.getString("emri") + " | " + rs2.getInt("nota"));
            }

            PreparedStatement insert = conn.prepareStatement(
                    "INSERT INTO studentet (student_id, emri) VALUES (?, ?)"
            );
            insert.setInt(1, 2);
            insert.setString(2, "Ardit");
            insert.executeUpdate();
            System.out.println("\nStudent u shtua!");

            PreparedStatement update = conn.prepareStatement(
                    "UPDATE notat SET nota = ? WHERE student_id = ?"
            );
            update.setInt(1, 18);
            update.setInt(2, 2);
            update.executeUpdate();
            System.out.println("Piket u ndryshuan!");

            PreparedStatement deleteNotat = conn.prepareStatement(
                    "DELETE FROM notat WHERE student_id = ?"
            );
            deleteNotat.setInt(1, 2);
            deleteNotat.executeUpdate();

            PreparedStatement deleteStudent = conn.prepareStatement(
                    "DELETE FROM studentet WHERE student_id = ?"
            );
            deleteStudent.setInt(1, 2);
            deleteStudent.executeUpdate();

            System.out.println("Studenti u fshi!");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
