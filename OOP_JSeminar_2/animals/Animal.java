package animals;

public abstract class Animal {
    private String name = null;
    private String breed = null;
    private Integer age = null;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " name:" + name + " breed:" + breed;
    }

    public abstract void voice();
}
