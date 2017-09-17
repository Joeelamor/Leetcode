import java.util.ArrayList;
import java.util.List;

public class LC22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateOneByOne("", list, n, n);
        return list;
    }

    public void generateOneByOne(String s, List<String> list, int left, int right) {
        if (left > right)
            return;
        if (left > 0) {
            generateOneByOne(s + "(", list, left - 1, right);
        }
        if (right > 0) {
            generateOneByOne(s + ")", list, left, right - 1);
        }
        if (left == 0 && right == 0) {
            list.add(s);
            return;
        }
    }
}
