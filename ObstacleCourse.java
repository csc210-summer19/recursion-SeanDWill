/**
 * ObstacleCourse: A type that represents an obstacle course from which to
 * escape. This does not find the shorted path. Because of this, we must always
 * assume there is only one exit.
 */
public class ObstacleCourse {

  // Instance variables
  protected char[][] course;
  private int sRow;
  private int sCol;
  private int foundRow;
  private int foundCol;
  
  // Constants (or you could use 'O' and '.' directly)
  private static final char PART_OF_PATH = 'O';
  private static final char TRIED = '.';

  /**
   * Initializes the 2d char array course.
   */
  public ObstacleCourse(int sRow, int sCol, char[][] course) {
    this.sRow = sRow;
    this.sCol = sCol;
    this.course = course; 
    
    // The default values in case there is no exit.
    foundRow = -1;
    foundCol = -1;
  }

  // Returns the start column in the array
  public int getStartColumn() {
    return sCol;
  }

   // Returns the starting row in the array
  public int getStartRow() {
    return sRow;
  }

  // Return the column of the solution
  public int getExitColumn() {
    return foundCol;
  }

  // Return the row of the solution
  public int getExitRow() {
    return foundRow;
  }

  // Returns a string representation of the array
  public String toString() {
    String result = "";
    for (int i = 0; i < course.length; i++) {
      for (int j = 0; j < course[0].length; j++) {
        result += course[i][j];
      }
      result += "\n";
    }
    return result;
  }

  // This method is called by the user to begin the search for the one exit.
  public void findTheExit() {
    findExit(sRow, sCol);
  }

  /**
   * Finds the exit from the 2-D array. This method also must record the row and
   * col where the exit was found
   */
  private boolean findExit(int row, int col) {
    //
    // Do not forget to set the instance variable foundRow and 
    // foundCol in this method when the exit is found.

	boolean escaped = false;
	if ( row>=0 && row<this.course.length && col >=0 && col<this.course[0].length ) {
		// This means the row and col are valid and able to index the 2-d array
		this.course[row][col] = TRIED;
		if ( row == 0 || row == this.course.length-1 || col == 0 || col == this.course[0].length-1) {
			// Border has been hit
			if (course[row][col] == ' ') {
				// exit is found return and set instance variables
				foundCol = col;
				foundRow = row;
				return true;
			}
			else {
				// this selection was not correct return back to call
				return false;
			}
		}
		else {
			// Check to see if exit is one row below
			escaped = (row+1 == this.course.length-1 && (course[row+1][col] == ' '));
			if (escaped == true) {
				// exit is one row below, setting row
				row = row+1;
			}

			// Check to see if exit is one col right
			if (escaped == false) {
				escaped = (col+1 == this.course[0].length-1 && (course[row][col+1]== ' '));
				if (escaped == true) {
					// exit is one col right, setting col
					col = col+1;
				}
			}
			// Check to see if exit is one row above
			if (escaped == false) {
				escaped = (row-1 == 0 && (course[row-1][col] == ' '));
				if (escaped == true) {
					// exit is one row above, setting row
					row = row-1;
				}
				}
			// Check to see if exit is one col left
			if (escaped == false) {
				escaped = (col-1 == 0 && (course[row][col-1] == ' '));
				if (escaped == true) {
					// exit is one col left, setting col
					col = col-1;
				}
			}
		}
		if (escaped) {
			course[row][col] = PART_OF_PATH;
			foundRow = row;
			foundCol = col;
			return true;
	}
		else {
			findExit(row+1, col+1);
		}
  }
	if (row >= this.course.length) {
		findExit(0, col);
	}
	if (col >= this.course[0].length) {
	findExit(row, 0);
	}
	if (col <0) {
		findExit(row, 0);
	}
	if (row<0) {
		findExit(0, col);
	}
	return false;
  }
}