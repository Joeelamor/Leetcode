// Question 929 Unique Email Addresses

class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String email : emails) {
            String cur = "";
            int i = 0;
            int index = email.length();
            while (i < email.length()) {
                if (email.charAt(i) == '.' && i < index)
                    i++;
                else if (email.charAt(i) == '+') {
                    while (i < email.length()) {
                        if (email.charAt(i) != '@')
                            i++;
                        else {
                            index = 0;
                            break;
                        }
                    }
                } else {
                    cur += email.charAt(i);
                    i++;
                }
            }
            set.add(cur);
        }
        return set.size();
    }
}