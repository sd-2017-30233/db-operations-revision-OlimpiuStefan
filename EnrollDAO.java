package DAO;

import Model.Enroll;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Olimpiu on 3/13/2017.
 */
public interface EnrollDAO {

    public void setDataSource(DataSource ds);

    public void create(String student, String course);

    public List<Enroll> listEnrolls();
}
