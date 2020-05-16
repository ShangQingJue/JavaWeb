package dao.factory;

import dao.IStudentDAO;
import dao.impl.StudentDAOImpl;
import dao.proxy.StudentDAOProxy;

public class DAOFactory {
    public static IStudentDAO getIStudentDAOInstance() throws Exception {
        return new StudentDAOProxy();
    }
}
