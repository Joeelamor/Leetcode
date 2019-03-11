// Question 1002 Find Common Characters

class Solution {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int[] dic = new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            dic[A[0].charAt(i) - 'a']++;
        }
        
        for (int i = 1; i < A.length; i++) {
            int[] cur = new int[26];
            String str = A[i];
            for (int j = 0; j < str.length(); j++) {
                cur[str.charAt(j) - 'a']++;
            } 
            
            for (int j = 0; j < 26; j++) {
                if (cur[j] < dic[j])
                    dic[j] = cur[j];
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < dic[i]; j++) {
                res.add((char)('a' + i)+ "");
            }
        }
        return res;
    }
}