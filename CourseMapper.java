package Mapper;

import Model.Course;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Olimpiu on 3/13/2017.
 */
public class CourseMapper implements RowMapper<Course> {
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        Course course = new Course();
        course.setId(rs.getInt("id"));
        course.setName(rs.getString("name"));
        course.setTeacher(rs.getString("teacher"));
        course.setStudyYear(rs.getInt("studyyear"));
        return course;
    }
}
