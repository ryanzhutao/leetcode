
public class LongestAbsoluteFilePath {

	public int lengthLongestPath(String input) {
        //how many files and directories
		int maxlen = 0;
        String[] substrs = input.split("\\n");
        int i = 0;
        int depth = 0;
        String name = "";
        //array record the latest length of depth i
        int[] pathlen = new int[input.length()+1];
        for(i = 0; i < substrs.length; i++){
        	
        	name = substrs[i].replace("\t", "");
        	depth = substrs[i].length() - name.length();
        	if(name.contains(".")){
        		maxlen = Math.max(maxlen, pathlen[depth] + name.length());
        	}else{
        		//1 is for the length of "/"
        		pathlen[depth+1] = pathlen[depth] + name.length() + 1;
        	}
        }
        return maxlen;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestAbsoluteFilePath lp = new LongestAbsoluteFilePath();
		String str = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		System.out.println(lp.lengthLongestPath(str));
	}

}
