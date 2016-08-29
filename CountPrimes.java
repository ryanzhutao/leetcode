
public class CountPrimes {

	public int countPrimes(int n) {
        int i = 0; 
        int cnt = 0;
        for(i = 1; i < n; i++){
            if(isPrime(i)){
                cnt++;
            }
        }
        return cnt;
    }
    
    private boolean isPrime(int num){
        int i = 0;
        if(num <=1){
            return false;
        }
        for(i = 2; i*i<=num; i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    
    public int countPrimesSieve(int n) {
        int i = 0; 
        int cnt = 0;
        int j = 0;
        boolean[] isprime = new boolean[n];
        for(i = 2; i < n; i++){
        	isprime[i] = true;
        }
        for(i = 2; i*i < n; i++){
        	if(!isprime[i]){
        		continue;
        	}
        	for(j = i*i; j < n; j=j+i){
        		isprime[j] = false;
        	}
        }
        for(i = 2; i < n; i++){
        	if(isprime[i] == true){
        		cnt++;
        	}
        }
        return cnt;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
