import java.io.*;

public class TextFileBufferedReader {

	public static void main(String[] args) throws Exception
	{
	
		File file = new File("jancarluzdeleon.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while ((st = br.readLine()) != null)
		{
			System.out.println(st);
		}
	}
}
