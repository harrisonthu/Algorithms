
public class Test1 {
	
	 
    public static int countSegments(String s) {
    	    int res=0;
    	    for(int i=0; i<s.length(); i++)
    	        if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' ')){    	        	
    	            res++;
    	        }
    	    return res;
    	}

	
	public static void main(String[] args){
		String input = "Hello, my name is John";
		System.out.println(countSegments(input));
		int temp = 5;
		System.out.println("final result: "+temp/3);
		
	}

}
