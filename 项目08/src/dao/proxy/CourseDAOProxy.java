package dao.proxy;

import dao.ICourseDAO;
import dao.impl.CourseDAOImpl;
import daomain.Course;
import utils.DatabaseConnection;
import java.util.List;

public class CourseDAOProxy implements ICourseDAO {
    private DatabaseConnection dbc = null;
    private ICourseDAO dao = null;

    public CourseDAOProxy() throws Exception {
        this.dbc = new DatabaseConnection();
        this.dao = new CourseDAOImpl(this.dbc.getConnection());
    }

    @Override
    public List<Course> read(String find) throws Exception {
        List<Course> courses = null;
        try {
            courses = this.dao.read(find);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbc.close();
        }
        return courses;
    }

    @Override
    public List<Course> all() throws Exception {
        List<Course> courses = null;
        try {
            courses = this.dao.all();
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbc.close();
        }
        return courses;
    }
}
