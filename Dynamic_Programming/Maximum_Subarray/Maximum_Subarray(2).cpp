// LeeCode, Maximum Subarray
// Time complexity O(n),Space complexity O(n)
class Solution{
public: maxSubArray(int A[], int n){
		return mcss(A, n);
	}

private:
	static int mcss(int A[], int n){
		int i, result, cur_min;
		int *sum = new int[n + 1];

		sum[0] = 0;
		result = INT_MIN;
		cur_min = sum[0];
		for (i = 1; i <= n; i++){
			sum[i] = sum[i - 1] + A[i - 1];
		}
		for (i = 1; i <= n; i++){
			result = max(result, sum[i] - cur_min);
			cur_min = min(cur_min, sum[i]);
		}
		delete[] sum;
		return result;
	}
};
