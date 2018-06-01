// Problem 422 Valid Word Square

class Solution {
    public boolean validWordSquare(List<String> words) {
        if (words.size() == 0 || words == null) return true;
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                // Need to check boundary case first!
                if(j >= words.size() || i >= words.get(j).length() || words.get(j).charAt(i) != words.get(i).charAt(j))
                    return false;
            }
        }
        return true;
    }
}

        

