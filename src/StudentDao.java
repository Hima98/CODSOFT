import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private static final String URL = "jdbc:mysql://localhost:3306/student_management";
    private static final String USER = "root";
    private static final String PASSWORD = "password"; // Replace with your MySQL password

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addStudent(Student student) {
        String query = "INSERT INTO students (stu_name, roll_number, grade, city) VALUES (?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, student.getStu_name());
            pst.setInt(2, student.getRoll_number());
            pst.setString(3, student.getGrade());
            pst.setString(4, student.getCity());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int stu_id) {
        String query = "DELETE FROM students WHERE stu_id = ?";
        try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, stu_id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection con = getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                Student student = new Student(rs.getInt("stu_id"), rs.getString("stu_name"), rs.getInt("roll_number"), rs.getString("grade"), rs.getString("city"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
