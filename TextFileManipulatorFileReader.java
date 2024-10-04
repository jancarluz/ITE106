import java.io.File;
import java.util.Scanner;
public class TextFileManipulatorFileReader
{
	public static void main(String[] ards) throws Exception
	{

	File file = new File("C:\\Users\\CLAB01-PCE45\\Documents\\fsds\\jancarluzdeleon.txt");
	Scanner sc = new Scanner(file);
	
	while (sc.hasNextLine())
		System.out.println(sc.nextLine());
	}
}
