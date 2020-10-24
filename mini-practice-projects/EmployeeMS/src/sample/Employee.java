package sample;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee  {
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;
    private String name;

    public static List<Employee> employeeList =new ArrayList<>();

    public Employee() {

    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
