package hw17.task10_12.task11;

import java.util.Objects;

public class People {
    private String name;
    private Integer age;
    private String sex;

    public People(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(name, people.name) &&
                Objects.equals(age, people.age) &&
                Objects.equals(sex, people.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}
