import java.util.ArrayList;

public class School {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;

    public School() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Student student : students) {
            result.append(student.toString()).append("\n");
        }

        for (Teacher teacher : teachers) {
            result.append(teacher.toString()).append("\n");
        }

        return result.toString();
    }
}
