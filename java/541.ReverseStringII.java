// Problem 541 Reverse String II

class Solution {
    public String reverseStr(String s, int k) {
        int len = s.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        if(k >= len){
            System.out.println(reverse(s));
            return reverse(s);
        }            
        
        while(i < len) {
            if(len - i >= 2*k) {
                sb.append(reverse(s.substring(i, i + k))).append(s.substring(i + k, i + 2*k));
                i += 2*k;
            }
            else if(len - i >= k && len - i < 2 * k) {
                sb.append(reverse(s.substring(i, i + k))).append(s.substring(i + k, len));
                i += 2*k;
            }
            else {
                sb.append(reverse(s.substring(i, len)));
                i += 2*k;
            }
        }
        return sb.toString();
        
    }
    
    public String reverse(String str) {
        char []arr = str.toCharArray();
        int i = 0, j = arr.length -1;
        while(i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        return new String(arr);
    }
}