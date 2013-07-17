public class ReverseString{

	public static void main(String[] args){
		String straight;
		if (args.length == 0){
			straight = "My name is Charlie";
		}
		else straight = args[0];
		
		System.out.println(reverseString(straight));
	}
	public static String reverseString(String straight){
		int i,p, strLen;
		StringBuffer reverse = new StringBuffer();
		strLen = straight.length();
		p = strLen;
		for(i = strLen-1; i>=0 ;i--){
			if (i == 0) reverse.append(straight.substring(0,p));
			if (straight.charAt(i) == ' '){
				reverse.append(straight.substring(i+1,p));
				reverse.append(straight.charAt(i));
				p = i;
			}

		}
		return reverse.toString();
	}
}
