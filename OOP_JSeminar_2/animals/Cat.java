package animals;

public class Cat extends Animal {

    public Cat(String name, String breed, Integer age) {
        setName(name);
        setBreed(breed);
        setAge(age);
    }

    @Override
    public void voice() {
        System.out.println("Meow");
    }
}
