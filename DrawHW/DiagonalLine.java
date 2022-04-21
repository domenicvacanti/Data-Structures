import bridges.base.Color;
import bridges.base.ColorGrid;

public class DiagonalLine extends Mark {
    private int x2;
    private int x3;
    private int y2;
    private int y3;

    //This code derived from https://www.geeksforgeeks.org/bresenhams-line-generation-algorithm/
    public DiagonalLine(int x0, int y0, int x1, int y1, Color c) {
        x2=x0;
        x3=x1;
        y2=y0;
        y3=y1;
        color = c;
    }

    @Override
    public void draw(ColorGrid cg) {
        int m_new = 2 * (y3 - y2);
        int slope_error_new = m_new - (x3 - x2);

        for (int x = x2, y = y2; x <= x3; x++) {
            //*******************
            //This is the only part I change, along with the variables
            cg.set(y,x,color);
            //*******************

            // Add slope to increment angle formed
            slope_error_new += m_new;

            // Slope error reached limit, time to
            // increment y and update slope error.
            if (slope_error_new >= 0) {
                y++;
                slope_error_new -= 2 * (x3 - x2);
            }
        }
    }
}
