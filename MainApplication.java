import DAO.CourseJDBC;
import DAO.EnrollJDBC;
import DAO.StudentJDBC;
import Model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Olimpiu on 3/13/2017.
 */
public class MainApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        StudentJDBC studentJDBCTemplate = (StudentJDBC)context.getBean("studentJDBC");
        CourseJDBC courseJDBCTemplate = (CourseJDBC)context.getBean("courseJDBC");
        EnrollJDBC enrollJDBCTemplate = (EnrollJDBC)context.getBean("enrollJDBC");
    }
}

