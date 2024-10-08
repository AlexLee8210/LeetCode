class Vector2D {
    int row, col;
    int[][] vec;

    public Vector2D(int[][] vec) {
        row = 0;
        col = 0;
        this.vec = vec;
    }
    
    public int next() {
        if (hasNext()) return vec[row][col++];
        return -1;
    }
    
    public boolean hasNext() {
        while (row < vec.length && col >= vec[row].length) {
            row++;
            col = 0;
        }
        return row < vec.length && col < vec[row].length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */