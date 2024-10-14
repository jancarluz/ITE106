class Main2
{
    public static void main(String[] args){

        Lamp led = new Lamp();
        Lamp halogen = new Lamp();
        Lamp flourescent = new Lamp();
        Lamp incandescent = new Lamp();
        
        led.name = args[0];
        halogen.name = args[1];
        flourescent.name = args[2];
        incandescent.name = args[3];

        led.ison = Boolean.parseBoolean(args[3]);
        led.turnOn();
        
        System.out.println("led is turned on by " + led.name);
        flourescent.turnOn();

        System.out.println("Flourescent is turned on by " +led.name);
        
        halogen.ison = Boolean.parseBoolean(args[1]);
        incandescent.isOn = Boolean.parseBoolean(args[1]);
        halogen.turnOff();
        
        System.out.println("halogen is turned off by " +flourescent.name);
        incandescent.turnOff();

        System.out.println("Incandescent is turned off by " + flourescent.name);

    }
}
