import java.util.Collection;
import java.util.HashMap;




public class MaxPointsonaLine {

	
	private class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	
	public int maxPoints(Point[] points) {
        int i = 0;
        int j = 0;
        double slope = 0.0f;
        Integer cnt = null;
        if(points.length == 0){
            return 0;
        }
        int max = 1;
        int samex = 1;
        int samepoint = 0;
        HashMap<Double, Integer> slopetable = null;
        for(i = 0; i < points.length; i++){
            slopetable = new HashMap<Double, Integer>();
            samex = 1;
            samepoint = 0;
            //same point can be added to any slope
            for(j = 0; j < points.length; j++){
                if(i!=j){
                	if(points[i].x == points[j].x){
                		samex++;
                		if(points[i].y == points[j].y){
                			samepoint++;
                		}
                	}else{
	                    slope = (double)(points[j].y-points[i].y)/(points[j].x-points[i].x);
	                    cnt = slopetable.get(slope);
	                    if(cnt == null){
	                        slopetable.put(slope, 2);
	                    }else{
	                        slopetable.put(slope, cnt+1);
	                    }
                	}
                }
            }
            Collection<Integer> values = slopetable.values();
            for(Integer value: values){
                if((value + samepoint) > max){
                    max = value + samepoint;
                }
            }
            if(samex > max){
            	max = samex;
            }
        }
        return max;
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxPointsonaLine mp = new MaxPointsonaLine();
		
	}

}
