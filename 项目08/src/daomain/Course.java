package daomain;

public class Course {
    private String cid;
    private String cname;
    private String tid;

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public String getTid() {
        return tid;
    }
}
