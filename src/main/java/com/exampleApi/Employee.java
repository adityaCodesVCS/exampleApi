package com.exampleApi;

                          //Java-74,75(19,20 Dec-24)-Remaining...

public class Employee {
    private int id;
    private String name;
    private int salary;

    //Here Constructor acts like setter...
    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

}
