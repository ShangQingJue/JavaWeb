package dao.impl;

import dao.ITeacherDAO;
import daomain.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAOImpl implements ITeacherDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public TeacherDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Teacher> read(String find) throws Exception {
        List<Teacher> teachers = new ArrayList<Teacher>();
        String sql = "SELECT * FROM teacher WHERE tid like ? OR tname like ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, "%" + find + "%");
        this.pstmt.setString(2, "%" + find + "%");
        ResultSet res = this.pstmt.executeQuery();
        Teacher teacher = null;
        while (res.next()) {
            teacher = new Teacher();
            teacher.setTid(res.getString("tid"));
            teacher.setTname(res.getString("tname"));
            teachers.add(teacher);
        }
        return teachers;
    }

    @Override
    public List<Teacher> all() throws Exception {
        List<Teacher> teachers = new ArrayList<Teacher>();
        String sql = "SELECT * FROM teacher";
        this.pstmt = this.conn.prepareStatement(sql);
        ResultSet res = this.pstmt.executeQuery();
        Teacher teacher = null;
        while (res.next()) {
            teacher = new Teacher();
            teacher.setTid(res.getString("tid"));
            teacher.setTname(res.getString("tname"));
            teachers.add(teacher);
        }
        return teachers;
    }
}
