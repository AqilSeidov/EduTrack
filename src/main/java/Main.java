import projects.model.Course;
import projects.model.Student;
import projects.model.Teacher;
import projects.processController.EduSystem;

public class Main {

    public static void main(String[] args) {
        // Initialize EduSystem
        EduSystem eduSystem = new EduSystem();

        // Create 3 teachers (using different constructors)
        Teacher teacher1 = new Teacher("John Smith", "john.smith@university.edu", 125);
        Teacher teacher2 = new Teacher("Emily Johnson", "emily.j@university.edu", 135);
        Teacher teacher3 = new Teacher("Robert Brown", "robert.b@university.edu", 130);

        // Add teachers to system
        eduSystem.addTeacher(teacher1);
        eduSystem.addTeacher(teacher2);
        eduSystem.addTeacher(teacher3);

        // Create 5 students
        Student student1 = new Student("Alice Williams", "alice.w@student.edu", 115);
        Student student2 = new Student("Bob Miller", "bob.m@student.edu", 120);
        Student student3 = new Student("Charlie Davis", "charlie.d@student.edu", 110);
        Student student4 = new Student("Diana Wilson", "diana.w@student.edu", 125);
        Student student5 = new Student("Ethan Moore", "ethan.m@student.edu", 118);

        // Add students to system
        eduSystem.addStudent(student1);
        eduSystem.addStudent(student2);
        eduSystem.addStudent(student3);
        eduSystem.addStudent(student4);
        eduSystem.addStudent(student5);

        // Create 4 courses
        Course math = new Course("Mathematics", "STEM");
        Course physics = new Course("Physics", "STEM");
        Course history = new Course("History", "Humanities");
        Course literature = new Course("Literature", "Humanities");

        // Add courses to system
        eduSystem.addCourse(math);
        eduSystem.addCourse(physics);
        eduSystem.addCourse(history);
        eduSystem.addCourse(literature);

        // Assign teachers to courses
        eduSystem.assignTeacherToCourse(math.getId(), teacher1.getId());
        eduSystem.assignTeacherToCourse(physics.getId(), teacher1.getId());
        eduSystem.assignTeacherToCourse(history.getId(), teacher2.getId());
        eduSystem.assignTeacherToCourse(literature.getId(), teacher3.getId());

        // Enroll students to courses
        // Math - 3 students
        //eduSystem.enrollStudentToCourse(math.getId(), student1.getId());
        eduSystem.enrollStudentToCourse(math.getId(), student2.getId());
        eduSystem.enrollStudentToCourse(math.getId(), student3.getId());

        // Physics - 2 students
        eduSystem.enrollStudentToCourse(physics.getId(), student2.getId());
        eduSystem.enrollStudentToCourse(physics.getId(), student4.getId());

        // History - 4 students
        //eduSystem.enrollStudentToCourse(history.getId(), student1.getId());
        eduSystem.enrollStudentToCourse(history.getId(), student3.getId());
        eduSystem.enrollStudentToCourse(history.getId(), student4.getId());
        eduSystem.enrollStudentToCourse(history.getId(), student5.getId());

        // Literature - 1 student
        eduSystem.enrollStudentToCourse(literature.getId(), student5.getId());

        // Teachers
        System.out.println("\n==== TEACHER REPORTS ====");
        for (Teacher teacher : eduSystem.getTeachers()) {
            if (teacher != null) {
                System.out.println("\n--- " + teacher.getName() + " ---");
                // Generate report
                System.out.println(teacher.generateReport());

                // Assign and view schedule
                String[] schedule = {"Monday 9:00-11:00", "Wednesday 10:00-12:00"};
                teacher.assignSchedule(schedule);
                System.out.println("\nSchedule:");
                teacher.viewSchedule();
            }
        }

        // 8. Student operations
        System.out.println("\n==== STUDENT REPORTS ====");
        for (Student student : eduSystem.getStudents()) {
            if (student != null) {
                System.out.println("\n--- " + student.getName() + " ---");
                // Generate report
                System.out.println("Courses: " + student.generateReport());

                // Send message to teacher (first course's teacher)
                if (student.getCourses() != null && student.getCourses().length > 0) {
                    Teacher courseTeacher = student.getCourses()[0].getTeacher();
                    if (courseTeacher != null) {
                        student.sendNotification("Hello Professor, I have a question about the syllabus.");
                    }
                }
            }
        }

        // 9. Print all objects using toString()
        System.out.println("\n==== ALL OBJECTS ====");
        System.out.println("\n--- Teachers ---");
        for (Teacher teacher : eduSystem.getTeachers()) {
            if (teacher != null) {
                System.out.println(teacher);
            }
        }

        System.out.println("\n--- Students ---");
        for (Student student : eduSystem.getStudents()) {
            if (student != null) {
                System.out.println(student);
            }
        }

        System.out.println("\n--- Courses ---");
        for (Course course : eduSystem.getCourses()) {
            if (course != null) {
                System.out.println(course);
            }
        }
    }
}
