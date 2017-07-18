import java.util.Scanner;

	
public class Main {

	private static final long KEY = 98801;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter input. begin with 'd-' to de-, and with 'e-' to encrypt");
		while (true) {
			String line = scanner.nextLine();
			System.out.println(parse(line));
		}

	}

	private static String parse(String i) {
		String[] d = i.split("-", 2);
		switch (d[0]) {
		case "d":
			return decrypt(d[1]);
		case "e":
			return encrypt(d[1]);
		default:
			return "error";
		}
	}

	private static String decrypt(String i) {
		
		String decr = "";
		for (String s : i.split(":")) {
			long l = Long.parseLong(s);
			long m = (l/KEY)-KEY;
			decr = decr + (char) m;
		}
		return decr;
	}
	
	private static String encrypt(String i) {
		
		String encr = "";
		for (int x = 0; x < i.length(); x++) {
			long c = i.toCharArray()[x];
			long l = (c+KEY)*KEY;
			encr = encr + l + ":";
		}

		return encr;
	}
}
