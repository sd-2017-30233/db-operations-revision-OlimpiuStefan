package Tests;

import DAO.EnrollJDBC;
import Model.Enroll;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Olimpiu on 3/15/2017.
 */
public class EnrollTest extends TestCase {
    EnrollJDBC enrollJDBCTemplate;
    protected void setUp(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        enrollJDBCTemplate = (EnrollJDBC)context.getBean("enrollJDBC");
    }
    public void testCreate()
    {
        Enroll enroll = new Enroll("Olimpiu","Todoran");
        enrollJDBCTemplate.create("Olimpiu","Todoran");
        Enroll enrollTest = enrollJDBCTemplate.getEnroll("Olimpiu");
        assertEquals(enroll,enrollTest);
    }
    public void testFetchFromDB()
    {
        Enroll enroll = new Enroll("Olimpiu","Todoran");
        Enroll enrollTest = enrollJDBCTemplate.getEnroll("Olimpiu");
        assertEquals(enroll,enrollTest);
    }
}

