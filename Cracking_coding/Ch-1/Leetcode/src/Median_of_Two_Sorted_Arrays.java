
public class Median_of_Two_Sorted_Arrays {
	
	
	public static void main(String[] args) {
		
		int[] nums1 = {};
		int[] nums2 = {1};
		int[] temp = new int[nums1.length+ nums2.length];
		int index_max = nums1.length + nums2.length;
		
		int i =0;
		int j = 0;
		for(int k =0;k<index_max;k++){
			
			if(i<nums1.length && j< nums2.length){
				if(nums1[i]< nums2[j]){
					temp[k] = nums1[i];
					i++;
				}
				else{
					temp[k] = nums2[j];
					j++;
				}
			}
			
			else if (i<nums1.length){
				temp[k] = nums1[i];
				i++;
			}
			else{
				temp[k] = nums2[j];
				j++;
			}
			
		}
		
		double result = 0;
		int mid_index = index_max/2;
		System.out.println("index_max: "+ index_max);
		System.out.println("mid_index: "+ mid_index);
		

		if(mid_index < 0){
		    System.out.println(0);
		    System.exit(0);
		}
		
		if( index_max ==1){
			System.out.println(temp[0]);
		}
		
		//even
		if(index_max%2==0){
		    result = (temp[mid_index-1]+temp[mid_index])/2.0;
		    System.out.println("here");
		    System.out.println(result);
		}
		else if(index_max%2 !=0){ // odd
		    result = temp[mid_index];
		    System.out.println("hello");
		    System.out.println(result);
		}
		
		System.out.println("result: "+result);
	}
}
