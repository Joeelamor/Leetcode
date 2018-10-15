// Question 855 Exam Room

class ExamRoom {
    int N;
    TreeSet<Integer> students;
    public ExamRoom(int N) {
        this.N = N;
        this.students = new TreeSet<>();
    }
    
    public int seat() {
        int student = 0;
        if (students.size() > 0) {
            int dist = students.first();
            Integer prev = null;
            for (int s : students) {
                if (prev != null) {
                    int cur = (s - prev) / 2;
                    if (cur > dist) {
                        dist = cur;
                        student = prev + cur;
                    }
                } 
                prev = s;
            }
            if (N - 1 - students.last() > dist) 
                student = N - 1;
        }
        students.add(student);
        return student;
    }
    
    public void leave(int p) {
        students.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */