package daomain;

public class Student {
    private String sid;
    private String sname;
    private String sbirthday;
    private int ssex;

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSid() {
        return sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSname() {
        return sname;
    }

    public void setSbirthday(String sbirthday) {
        this.sbirthday = sbirthday;
    }

    public String getSbirthday() {
        return sbirthday;
    }

    public void setSsex(int ssex) {
        this.ssex = ssex;
    }

    public int getSsex() {
        return ssex;
    }
}
