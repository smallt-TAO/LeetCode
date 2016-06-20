public class Solution {
	public int minCut(String s){
		int n = s.length();
		boolean isPal[][] = new boolean[n][n];
		int dpminc[] = new int[n];
		for(int j = 0; j < n; j++){
			dpminc[j] = j;
			for(int i = 0;i <= j; i++){
				if(s.charAt(i) == s.charAt(j) && (j - i <= 1 || isPal[i + 1][j - 1])){
					isPal[i][j] = true;
					if(i > 0)
						dpminc[j] = Math.min(dpminc[j], dpminc[i - 1] + 1);
					else
						dpminc[j] = 0;
				}
			}
		}
		return dpminc[n - 1];
	}
}
