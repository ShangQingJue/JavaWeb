package dao.proxy;

import dao.IStudentDAO;
import dao.impl.StudentDAOImpl;
import daomain.Student;
import utils.DatabaseConnection;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOProxy implements IStudentDAO {
    private DatabaseConnection dbc = null;
    private IStudentDAO dao = null;

    public StudentDAOProxy() throws Exception {
        this.dbc = new DatabaseConnection();
        this.dao = new StudentDAOImpl(this.dbc.getConnection());
    }

    @Override
    public void create(Student student) throws Exception {
        try {
            this.dao.create(student);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public void delete(String sid) throws Exception {
        try {
            this.dao.delete(sid);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public void update(Student student) throws Exception {
        try {
            this.dao.update(student);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public List<Student> read(String find) throws Exception {
        List<Student> students = null;
        try {
            students = this.dao.read(find);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbc.close();
        }
        return students;
    }

    @Override
    public List<Student> all() throws Exception {
        List<Student> students = null;
        try {
            students = this.dao.all();
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbc.close();
        }
        return students;
    }

    @Override
    public String getNewSid() throws Exception {
        String newSid = null;
        try {
            newSid = this.dao.getNewSid();
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbc.close();
        }
        return newSid;
    }
}
