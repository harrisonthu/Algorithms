import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode1 {


	    
	    public static List<Integer> findAnagrams(String s, String p) {
	        
	        char[] sAsChar = s.toCharArray();
	        char[] pAsChar = p.toCharArray();
	        
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        int max_index = s.length()-p.length();

            StringBuilder sb = new StringBuilder();

            StringBuilder pb = new StringBuilder();
	        
	        for(int i=0;i<max_index;i++){
	            
	            char[] s_tempArray = new char[p.length()];
	            char[] p_tempArray = new char[p.length()];
	            
	            for(int j=0;j<p.length();j++){
	                p_tempArray[j] = pAsChar[j];
	                s_tempArray[j] = sAsChar[j];
	                //System.out.println("p_tempArray[j]: "+ p_tempArray[j]);
	                //System.out.println("s_tempArray[j]: "+ s_tempArray[j]);
	            }// ab
	             // ab
	            Arrays.sort(p_tempArray);
	            Arrays.sort(s_tempArray);
	            
	            for(int k=0;k<s_tempArray.length;k++){
	            	pb.append(p_tempArray[k]);
	            }

	            for(int k=0;k<s_tempArray.length;k++){
	            	pb.append(p_tempArray[k]);
	            }
	            
	            String str = pb.toString();
	            String ptr = sb.toString();
	            
	            System.out.println("str: " + str);
	            System.out.println("ptr: " + ptr);
	            
	            
	            boolean isanagram = Arrays.equals(p_tempArray, s_tempArray);
	            if(isanagram){
	            	result.add(i);
	            }
	            
	        }
	        
	        return result;
	    }

	
	public static void main(String[] args) {
		//String s = "cbaebabacd";
		String s = "abab";
		String p = "ab";
		System.out.println(findAnagrams(s,p));

	}


}
