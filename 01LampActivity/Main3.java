import java.util.Scanner;

public class Main3
{
	static Scanner input = new Scanner(System.in);
	
	static Lamp led = new Lamp();
	static Lamp halogen = new Lamp();
	static Lamp Flourescent = new Lamp();
	static Lamp Incandescent = new Lamp();
	
	public static void main(String[] args) {
		
		led.name = args[0];
		halogen.name = args[1];
		Flourescent.name = args[2];
		Incandescent.name = args[3];
		
		led.isOn = Boolean.parseBoolean(args[4]);
		halogen.isOn = Boolean.parseBoolean(args[4]);
		Flourescent.isOn = Boolean.parseBoolean(args[4]);
		Incandescent.isOn = Boolean.parseBoolean(args[4]);
		
		LampStatusMethod(args[5], args[6], args[7], args[8]);
	}
	
	public static void LampStatusMethod(String led_new_stat, String halogen_new_stat, String flrscnt_new_stat, String incan_new_stat){
		// led
		System.out.println("===LED===");
		if (led.isOn == true) {
			if (Boolean.parseBoolean(led_new_stat) == true) {
				System.out.println("currently turned on");
				led.turnOn();
			}
			else {
				System.out.println("currently turned on");
				led.isOn = false;
				led.turnOff();
				System.out.println("turned off by " + led.name);
			}
		}
		else {
			if (Boolean.parseBoolean(led_new_stat) == true) {
				System.out.println("currently turned off");
				led.isOn = true;
				led.turnOn();
				System.out.println("turned on by " + led.name);
			}
			else {
				System.out.println("currently turned off");
				led.turnOff();
			}
		}
		
		// halogen
		System.out.println("===HALOGEN===");
		if (halogen.isOn == true) {
			if (Boolean.parseBoolean(halogen_new_stat) == true) {
				System.out.println("currently turned on");
				halogen.turnOn();
			}
			else {
				System.out.println("currently turned on");
				halogen.isOn = false;
				halogen.turnOff();
				System.out.println("turned off by " + halogen.name);
			}
		}
		else {
			if (Boolean.parseBoolean(halogen_new_stat) == true) {
				System.out.println("currently turned off");
				halogen.isOn = true;
				halogen.turnOn();
				System.out.println("turned on by " + halogen.name);
			}
			else {
				System.out.println("currently turned off");
				halogen.turnOff();
			}
		}
		
		// Flourescent
		System.out.println("===Flourescent===");
		if (Flourescent.isOn == true) {
			if (Boolean.parseBoolean(flrscnt_new_stat) == true) {
				System.out.println("currently turned on");
				Flourescent.turnOn();
			}
			else {
				System.out.println("currently turned on");
				Flourescent.isOn = false;
				Flourescent.turnOff();
				System.out.println("turned off by " + Flourescent.name);
			}
		}
		else {
			if (Boolean.parseBoolean(flrscnt_new_stat) == true) {
				System.out.println("currently turned off");
				Flourescent.isOn = true;
				Flourescent.turnOn();
				System.out.println("turned on by " + Flourescent.name);
			}
			else {
				System.out.println("currently turned off");
				Flourescent.turnOff();
			}
		}
		
		// Incandescent
		System.out.println("===Incandescent===");
		if (Incandescent.isOn == true) {
			if (Boolean.parseBoolean(incan_new_stat) == true) {
				System.out.println("currently turned on");
				Incandescent.turnOn();
			}
			else {
				System.out.println("currently turned on");
				Incandescent.isOn = false;
				Incandescent.turnOff();
				System.out.println("turned off by " + Incandescent.name);
			}
		}
		else {
			if (Boolean.parseBoolean(incan_new_stat) == true) {
				System.out.println("currently turned off");
				Incandescent.isOn = true;
				Incandescent.turnOn();
				System.out.println("turned on by " + Incandescent.name);
			}
			else {
				System.out.println("currently turned off");
				Incandescent.turnOff();
			}
		}
		
		String led_new_input;
		String halogen_new_input;
		String flrscnt_new_input;
		String incan_new_input;
		
		while(true){
			System.out.println("Do you want to change the status of the lamps? [YES | NO] ");
			String user_input = input.next();
			
			if (user_input.equals("YES")) {
				System.out.println("Type led new status [true | false]: ");
				led_new_input = input.next();
				
				System.out.println("Type halogen new status [true | false]: ");
				halogen_new_input = input.next();
				
				System.out.println("Type flourescent new status [true | false]: ");
				flrscnt_new_input = input.next();
				
				System.out.println("Type incandescent new status [true | false]: ");
				incan_new_input = input.next();
				
				LampStatusMethod(led_new_input, halogen_new_input, flrscnt_new_input, incan_new_input);
			}
			else if (user_input.equals("NO")) {
				break;
			}
		}
	}
}
