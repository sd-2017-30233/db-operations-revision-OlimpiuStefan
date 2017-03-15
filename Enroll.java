package Model;

/**
 * Created by Olimpiu on 3/13/2017.
 */
public class Enroll {
    String name;
    String course;

    public Enroll(){}

    public Enroll(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enroll enroll = (Enroll) o;

        if (name != null ? !name.equals(enroll.name) : enroll.name != null) return false;
        return course != null ? course.equals(enroll.course) : enroll.course == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (course != null ? course.hashCode() : 0);
        return result;
    }
}

