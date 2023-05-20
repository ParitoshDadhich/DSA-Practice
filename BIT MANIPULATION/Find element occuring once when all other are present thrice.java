// METHOD 1

class Solution {
    static int singleElement(int[] arr , int N) {
        int bitArray[] = new int[32];
        for(int i=0; i<arr.length; i++){
            setBits(arr[i], bitArray);
        }
        
        for(int i=0; i<bitArray.length; i++){
            bitArray[i] = bitArray[i]%3;
        }
 
        int decimalValue = 0;
        int t;
        for(int i=0; i<bitArray.length; i++){
            // decimalValue += Math.pow(2, i)*bitArray[i];
            // System.out.println(bitArray[i]);
            if(bitArray[i] != 0){
                t = 1<<i;
                decimalValue = t | decimalValue;
            }
        }
        
        return decimalValue;
    }
    
    static void setBits(int value, int bitArray[]){
        int bit = 1;
        for(int i=0; i<32; i++){
            if((value&bit) != 0){
                bitArray[i]++;
            }
            bit = bit<<1;
        }
    }
}


// METHOD 2
class Solution {
    static int singleElement(int[] arr , int N) {
        int result = 0;
        
        for(int i=0; i<32; i++){
            int x = 1<<i;
            
            int setBits = 0;
            for(int j=0; j<N; j++){
                if((arr[j]&x) != 0)
                    setBits++;
            }
            
            if(setBits%3 != 0)
                result |= x;
        }
        
        return result;
    }
}
