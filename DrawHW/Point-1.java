import bridges.base.Color;
import bridges.base.ColorGrid;

public class Point extends Mark {
    private int s;
    private int z;
    public Point(int x, int y, Color c) {
        color = c;
        s = x;
        z = y;

    }
    @Override
    public void draw(ColorGrid cg) {
        cg.set(z,s,color);
    }
}
