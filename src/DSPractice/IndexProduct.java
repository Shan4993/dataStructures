
public class IndexProduct {
	//Q: Return an array of the product of the array values not including the current index
	// SOURCE CAREER CAKE
	
	public static int[] math(int[] arr) {
        // write the body of your function here
        int[] res = new int[arr.length];
        int productSoFar = 1;
        for(int i=0;i<arr.length;i++){
            res[i] = productSoFar;
        	productSoFar *= arr[i];
        }
        productSoFar = 1;
        for(int i=arr.length-1 ; i>=0 ; i--){
            res[i] *= productSoFar;
            productSoFar *= arr[i];
        }
        
        return res;
    }
	
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int[] res = math(arr);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+ " ");
        }

    }
}
