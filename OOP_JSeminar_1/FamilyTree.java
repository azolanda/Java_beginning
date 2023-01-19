public class FamilyTree {
    public static void main(String[] args) {
        Person grandmother = new Person("Mary Smith", "female");
        Person daughter = new Person("Kate Smith", "female");
        Person son = new Person("John Smith", "male");
        grandmother.addPerson(daughter);
        grandmother.addPerson(son);
        Person grandson = new Person("David Smith", "male");
        son.addPerson(grandson);
        Person grandgranddaughter = new Person("Melissa Smith-Morgan", "female");
        grandson.addPerson(grandgranddaughter);
        Person grandgrandgranddaughter = new Person("Helen Morgan", "female");
        Person grandgrandgrandson = new Person("Sam Morgan", "male");
        grandgranddaughter.addPerson(grandgrandgranddaughter);
        grandgranddaughter.addPerson(grandgrandgrandson);

        String resultTree = ViewTree.makePersonList(grandmother, 0, 0);
        System.out.println(resultTree);
        ViewTree.savePersonList(resultTree);
    }
}