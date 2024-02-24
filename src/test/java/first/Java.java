package first;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Java {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// durga:

		// joins

		String[] s = { "sum", "num", "durga", "count" };

		String d = String.join(";", s);
		System.out.println(d);

		String name = Arrays.asList("sum", "num", "durga", "count").stream().collect(Collectors.joining("|"));
		System.out.println(name);

		int[] arr = { 1, 2, 3, 4, 5 };
		String str = Arrays.toString(arr).replaceAll("\\[|\\]|,|\\s", "");
		int num = Integer.parseInt(str);
		System.out.println(num);

		// without using colon

		if (System.out.printf("hello world") == null) {

		}
		// labels
		task: System.out.println("durga prasad");

		String myName = "durga";
		String result = "";

		String first = myName.substring(0, 1).toUpperCase();
		
		result = result + first + "";
		System.out.println(result);

	}

}
