import bridges.base.Color;
import bridges.base.ColorGrid;

public class VerticalLine extends Mark {
    private int s1;
    private int e1;
    private int z;

    public VerticalLine(int start, int end, int x, Color c) {
        color = c;
        s1 = start;
        e1 = end;
        z = x;

    }

    @Override
    public void draw(ColorGrid cg) {
        if (s1 != e1) {
            for (int i = s1; i < e1 + 1; i++) {
                cg.set(i, z, color);
            }
        } else {
            cg.set(s1, z, color);

        }
    }
}
