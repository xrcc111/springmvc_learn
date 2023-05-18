package com.xr.vo;

/**
 * @author xurui
 * @create 2023-05-17 0:09
 */
public class Student {
    private String name;
    private Integer age;
    private String email;
    private String male;

    public Student() {
    }

    public Student(String name, Integer age, String email, String male) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.male = male;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", male='" + male + '\'' +
                '}';
    }
}
