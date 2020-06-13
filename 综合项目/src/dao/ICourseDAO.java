package dao;

import daomain.Course;
import java.util.List;

public interface ICourseDAO {
    public List<Course> read(String find) throws Exception;
    public List<Course> all() throws Exception;
}
