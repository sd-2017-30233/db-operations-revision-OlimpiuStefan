package Tests;

import DAO.CourseJDBC;
import Model.Course;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Olimpiu on 3/15/2017.
 */
public class CourseTest extends TestCase {
    CourseJDBC courseJDBC;
    protected void setUp(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        courseJDBC = (CourseJDBC)context.getBean("courseJDBC");
    }
    public void testCreate()
    {
        Course course = new Course(1,"Olimpiu","Todor",3);
        courseJDBC.delete(1);
        courseJDBC.create(1,"Olimpiu","Todor",3);
        Course courseTest = courseJDBC.getCourse(1);
        assertEquals(course,courseTest);
    }
    public void testUpdateName()
    {
        Course course = new Course(1,"Eueu","09/03/1996",3);
        courseJDBC.delete(1);
        courseJDBC.create(1,"Eu", "09/03/1996",3);
        courseJDBC.updateCourseName(1,"Eueu");
        Course courseTest = courseJDBC.getCourse(1);
        assertEquals(course,courseTest);
    }
    public void testFetchFromDB()
    {
        Course student = new Course(1,"Eueu","09/03/1996",3);
        Course studentTest = courseJDBC.getCourse(1);
        assertEquals(student,studentTest);
    }
}

