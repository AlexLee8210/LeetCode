class SnakeGame {

    int[] head, tail, beforeTail;
    int width, height;
    int[][] food;
    int score;
    int foodIndex;
    boolean[][] isBody;
    Deque<Character> directions;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        head = new int[]{0, 0};
        tail = new int[]{0, 0};
        score = 0;
        foodIndex = 0;

        isBody = new boolean[height][width];
        directions = new LinkedList<>();
    }
    
    public int move(String direction) {
        advance(direction.charAt(0));
        if (!inBounds()) return -1;

        if (foodIndex < food.length && food[foodIndex][0] == head[0] && food[foodIndex][1] == head[1]) {
            ++score;
            ++foodIndex;
        } else {
            advanceTail();
        }

        if (isBody[head[0]][head[1]]) return -1;
        isBody[head[0]][head[1]] = true;
        
        return score;
    }

    private void advance(char dir) {
        directions.addLast(dir);
        switch (dir) {
            case 'R':
                ++head[1];
                break;
            case 'L':
                --head[1];
                break;
            case 'D':
                ++head[0];
                break;
            case 'U':
                --head[0];
                break;
        };
    }

    private void advanceTail() {
        isBody[tail[0]][tail[1]] = false;
        char dir = directions.removeFirst();
        switch (dir) {
            case 'R':
                ++tail[1];
                break;
            case 'L':
                --tail[1];
                break;
            case 'D':
                ++tail[0];
                break;
            case 'U':
                --tail[0];
                break;
        };
    }

    private boolean inBounds() {
        return head[0] >= 0 && head[0] < height && head[1] >= 0 && head[1] < width;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */