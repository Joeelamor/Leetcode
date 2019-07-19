// Question 1119 Remove Vowels from a String

// method 1:
class Solution {
    public String removeVowels(String S) {
        String vowels = "aeiou";
        String res = "";
        for (int i = 0; i < S.length(); i++) {
            if (!vowels.contains(S.charAt(i) + "")) {
               res += S.charAt(i);
            }
        }
        return res;
    }
}

// method 2:
class Solution {
	public String removeVowels(String S) {
	    return S.replaceAll("[aeiou]", "");
	}
}