// Question 990 Satisfiability of Equality Equations

class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] graph = new int[26];
        for (int i = 0; i < graph.length; i++)
            graph[i] = i;
        for (String equation : equations) {
            if (equation.charAt(1) == '=')
                graph[find(graph, equation.charAt(0) - 'a')] = find(graph, equation.charAt(3) - 'a');
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!' && find(graph, equation.charAt(0) - 'a') == find(graph, equation.charAt(3) - 'a')) 
                return false;
        }
        return true;
    }
    
    public int find(int[] graph, int x) {
        while (x != graph[x]) {
            x = graph[x];
        }
        return x;
    }
}