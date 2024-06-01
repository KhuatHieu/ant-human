package entities;

import java.sql.*;

public class Human {

    private int humanid;
    private String humanname;
    private Date humandob;
    private boolean humangender;
    private int typeid;

    private String typename;

    public Human() {
    }

    public Human(String humanname, Date humandob, boolean humangender, int typeid) {
        this.humanname = humanname;
        this.humandob = humandob;
        this.humangender = humangender;
        this.typeid = typeid;
    }
    
    public Human(int humanid, String humanname, Date humandob, boolean humangender, int typeid) {
        this.humanid = humanid;
        this.humanname = humanname;
        this.humandob = humandob;
        this.humangender = humangender;
        this.typeid = typeid;
    }

    public int getHumanid() {
        return humanid;
    }

    public void setHumanid(int humanid) {
        this.humanid = humanid;
    }

    public String getHumanname() {
        return humanname;
    }

    public void setHumanname(String humanname) {
        this.humanname = humanname;
    }

    public Date getHumandob() {
        return humandob;
    }

    public void setHumandob(Date humandob) {
        this.humandob = humandob;
    }

    public boolean getHumangender() {
        return humangender;
    }

    public void setHumangender(boolean humangender) {
        this.humangender = humangender;
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
