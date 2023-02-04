package my_pack;

import java.util.Scanner;

public abstract class Human {
    private String fio = null;
    private String sex = null;
    private Integer age = null;
    private boolean hasGroup = false;

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFio() {
        return fio;
    }

    public String getSex() {
        return sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setHasGroup(boolean hasGroup) {
        this.hasGroup = hasGroup;
    }

    public boolean getHasGroup() {
        return hasGroup;
    }

    @Override
    public String toString() {
        return getFio();
    }

    public String getFullHumanInformation() {
        return "\nfio:" + getFio().toUpperCase() + "\nsex:" + getSex().toUpperCase() + "\nage:" + getAge()
                + "\n---------------";
    }

    public abstract boolean checkChoice(Scanner scan);
}