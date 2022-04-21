import bridges.base.Color;
import bridges.base.ColorGrid;

public class Circle extends Mark {
    private int r;
    private int xc;
    private int yc;

    //This code derived from https://www.geeksforgeeks.org/mid-point-circle-drawing-algorithm/
    public Circle(int radius, int xcenter, int ycenter, Color c) {
        color = c;
        r = radius;
        xc = xcenter;
        yc = ycenter;

    }

    @Override
    public void draw(ColorGrid cg) {
        {

            int x = r, y = 0;

            // Printing the initial point
            // on the axes after translation
            cg.set((y + yc),(x + xc),color);

            // When radius is zero only a single
            // point will be printed
            if (r > 0) {

                cg.set((-y + yc),(x + xc),color);

                cg.set((x + yc),(y + xc),color);

                cg.set((x + yc),(-y + xc),color);
            }

            // Initialising the value of P
            int P = 1 - r;
            while (x > y) {

                y++;

                // Mid-point is inside or on the perimeter
                if (P <= 0)
                    P = P + 2 * y + 1;

                    // Mid-point is outside the perimeter
                else {
                    x--;
                    P = P + 2 * y - 2 * x + 1;
                }

                // All the perimeter points have already
                // been printed
                if (x < y)
                    break;

                // Printing the generated point and its
                // reflection in the other octants after
                // translation
                cg.set((y + yc),(x + xc),color);

                cg.set((y + yc),(-x + xc),color);

                cg.set((-y + yc),(x + xc),color);

                cg.set((-y + yc),(-x + xc),color);

                // If the generated point is on the
                // line x = y then the perimeter points
                // have already been printed
                if (x != y) {

                    cg.set((x + yc),(y + xc),color);

                    cg.set((x + yc),(-y + xc),color);

                    cg.set((-x + yc),(y + xc),color);

                    cg.set((-x + yc),(-y + xc),color);
                }
            }
        }

    }
}
