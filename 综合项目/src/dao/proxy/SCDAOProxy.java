package dao.proxy;

import dao.ISCDAO;
import dao.impl.SCDAOImpl;
import daomain.SC;
import utils.DatabaseConnection;
import java.util.List;

public class SCDAOProxy implements ISCDAO {
    private DatabaseConnection dbc = null;
    private ISCDAO dao = null;

    public SCDAOProxy() throws Exception {
        this.dbc = new DatabaseConnection();
        this.dao = new SCDAOImpl(this.dbc.getConnection());
    }

    @Override
    public List<SC> read(String find) throws Exception {
        List<SC> scs = null;
        try {
            scs = this.dao.read(find);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbc.close();
        }
        return scs;
    }

    @Override
    public List<SC> all() throws Exception {
        List<SC> scs = null;
        try {
            scs = this.dao.all();
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbc.close();
        }
        return scs;
    }
}
