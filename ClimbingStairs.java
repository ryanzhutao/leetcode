
public class ClimbingStairs {

	public int climbStairs(int n) {
        int p1 = 1;
        int p2 = 1;
        int p3 = 0;
        for(int i = 2; i <= n; i++){
            p3 = p1 + p2;
            p1 = p2;
            p2 = p3;
        }
        return p2;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
