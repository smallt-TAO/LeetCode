public class Solution {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList();
		
		Arrays.sort(num);
		int start, end, temp;
		for(int i = 0; i < num.length; i++) {
			if(i != 0 && num[i] == num[i - 1]) continue; //num 1£ºonly reserve first of all same values
			int current = num[i];
			start = i + 1;
			end = num.length - 1;
			
			while(start < end) {
				if(start != i + 1 && num[start] == num[start - 1]) {
					start++;
					continue;
				}
				temp = num[start] + num[end];
				
				if(temp == -current) {
					List<Integer> list = new ArrayList<Integer>(3);
					list.add(current);
					list.add(num[start]);
					list.add(num[end]);
					result.add(list);
					start++;
					end--;
				}
				else if(temp > -current) end--;
				else start++;
			}
		}
		return result;
	}
}
