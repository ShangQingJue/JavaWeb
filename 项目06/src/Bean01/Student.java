package Bean01;

public class Student {
    private String id;
    private String name;
    private String birthday;
    private String sex;
    private String[] hobby;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getSex() {
        return this.sex;
    }

    public String[] getHobby() {
        return this.hobby;
    }
}
