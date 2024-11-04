public class Dog
{
    String name;
    String breed;
    int age;
    string color;
  
  public Dog(String name, String breed, int age,String color) {
    this.name = name;
    this.breed = breed;
    this.age = age;
    this.color = color;
  }

    public String getName(){
      return name;
    }
    public String getBreed(){
      return breed;
    }
      public String getAge(){
      return age;
    }
    public String getColor(){
      return color;
    }
    @Override
    public String toString() {
      return("Hi my name is " + this.getName() + "\n My breed, age, and color are " + this.getBreed() + ", " + this.getAge() + ", " + this.getColor());

    public static void main(String[] args) {
      Dog tuffy = new Dog("Tuffy", "Papillon", 5, "White");
      System.out.println(tuffy.toString());
    }
  }
