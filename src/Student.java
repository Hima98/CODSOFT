public class Student {
    private int stu_id;
    private String stu_name;
    private int roll_number;
    private String grade;
    private String city;

    public Student(int stu_id, String stu_name, int roll_number, String grade, String city) {
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.roll_number = roll_number;
        this.grade = grade;
        this.city = city;
    }

    // Getters and Setters
    public int getStu_id() { return stu_id; }
    public void setStu_id(int stu_id) { this.stu_id = stu_id; }

    public String getStu_name() { return stu_name; }
    public void setStu_name(String stu_name) { this.stu_name = stu_name; }

    public int getRoll_number() { return roll_number; }
    public void setRoll_number(int roll_number) { this.roll_number = roll_number; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    @Override
    public String toString() {
        return "Student [stu_id=" + stu_id + ", stu_name=" + stu_name + ", roll_number=" + roll_number + ", grade=" + grade + ", city=" + city + "]";
    }
}
