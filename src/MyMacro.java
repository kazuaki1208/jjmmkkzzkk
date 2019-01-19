import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyMacro {

	public static void main(String[] args) {
		String str = "_$(MACRO)_$()_$(AAA)_$(BBB)";
		Pattern p = Pattern.compile("\\$\\([^\\$\\(\\)]*\\)");
		Matcher m = p.matcher(str);

//		System.out.println(m.find());

		String hitStr = null;
		StringBuilder hitValue = null;
		while(m.find()) {
			System.out.println("ヒット ： " + m.group());
			hitValue = new StringBuilder(m.group());
			System.out.println("内部文字列 ： "+hitValue.substring(2, hitValue.length()-1));

		}
	}

}
