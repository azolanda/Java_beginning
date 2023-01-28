package animals;

public class Hamster extends Animal {

    public Hamster(String name, String breed, Integer age) {
        setName(name);
        setBreed(breed);
        setAge(age);
    }

    @Override
    public void voice() {
        System.out.println("Chif-Chif");
    }
}
