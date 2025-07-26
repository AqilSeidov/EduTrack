package projects.processController;

import projects.model.Course;
import projects.model.Student;
import projects.model.Teacher;

public class EduSystem {
    Course[] courses;
    Student[] students;
    Teacher[] teachers;
    private int courseCount;
    private int studentCount;
    private int teacherCount;


    public Course[] getCourses() {
        return courses;
    }

    public Student[] getStudents() {
        return students;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void addCourse(Course course) {
        Course[] temp = new Course[++courseCount];
        for (int i = 0; i < courseCount - 1; i++) {
            temp[i] = courses[i];
        }
        temp[courseCount - 1] = course;
        courses = temp;
    }


    public void addStudent(Student student) {
        Student[] temp = new Student[++studentCount];
        for (int i = 0; i < studentCount - 1; i++) {
            temp[i] = students[i];
        }
        temp[studentCount - 1] = student;
        students = temp;
    }

    public void addTeacher(Teacher teacher) {
        Teacher[] temp = new Teacher[++teacherCount];

        for (int i = 0; i < teacherCount - 1; i++) {
            temp[i] = teachers[i];
        }
        temp[teacherCount - 1] = teacher;
        teachers = temp;
    }

    public void assignTeacherToCourse(int courseId, int teacherId) {

        Course tmpCourse = findCourseWithId(courseId);
        Teacher tmpTeacher = findTeacherWithId(teacherId);

        if (tmpTeacher != null && tmpCourse != null) {
            tmpTeacher.assignCourse(tmpCourse);
            tmpCourse.setTeacher(tmpTeacher);
        } else {
            System.out.println("Teacher assignment process couldn't be executed.");
        }
    }

    public void enrollStudentToCourse(int courseId, int studentId) {

        Course tmpCourse = findCourseWithId(courseId);
        Student tmpStudent = findStudentWithId(studentId);

        if (tmpStudent != null && tmpCourse != null) {
            tmpStudent.enrollToCourse(tmpCourse);
            tmpCourse.addStudent(tmpStudent);
        } else {
            System.out.println("Student enrollment process couldn't be executed");
        }
    }


    public void printAllCourses() {
        for (Course c : courses) {
            System.out.println(c.toString());
        }
    }

    public void printAllPeople() {
        for (Student student : students) {
            System.out.println(student);
        }
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    //Helper Methods

    private Teacher findTeacherWithId(int teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == teacherId) {
                return teacher;
            }
        }
        System.out.println("Teacher with " + teacherId + " ID not found");
        return null;
    }

    private Course findCourseWithId(int courseId) {
        for (Course course : courses) {
            if (course.getId() == courseId) {
                return course;
            }
        }
        System.out.println("Course with " + courseId + " ID not found");
        return null;
    }

    private Student findStudentWithId(int studentId) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        System.out.println("Student with " + studentId + " ID not found");
        return null;
    }

}
