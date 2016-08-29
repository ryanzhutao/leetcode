
public class WaterandJugProblem {

	public boolean canMeasureWater(int x, int y, int z) {
        int gcd = getGCD(x,y);
        if(gcd==0){
            return z==0;
        }
        if(z>(x+y)){
            return false;
        }
        if(z%gcd==0){
            return true;
        }else{
            return false;
        }
    }
    
    private int getGCD(int num1, int num2){
        if (num2==0){ 
            return num1;
        }
        return getGCD(num2,num1%num2);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
