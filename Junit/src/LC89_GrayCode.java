import java.util.LinkedList;
import java.util.List;

public class LC89_GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) {
            int a = i ^ i>>1;
            result.add(i ^ i>>1);
        }
        return result;
    }
}