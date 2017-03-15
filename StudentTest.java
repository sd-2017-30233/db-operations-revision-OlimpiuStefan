package Tests;

import DAO.StudentJDBC;
import Model.Student;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Olimpiu on 3/15/2017.
 */
public class StudentTest extends TestCase {
    StudentJDBC studentJDBCTemplate;
    protected void setUp(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        studentJDBCTemplate = (StudentJDBC)context.getBean("studentJDBC");
    }
    public void testCreate()
    {

        Student student = new Student(1,"Eu","09/03/1996","Brad");
        studentJDBCTemplate.delete(1);
        studentJDBCTemplate.create(1,"Eu", "09/03/1996","Brad");
        Student studentTest = studentJDBCTemplate.getStudent(1);
        assertEquals(student,studentTest);
    }
    public void testUpdateName()
    {
        Student student = new Student(1,"Eueu","09/03/1996","Brad");
        studentJDBCTemplate.delete(1);
        studentJDBCTemplate.create(1,"Eu", "09/03/1996","Brad");
        studentJDBCTemplate.updateName(1,"Eueu");
        Student studentTest = studentJDBCTemplate.getStudent(1);
        assertEquals(student.getName(),studentTest.getName());
    }
    public void testFetchFromDB()
    {
        Student student = new Student(1,"Eueu","09/03/1996","Brad");
        Student studentTest = studentJDBCTemplate.getStudent(1);
        assertEquals(student.getName(),studentTest.getName());
    }
}

