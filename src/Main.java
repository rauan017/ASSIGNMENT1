import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        School school = new School();

        try (BufferedReader studentReader = new BufferedReader(new FileReader("D:\\OOP\\ASSIGNMENT-1\\src\\students.txt"));
             BufferedReader teacherReader = new BufferedReader(new FileReader("D:\\OOP\\ASSIGNMENT-1\\src\\teachers.txt"))) {

            String line;

            
            while ((line = studentReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 5) {
                    System.out.println(line);
                    continue;
                }
                try {
                    String name = parts[0];
                    String surname = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    boolean gender = parts[3].equalsIgnoreCase("male");
                    int studentID = Integer.parseInt(parts[4]);

                    Student student = new Student(name, surname, age, gender, studentID);
                    school.addStudent(student);
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing student data: " + line);
                }
            }

            while ((line = teacherReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 7) {
                    System.out.println(line);
                    continue;
                }
                try {
                    String name = parts[0];
                    String surname = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    boolean gender = parts[3].equalsIgnoreCase("male");
                    String subject = parts[4];
                    int yearsOfExperience = Integer.parseInt(parts[5]);
                    int salary = Integer.parseInt(parts[6]);

                    Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
                    school.addTeacher(teacher);
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing teacher data: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
        }

        System.out.println(school);
    }
}
