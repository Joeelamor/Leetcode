// Problem 399 Evaluate Division

// First create a graph, then use dfs to find the result.
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, ArrayList<String>> pairs = new HashMap<>();
        Map<String, ArrayList<Double>> valuePairs = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<String>());
                valuePairs.put(equation[0], new ArrayList<Double>());
            }
            if (!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<String>());
                valuePairs.put(equation[1], new ArrayList<Double>());
            }
            pairs.get(equation[0]).add(equation[1]);
            valuePairs.get(equation[0]).add(values[i]);
            pairs.get(equation[1]).add(equation[0]);
            valuePairs.get(equation[1]).add(1 / values[i]);
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            res[i] = dfs(query[0], query[1], pairs, valuePairs, new HashSet<String>(), 1.0);
            if (res[i] == 0.0)
                res[i] = -1.0;
        }
        return res;
    }
    
    private double dfs(String start, String end, Map<String, ArrayList<String>> pairs, Map<String, ArrayList<Double>> valuePairs, Set<String> set, double value) {
        if (set.contains(start))
            return 0.0;
        if (!pairs.containsKey(start))
            return 0.0;
        if (start.equals(end))
            return value;
        set.add(start);
        ArrayList<String> pair = pairs.get(start);
        ArrayList<Double> valuePair = valuePairs.get(start);
        double tmp = 0.0;
        for (int i = 0; i < pair.size(); i++) {
            tmp = dfs(pair.get(i), end, pairs, valuePairs, set, value * valuePair.get(i));
            if (tmp != 0.0)
                break;
        }
        set.remove(start);
        return tmp;
    }
}