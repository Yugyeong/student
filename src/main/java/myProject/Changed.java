package myProject;

public class Changed extends AbstractEvent {

    private Long studentId;
    private String status;
    private String studentName;
    private String className;

    public Long getId() {
        return studentId;
    }

    public void setId(Long studentId) {
        this.studentId = studentId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
