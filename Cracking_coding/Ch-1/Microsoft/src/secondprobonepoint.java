/*
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class secondprobonepoint {

	public String decode(String decode){
		
		return 
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] t;
		String userinput = sc.nextLine();
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < userinput.length(); i++){
			String[] tokens = userinput.split(" ");
			for(int j=0;j<tokens.length;j++){
				t = tokens[j].split("-");
				map.put(t[0], t[1]);
			}
		}
		
		String decode = sc.nextLine();
		for(int i=0;i<decode.length();i++){
			char temp = decode.charAt(i);
			
			for(String key : map.keySet()){
		        if(map.get(key).equals(temp)){
		            return map.get(key); //return the first found
		        }
		    }
			
			
		}
		
	}

}

*/