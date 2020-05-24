package dao.proxy;

import dao.ITeacherDAO;
import dao.impl.TeacherDAOImpl;
import daomain.Teacher;
import utils.DatabaseConnection;
import java.util.List;

public class TeacherDAOProxy implements ITeacherDAO {
    private DatabaseConnection dbc = null;
    private ITeacherDAO dao = null;

    public TeacherDAOProxy() throws Exception {
        this.dbc = new DatabaseConnection();
        this.dao = new TeacherDAOImpl(this.dbc.getConnection());
    }

    @Override
    public List<Teacher> read(String find) throws Exception {
        List<Teacher> teachers = null;
        try {
            teachers = this.dao.read(find);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbc.close();
        }
        return teachers;
    }

    @Override
    public List<Teacher> all() throws Exception {
        List<Teacher> teachers = null;
        try {
            teachers = this.dao.all();
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbc.close();
        }
        return teachers;
    }
}
