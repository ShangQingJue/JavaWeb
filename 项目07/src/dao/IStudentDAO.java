package dao;

import daomain.Student;

import java.util.List;

public interface IStudentDAO {
    public void create(Student student) throws Exception;
    public void delete(String sid) throws Exception;
    public void update(Student student) throws Exception;
    public List<Student> read(String find) throws Exception;
    public List<Student> all() throws Exception;
    public String getNewSid() throws Exception;
}
