// Problem 690 Employee Importance

/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee: employees) {
            map.put(employee.id, employee);
        }
        return helper(map, id);
    }
    public int helper(Map<Integer, Employee> map, int id) {
        Employee root = map.get(id);
        int total = root.importance;
        for (int subordinate : root.subordinates) {
            total += helper(map, subordinate);
        }
        return total;
    }
}