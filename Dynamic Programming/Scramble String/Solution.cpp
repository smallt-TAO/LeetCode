// LeetCode, Scramble String
// Time complexity O(n^3)
class Solution {
private:
    const int primes[26] = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
public:
    bool isScramble(string s1, string s2) {
        if(s1.size()!=s2.size()) return false;
        if(s1==s2) return true;
        int n=s1.size();
        bool scr[n][n][n+1];
        int hash1[n][n+1],hash2[n][n+1];
        memset(scr,0,sizeof(scr));
        for(int i=0;i<n;i++){
            hash1[i][0]=1;
            hash2[i][0]=1;
            for(int l=1;l<=n-i;l++) {
                hash1[i][l]=hash1[i][l-1]*primes[s1[i+l-1]-'a'];
                hash2[i][l]=hash2[i][l-1]*primes[s2[i+l-1]-'a'];
            }
        }
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                scr[i][j][1]=(s1[i]==s2[j]);
        for(int l=2;l<=n;l++)
            for(int i=0;i<=n-l;i++)
                for(int j=0;j<=n-l;j++)
                    if(hash1[i][l]==hash2[j][l]) 
                        for(int k=1;k<l;k++)
                            if((scr[i][j][k]&&scr[i+k][j+k][l-k])||(scr[i+k][j][l-k]&&scr[i][j+l-k][k])) 
                                scr[i][j][l]=true;
        return scr[0][0][n];
    }
};