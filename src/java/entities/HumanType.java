package entities;

public class HumanType {

    private int typeid;
    private String typename;

    public HumanType() {
    }

    public HumanType(int typeid, String typename) {
        this.typeid = typeid;
        this.typename = typename;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

}
