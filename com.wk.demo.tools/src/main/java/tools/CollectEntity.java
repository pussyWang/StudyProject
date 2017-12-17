package tools;

import java.util.Date;

/**
 * Created by aloneboy on 2017/12/9.
 */
public class CollectEntity {
    private long id;
    private int infoid;
    private short businessid;
    private float money;
    private double salary;
    private String title;
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getInfoid() {
        return infoid;
    }

    public void setInfoid(int infoid) {
        this.infoid = infoid;
    }

    public short getBusinessid() {
        return businessid;
    }

    public void setBusinessid(short businessid) {
        this.businessid = businessid;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
