package it.polimi.ingsw.game;

/**
 * This class represents a position in the map
 */
public class Vector2 {
    private int x, y;

    /**
     * Create a new vector2 pointing to a map position
     * @param x row index in the map
     * @param y col index in the map
     */
    public Vector2(int x, int y) {
        set(x, y);
    }

    /**
     * Return x coordinate
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Return y coordinate
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Set vector value
     * @param x new x value
     * @param y new y value
     */
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } //if compared with myself
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Vector2 test_pos = (Vector2) obj;
        return x == test_pos.x && y == test_pos.y;
    }

    /**
     * @return a copy of the current vector
     */
    public Vector2 copy(){
        return new Vector2(x, y);
    }

    /**
     * Calculate the approximate distance in cells, this is not a super accurate calculation but is good enough to check adjacent cells
     * @param other position to use in distance calculation
     * @return distance
     */
    public int distance(Vector2 other)
    {
        int dx = Math.abs(x- other.x);
        int dy = Math.abs(y - other.y);
        return (int)Math.sqrt(dx * dx + dy *dy);
    }
}
