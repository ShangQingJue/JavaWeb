package dao.impl;

import dao.ISCDAO;
import daomain.SC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SCDAOImpl implements ISCDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public SCDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<SC> read(String find) throws Exception {
        List<SC> scs = new ArrayList<SC>();
        String sql = "SELECT * FROM sc WHERE sid like ? OR cid like ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, "%" + find + "%");
        this.pstmt.setString(2, "%" + find + "%");
        ResultSet res = this.pstmt.executeQuery();
        SC sc = null;
        while (res.next()) {
            sc = new SC();
            sc.setSid(res.getString("sid"));
            sc.setCid(res.getString("cid"));
            scs.add(sc);
        }
        return scs;
    }

    @Override
    public List<SC> all() throws Exception {
        List<SC> scs = new ArrayList<SC>();
        String sql = "SELECT * FROM sc";
        this.pstmt = this.conn.prepareStatement(sql);
        ResultSet res = this.pstmt.executeQuery();
        SC sc = null;
        while (res.next()) {
            sc = new SC();
            sc.setSid(res.getString("sid"));
            sc.setCid(res.getString("cid"));
            scs.add(sc);
        }
        return scs;
    }
}
