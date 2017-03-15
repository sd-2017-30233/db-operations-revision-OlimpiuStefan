package DAO;

import Mapper.StudentMapper;
import Model.Student;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Olimpiu on 3/13/2017.
 */
public class StudentJDBC implements StudentDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    public void create(Integer id, String name, String birthdate, String address) {
        String SQL = "insert into Student (id, name, birthdate, address) values (?, ?, ?, ?)";
        jdbcTemplateObject.update( SQL, id, name, birthdate, address);
        System.out.println("Created Record Id = "+ id + " Name = " + name + " Birth Date = " + birthdate + " Address = "+address);
        return;
    }
    public Student getStudent(Integer id)
    {
        String SQL = "SELECT * FROM student where id = ?";
        Student student=  (Student)jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new StudentMapper());
        return student;
    }
    public List<Student> listStudents() {
        String SQL = "select * from student";
        List <Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
        return students;
    }

    public void delete(Integer id) {
        String SQL = "delete from Student where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
        return;
    }
    public void updateAddress(String name, String address){
        String SQL = "update student set address = ? where name = ?";
        jdbcTemplateObject.update(SQL, address, name);
        System.out.println("Updated Record with Name = " + name);
        return;
    }
    public void updateName(Integer id, String name){
        String SQL = "update student set name = ? where id = ?";
        jdbcTemplateObject.update(SQL, name, id);
        System.out.println("Updated Record with ID = " + id);
        return;
    }
}
