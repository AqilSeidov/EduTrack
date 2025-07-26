package projects.model;

import projects.interfaces.Reportable;
import projects.interfaces.Schedulable;

import java.util.Arrays;
import java.util.Objects;

public class Teacher extends Person implements Schedulable, Reportable {

    private Course[] assignedCourses;
    private int courseCount = 0;
    private String[] schedule;

    public Teacher(String name, String email, int IQ) {
        super(name, email, IQ);
    }

    public Course[] getAssignedCourses() {
        return assignedCourses;
    }

    public void setAssignedCourses(Course[] assignedCourses) {
        this.assignedCourses = assignedCourses;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(int courseCount) {
        this.courseCount = courseCount;
    }

    public String[] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[] schedule) {
        this.schedule = schedule;
    }


    public void assignCourse(Course course) {
        if (course == null) {
            System.out.println("Course can't be null");
            return;
        }
        if (courseCount > 3) {
            System.out.println("No More Course Can Be Assigned");

        } else {
            Course[] temp = new Course[++courseCount];
            for (int i = 0; i < courseCount-1; i++) {
                temp[i] = assignedCourses[i];
            }
            temp[courseCount-1] = course;
            assignedCourses = temp;
        }
    }

    public void listAssignedCourses() {
        for (Course c : assignedCourses) {
            System.out.println(c.getName());
        }
    }

    @Override
    public void assignSchedule(String[] days) {
        schedule = days;
    }

    @Override
    public void viewSchedule() {
        if (schedule == null || schedule.length == 0) {
            System.out.println("Schedule is Empty");
        } else {
            for (String day : schedule) {
                System.out.println(day);
            }
        }
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("Teacher " + getName());
        report.append("\nAssigned Courses: " + getCourseNames());

        if (courseCount > 0) {
            for (Course c : assignedCourses) {
                report.append("\nStudents of " + c.getName() + " course: " + c.studentNames());
            }
        }
        return report.toString();
    }

    // Helper Method for generateReport...
    public String getCourseNames() {

        if (assignedCourses == null || assignedCourses.length == 0) {
            return "No Courses Assigned";
        }
        StringBuilder sb = new StringBuilder();

        for (Course c : assignedCourses) {
            sb.append(c.getName() + ". ");
        }
        return sb.toString();
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Message: " + message);
    }

    @Override
    public void printInfo() {
        System.out.println("Teacher info: ");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("IQ: " + getIQ());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return courseCount == teacher.courseCount && Objects.deepEquals(assignedCourses, teacher.assignedCourses) && Objects.deepEquals(schedule, teacher.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(assignedCourses), courseCount, Arrays.hashCode(schedule));
    }

    @Override
    public String toString() {
        return   super.toString() +
                " | AssignedCourses=" + getCourseNames() +
                " | CourseCount=" + courseCount +
                " | Schedule=" + Arrays.toString(schedule);
    }
}
