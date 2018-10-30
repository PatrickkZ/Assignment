package course.entity;

public class CourseNotFoundException extends RuntimeException {
    private int courseId;
    public CourseNotFoundException(int courseId){ this.courseId=courseId; }
    public int getId() { return courseId; }
}
