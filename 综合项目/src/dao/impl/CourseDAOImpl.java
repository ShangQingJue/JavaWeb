package dao.impl;

import dao.ICourseDAO;
import daomain.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements ICourseDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public CourseDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Course> read(String find) throws Exception {
        List<Course> courses = new ArrayList<Course>();
        String sql = "SELECT * FROM course WHERE cid like ? OR cname like ? OR tid like ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, "%" + find + "%");
        this.pstmt.setString(2, "%" + find + "%");
        this.pstmt.setString(3, "%" + find + "%");
        ResultSet res = this.pstmt.executeQuery();
        Course course = null;
        while (res.next()) {
            course = new Course();
            course.setCid(res.getString("cid"));
            course.setCname(res.getString("cname"));
            course.setTid(res.getString("tid"));
            courses.add(course);
        }
        return courses;
    }

    @Override
    public List<Course> all() throws Exception {
        List<Course> courses = new ArrayList<Course>();
        String sql = "SELECT * FROM course";
        this.pstmt = this.conn.prepareStatement(sql);
        ResultSet res = this.pstmt.executeQuery();
        Course course = null;
        while (res.next()) {
            course = new Course();
            course.setCid(res.getString("cid"));
            course.setCname(res.getString("cname"));
            course.setTid(res.getString("tid"));
            courses.add(course);
        }
        return courses;
    }
}
