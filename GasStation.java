
public class GasStation {

	public int canCompleteCircuit_1(int[] gas, int[] cost) {
        int totalgas = 0;
        int trips = gas.length;
        int i = 0;
        int j = 0;
        int k = 0;
        for(i = 0; i < trips; i++){
            totalgas = 0;
            for(j = i; j < i + trips; j++){
                k = j % trips;
                totalgas = totalgas + gas[k] - cost[k];
                if(totalgas < 0){
                    break;
                }
            }
            if(totalgas >= 0){
                break;
            }
        }
        if(totalgas >= 0){
            return i;
        }else{
            return -1;
        }
    }
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int totalgas = 0;
		int sum = 0;
		int trips = gas.length;
		int i = 0;
		int start = 0;
		int diff = 0;
		for (i = 0; i < trips; i++) {
			diff = gas[i] - cost[i];
			totalgas = totalgas + diff;
			sum = sum + diff;
			if (sum < 0) {
				start = i + 1;
				sum = 0;
			}
		}
		if (totalgas >= 0) {
			return start;
		} else {
			return -1;
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GasStation gs = new GasStation();
		int[] gas = {1, 2};
		int[] cost = {2, 1};
		System.out.println(gs.canCompleteCircuit(gas, cost));
	}

}
