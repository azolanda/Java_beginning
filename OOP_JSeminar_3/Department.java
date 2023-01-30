import java.util.ArrayList;

public abstract class Department {
    private String depName = null;

    private ArrayList<Human> humanInDepartment = new ArrayList<>();

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepName() {
        return depName;
    }

    public void addHuman(Human human) {
        humanInDepartment.add(human);
    }

    public ArrayList<Human> getHumanInDepartment() {
        return humanInDepartment;
    }
}
