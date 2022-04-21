import bridges.base.Color;
import bridges.base.ColorGrid;

public class HorizontalLine extends Mark {
    private int s1;
    private int e1;
    private int z;

    public HorizontalLine(int start, int end, int y, Color c) {
        color = c;
        s1 = start;
        e1 = end;
        z = y;
    }

    @Override
    public void draw(ColorGrid cg) {
        if (s1 != e1) {
            for (int i = s1; i < e1+1; i++) {
                cg.set(z, i, color);
            }
        }
        else {
            cg.set(z,s1,color);
        }

    }
}
