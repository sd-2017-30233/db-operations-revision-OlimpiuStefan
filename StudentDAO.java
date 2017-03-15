package DAO;

import Model.Student;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Olimpiu on 3/13/2017.
 */
public interface StudentDAO {
    /**
     * initializes database resources ie. connection.
     */
    public void setDataSource(DataSource ds);

    /**
     * create a record in the Model.Student table.
     */
    public void create(Integer id, String name, String birthdate, String address);

    /**
     * list a record from the Model.Student table corresponding to a passed student id.
     */
    public Student getStudent(Integer id);

    /**
     * list all the records from the Model.Student table.
     */
    public List<Student> listStudents();

    /**
     * delete a record from the Model.Student table corresponding to a passed student id.
     */
    public void delete(Integer id);


    /**
     * update address record into the Model.Student table.
     */
    public void updateAddress(String name, String address);

    /**
     * update name into the Model.Student table
     * @param id
     * @param name
     */
    public void updateName(Integer id, String name);
}