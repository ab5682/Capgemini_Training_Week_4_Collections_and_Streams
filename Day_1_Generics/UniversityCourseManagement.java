import java.util.ArrayList;
import java.util.List;
abstract class CourseType {
    String title;

    CourseType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class ExamCourse extends CourseType {
    ExamCourse(String title) {
        super(title);
    }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String title) {
        super(title);
    }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String title) {
        super(title);
    }
}

class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
    }

    public List<T> getCourses() {
        return courses;
    }

    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.getTitle());
        }
    }
}

public class UniversityCourseManagement {
    public static void main(String[] args) {
        Course<ExamCourse> examDept = new Course<>();
        examDept.addCourse(new ExamCourse("Mathematics"));
        examDept.addCourse(new ExamCourse("Physics"));

        Course<AssignmentCourse> assignmentDept = new Course<>();
        assignmentDept.addCourse(new AssignmentCourse("English"));
        assignmentDept.addCourse(new AssignmentCourse("History"));

        Course<ResearchCourse> researchDept = new Course<>();
        researchDept.addCourse(new ResearchCourse("Thesis Writing"));
        researchDept.addCourse(new ResearchCourse("Advanced AI"));

        System.out.println("Exam-Based Courses:");
        Course.displayCourses(examDept.getCourses());

        System.out.println("Assignment-Based Courses:");
        Course.displayCourses(assignmentDept.getCourses());

        System.out.println("Research-Based Courses:");
        Course.displayCourses(researchDept.getCourses());
    }
}
