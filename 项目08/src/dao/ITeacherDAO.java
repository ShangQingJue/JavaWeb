package dao;

import daomain.Teacher;
import java.util.List;

public interface ITeacherDAO {
    public List<Teacher> read(String find) throws Exception;
    public List<Teacher> all() throws Exception;
}
