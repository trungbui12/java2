package entity;

public class Result {
    private Integer id;
    private Double mark;
    private Integer studentId;
    private Integer subjectId;

    public Result(Integer id, Double mark, Integer studentId, Integer subjectId) {
        this.id = id;
        this.mark = mark;
        this.studentId = studentId;
        this.subjectId = subjectId;
    }

    public Result(Double mark, Integer studentId, Integer subjectId) {
        this.mark = mark;
        this.studentId = studentId;
        this.subjectId = subjectId;
    }

    public Integer getId() { return id; }
    public Double getMark() { return mark; }
    public Integer getStudentId() { return studentId; }
    public Integer getSubjectId() { return subjectId; }

    public void setId(Integer id) { this.id = id; }
    public void setMark(Double mark) { this.mark = mark; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }
    public void setSubjectId(Integer subjectId) { this.subjectId = subjectId; }
}
