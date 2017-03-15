package DAO;

import Mapper.CourseMapper;
import Model.Course;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Olimpiu on 3/13/2017.
 */
public class CourseJDBC implements CourseDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    public void create(Integer id, String name, String teacher, Integer studyyear) {
        String SQL = "insert into Course (id, name, teacher, studyyear) values (?, ?, ?, ?)";
        jdbcTemplateObject.update( SQL, id, name, teacher, studyyear);
        System.out.println("Created Record Id = "+ id + " Name = " + name + " Teacher = " + teacher + " Study Year = "+studyyear);
        return;
    }

    public Course getCourse(Integer id)
    {
        String SQL = "SELECT * FROM course where id = ?";
        Course course=  (Course)jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new CourseMapper());
        return course;
    }
    public List<Course> listCourses() {
        String SQL = "select * from course";
        List <Course> courses = jdbcTemplateObject.query(SQL, new CourseMapper());
        return courses;
    }
    public void delete(Integer id) {
        String SQL = "delete from course where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
        return;
    }
    public void updateTeacher(Integer id, String teacher){
        String SQL = "update course set teacher = ? where id = ?";
        jdbcTemplateObject.update(SQL, teacher, id);
        System.out.println("Updated Record with ID = " + id);
        return;
    }

    public void updateCourseName(Integer id, String name){
        String SQL = "update course set name = ? where id = ?";
        jdbcTemplateObject.update(SQL, name, id);
        System.out.println("Updated Record with ID = " + id);
        return;
    }
}

