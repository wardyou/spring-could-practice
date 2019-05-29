package practice.wyadmin.bean;

import java.util.List;

/**
 * 人
 *
 * @author
 * @create 2019-05-27 10:25
 */
public class People {
    private int id;
    private String name;
    private List<People> peoples;

    public List<People> getPeoples() {
        return peoples;
    }

    public void setPeoples(List<People> peoples) {
        this.peoples = peoples;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
