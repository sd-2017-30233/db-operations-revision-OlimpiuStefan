package Model;

/**
 * Created by Olimpiu on 3/13/2017.
 */
public class Course {
    private Integer id;
    private String name;
    private String teacher;
    private Integer studyYear;

    public Course(){}

    public Course(Integer id, String name, String teacher, Integer studyYear) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.studyYear = studyYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Integer getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(Integer studyyYear) {
        this.studyYear = studyYear;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (!id.equals(course.id)) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        if (teacher != null ? !teacher.equals(course.teacher) : course.teacher != null) return false;
        return studyYear != null ? studyYear.equals(course.studyYear) : course.studyYear == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (studyYear != null ? studyYear.hashCode() : 0);
        return result;
    }
}

