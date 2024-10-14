class Lamp2
{
    public String name;

    boolean isOn;

    void turnOn(){
        isOn = true;
        System.out.println("Light On? " + isOn);
    }
     void turnOff(){
        isOn = false;
            System.out.println("Light Off?" + isOn);
    }
}
