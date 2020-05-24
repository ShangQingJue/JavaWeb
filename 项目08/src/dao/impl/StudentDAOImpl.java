package dao.impl;

import dao.IStudentDAO;
import daomain.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements IStudentDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public StudentDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void create(Student student) throws Exception {
        String sql = "INSERT INTO student VALUES(?, ?, ?, ?)";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, student.getSid());
        this.pstmt.setString(2, student.getSname());
        this.pstmt.setString(3, student.getSbirthday());
        this.pstmt.setInt(4, student.getSsex());
        this.pstmt.executeUpdate();
    }

    @Override
    public void delete(String sid) throws Exception {
        String sql = "DELETE FROM student WHERE sid = ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, sid);
        this.pstmt.executeUpdate();
    }

    @Override
    public void update(Student student) throws Exception {
        String sql = "UPDATE student SET sname = ?, sbirthday = ?, ssex = ? WHERE sid = ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, student.getSname());
        this.pstmt.setString(2, student.getSbirthday());
        this.pstmt.setInt(3, student.getSsex());
        this.pstmt.setString(4, student.getSid());
        this.pstmt.executeUpdate();
    }

    @Override
    public List<Student> read(String keyword) throws Exception {
        List<Student> students = new ArrayList<Student>();
        String sql = "SELECT * FROM student WHERE sid like ? OR sname like ? OR sbirthday like ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, "%" + keyword + "%");
        this.pstmt.setString(2, "%" + keyword + "%");
        this.pstmt.setString(3, "%" + keyword + "%");
        ResultSet res = this.pstmt.executeQuery();
        Student student = null;
        while (res.next()) {
            student = new Student();
            student.setSid(res.getString("sid"));
            student.setSname(res.getString("sname"));
            student.setSbirthday(res.getString("sbirthday"));
            student.setSsex(res.getInt("ssex"));
            students.add(student);
        }
        return students;
    }

    @Override
    public List<Student> all() throws Exception {
        List<Student> students = new ArrayList<Student>();
        String sql = "SELECT * FROM student";
        this.pstmt = this.conn.prepareStatement(sql);
        ResultSet res = this.pstmt.executeQuery();
        Student student = null;
        while (res.next()) {
            student = new Student();
            student.setSid(res.getString("sid"));
            student.setSname(res.getString("sname"));
            student.setSbirthday(res.getString("sbirthday"));
            student.setSsex(res.getInt("ssex"));
            students.add(student);
        }
        return students;
    }

    @Override
    public String getNewSid() throws Exception {
        String sql = "SELECT MAX(sid) FROM student";
        this.pstmt = this.conn.prepareStatement(sql);
        ResultSet res = this.pstmt.executeQuery();
        String newSid = null;
        while (res.next()) {
            newSid = res.getString("MAX(sid)");
            String[] strs = newSid.split("[^0-9]");
            String numStr = strs[strs.length - 1];
            int n = numStr.length();
            int num = Integer.parseInt(numStr) + 1;
            String added = String.valueOf(num);
            n = Math.min(n, added.length());
            newSid = newSid.subSequence(0, newSid.length() - n) + added;
        }
        return newSid;
    }
}
