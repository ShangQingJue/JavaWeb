package dao.factory;

import dao.ICourseDAO;
import dao.ISCDAO;
import dao.IStudentDAO;
import dao.ITeacherDAO;
import dao.proxy.CourseDAOProxy;
import dao.proxy.SCDAOProxy;
import dao.proxy.StudentDAOProxy;
import dao.proxy.TeacherDAOProxy;

public class DAOFactory {
    public static IStudentDAO getIStudentDAOInstance() throws Exception {
        return new StudentDAOProxy();
    }

    public static ITeacherDAO getITeacherDAOInstance() throws Exception {
        return new TeacherDAOProxy();
    }

    public static ICourseDAO getICourseDAOInstance() throws Exception {
        return new CourseDAOProxy();
    }

    public static ISCDAO getISCDAOInstance() throws Exception {
        return new SCDAOProxy();
    }
}
