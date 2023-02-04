package my_pack;

import java.util.ArrayList;

public abstract class Department {
    private String depName = null;

    private static Human findingHuman = null;
    private static Department findingGroup = null;

    private static ArrayList<Department> deps = new ArrayList<>();
    private ArrayList<Human> humanInDepartment = new ArrayList<>();

    public static ArrayList<Department> getDeps() {
        return deps;
    }

    public static <T extends Department> void addDeps(T group) {
        deps.add(group);
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepName() {
        return depName;
    }

    public static void setFindingHuman() {
        findingHuman = null;
    }

    public static Human getFindingHuman() {
        return findingHuman;
    }

    public static void setFindingGroup() {
        findingGroup = null;
    }

    public static Department getFindingGroup() {
        return findingGroup;
    }

    public ArrayList<Human> getHumanInDepartment() {
        return humanInDepartment;
    }

    public <E extends Human> void addHuman(E human) {
        humanInDepartment.add(human);
    }

    public static boolean findHumanInDep(String fio, int age) {
        boolean result = false;
        for (Department dep : deps) {
            for (Human h : dep.getHumanInDepartment()) {
                if (h.getFio().equals(fio) && h.getAge().equals(age)) {
                    findingHuman = h;
                    findingGroup = dep;
                    result = true;
                }
            }
        }
        return result;
    }
}
