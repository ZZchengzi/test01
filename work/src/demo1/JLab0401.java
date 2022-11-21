
class Pet{
    protected String name;
    public Pet(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    public String move(){
        return "run";
    }
    public String speak(){
        return "";
    }
    public String toString(){
        return "My pet " + name;
    }
}
class Dog extends Pet{
    protected int weight;
    public Dog(String s, int weight){
        super(s);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String speak() {
        return super.speak() + "Woof Woof";
    }
}
class JLab0501{
    public static void main(String[] args){
        Pet myPet = new Pet("George");
        Dog myDog = new Dog("snoopy",10);
        System.out.println(myPet.toString() + "\n" + "Speak: " +
                myPet.speak() +"\n" + myPet.move() + " " +
                myPet.getName() + "\n");
        System.out.println(myDog.toString() + "\n" + "Speak: " +
                myDog.speak() +"\n" + myDog.move() + " " +myDog.getName() + " " + myDog.getWeight() +"\n");
    }
}