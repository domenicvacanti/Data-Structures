
import java.util.Scanner;
import java.io.*;
import bridges.connect.Bridges;
import bridges.base.ColorGrid;
import bridges.base.Color;


public class Scene {
	private int mM;
	private Color c;
	private Mark[] arrayOfMarks;
	private Mark[] newArray;
	private int markedPixel;



    /* Creates a Scene with a maximum capacity of Marks and
	   with a background color.
	   maxMarks: the maximum capacity of Marks
	   backgroundColor: the background color of this Scene
     */
	public Scene(int maxMarks, Color backgroundColor) {
		mM = maxMarks;
		c = backgroundColor;
		arrayOfMarks = new Mark[maxMarks];
		newArray = new Mark[maxMarks];
	}

	// returns true if the Scene has no room for additional Marks
	private boolean isFull() { return markedPixel >= mM;
	}

	/* Adds a Mark to this Scene. When drawn, the Mark
	   will appear on top of the background and previously added Marks
	   m: the Mark to add
	 */
	public void addMark(Mark m) {
		if (isFull()) throw new IllegalStateException("No room to add more Marks");
		for (int i = 0; i < markedPixel+1;i++){
			if (arrayOfMarks[i] != null){
				arrayOfMarks[markedPixel] = m;
				markedPixel++;
				break;
			}
			else{
				arrayOfMarks[i] = m;
				markedPixel++;
				break;
			}
		}
	}

	/*
	Helper method: deletes the Mark at an index.
	If no Marks have been previously deleted, the method
	deletes the ith Mark that was added (0 based).
	i: the index
	 */
	protected void deleteMark(int i) {
		for (int j = i; j < markedPixel-1;j++){
			arrayOfMarks[j] = arrayOfMarks[j+1];
		}
		markedPixel--;
	}

	/*
	Deletes all Marks from this Scene that
	have a given Color
	c: the Color
	 */
	public void deleteMarksByColor(Color c) {
		int counter = 0;
		for (int j = 0; j < markedPixel;j++){
			if (arrayOfMarks[j].isColor(c)){
				for (int i = j; i < markedPixel-1;i++){
					arrayOfMarks[i] = arrayOfMarks[i+1];
				}
				markedPixel--;
			}
		}
	}

	/* draws the Marks in this Scene over a background color
	   onto a ColorGrid. Marks will appear on top of the
	   background, and Marks will overlap other Marks if
	   they were added by a more recent call to addMark.
	   cg: the ColorGrid to draw on
	 */
	public void draw(ColorGrid cg) {
		for (int i = 0; i < cg.getHeight() ; i++) {
			for (int j = 0; j < cg.getWidth(); j++) {
				cg.set(i, j, c);
			}
		}
		for (int i = 0; i < markedPixel; i++) {
				arrayOfMarks[i].draw(cg);
		}
	}
}
