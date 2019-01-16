// Question 353 Design Snake Game

class SnakeGame {

    int[][] food;
    int foodIndex = 0;
    int score = 0;
    int width;
    int height;
    HashSet<Integer> set;
    Deque<Integer> body;
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        this.width = width;
        this.height = height;
        this.set = new HashSet<>();
        this.set.add(0);
        this.body = new ArrayDeque<>();
        this.body.offerFirst(0);
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        // if game is already over, do nothing.
        if (score == -1)
            return score;
        int rowHead = body.peekFirst() / width;
        int colHead = body.peekFirst() % width;
        switch(direction) {
            case "U": rowHead--;
                break;
            case "D": rowHead++;
                break;
            case "L": colHead--;
                break;
            default: colHead++;
        }
        int head = rowHead * width + colHead;
        // out of boundary or bit itself
        set.remove(body.peekLast());
        if (rowHead < 0 || rowHead >= height || colHead < 0 || colHead >= width || set.contains(head))
            return -1;
        set.add(head);
        body.offerFirst(head);
        if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
            set.add(body.peekLast()); // old tail does not change, so add it back to set
            foodIndex++;
            score++;
            return score;
        }
        body.pollLast();
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */