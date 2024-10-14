public class Main
{
    public static void main(String[] args){
        Lamp led = new Lamp();
        Lamp halogen = new Lamp();
        led.turnOn();

        halogen.turnOff();
    }
}
