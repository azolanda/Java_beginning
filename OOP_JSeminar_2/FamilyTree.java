import animals.Animal;
import animals.Cat;
import animals.Dog;
import animals.Hamster;

public class FamilyTree {
    public static void main(String[] args) {
        Animal catMasha = new Cat("Masha", "american bobtail", 3);
        Person grandmother = new Person("Mary Smith", "female", catMasha);

        Person daughter = new Person("Kate Smith", "female");

        Animal dogKolya = new Dog("Kolya", "dog", 2);
        Person son = new Person("John Smith", "male", dogKolya);

        grandmother.addPerson(daughter);
        grandmother.addPerson(son);

        Person grandson = new Person("David Smith", "male");
        son.addPerson(grandson);

        Person grandgranddaughter = new Person("Melissa Smith-Morgan", "female");
        grandson.addPerson(grandgranddaughter);

        Person grandgrandgranddaughter = new Person("Helen Morgan", "female");

        Animal hamsterHam = new Hamster("Ham", "dzungarian", 1);
        Person grandgrandgrandson = new Person("Sam Morgan", "male", hamsterHam);

        grandgranddaughter.addPerson(grandgrandgranddaughter);
        grandgranddaughter.addPerson(grandgrandgrandson);

        System.out.println("\"" + grandmother.hello() + "\"");
        grandmother.petAnimal(catMasha);
        System.out.println();

        String resultTree = ViewTree.makePersonList(grandmother, 0, 0);
        System.out.println(resultTree);
        ViewTree.savePersonList(resultTree);
    }
}