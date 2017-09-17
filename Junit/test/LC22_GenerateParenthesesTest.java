import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LC22_GenerateParenthesesTest {
    @Test
    public void generateParenthesis() throws Exception {
        int i = 3;
        LC22_GenerateParentheses solution = new LC22_GenerateParentheses();
        List<String> res = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        assertEquals(res, solution.generateParenthesis(i));
    }

}