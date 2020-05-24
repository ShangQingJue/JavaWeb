package dao;

import daomain.SC;
import java.util.List;

public interface ISCDAO {
    public List<SC> read(String find) throws Exception;
    public List<SC> all() throws Exception;
}
