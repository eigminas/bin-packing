/**
 * @Purpose: The Sheet class represents a sheet with a list of shelves.
 * DO NOT MODIFY THE EXISTING METHODS SIGNITURE, You may add additional methods if you wish
 * 
 * @author  RYK 
 * @since   30/10/2019
 * extended by Eigminas Slavinskas 
 */
import java.util.ArrayList;
import java.util.List;

public class Sheet {

	public static final int SHEET_HEIGHT = 250; // sheet height

	public static final int SHEET_WIDTH = 300; // sheet width

	public static final int SHAPE_LIMIT = 20; // maximum number of shapes that can be placed in each sheet (rule F)

	private List<Shelf> shelves = new ArrayList<Shelf>(); // list of shelves
	
	private boolean isFull = false;

	/**
	 * empty constructor
	 */
	public Sheet() {
	}

	/**
	 * This method is used to add a shelf to a sheet
	 * @param a shelf
	 */
	public void addShelf(Shelf shelf) {
		shelves.add(shelf);
	}

	/**
	 * @return height of all shelves in a sheet
	 */
	public int allShelvesHeight() {

		int total = 0;

		for (Shelf shelf : this.shelves) {

			// has a shelf with at least 1 shape
			if (!shelf.getShapes().isEmpty()) {

				// add all shelf height to total
				total += shelf.getHeight();
			}
		}
		return total;
	}

	/**
	 * @return list of all shelves in a sheet
	 */
	public List<Shelf> getShelves() {
		return this.shelves;
	}

	/**
	 * @return height
	 */
	public int getHeight() {
		return SHEET_HEIGHT;
	}

	/**
	 * @return width
	 */
	public int getWidth() {
		return SHEET_WIDTH ;
	}

	
	/**
	 * @return String that visually represents a sheet
	 */
	public String toString() {
		
		String sheet = "\n";	// will be returned
		
		sheet = sheet + ("Sheet ( W = " + SHEET_WIDTH + ", H = " + SHEET_HEIGHT + " ){\n\n"); // information about sheet
		
		for(int i = shelves.size()-1; i >= 0; i--){
			
			sheet = sheet + ("   Shelf " + (i+1) + " = {");
			Shelf shelf = shelves.get(i);
			
			for(Shape shape: shelf.getShapes()){
				sheet = sheet + (" ( w = " + shape.getWidth() + ", h = " + shape.getHeight() + " )");
			}
			
			sheet = sheet + " }\n";
		}
		sheet = sheet + ("\n") + ("}" + "  used h = " + allShelvesHeight() + "\n");
		return sheet; // return the resulting String
	}

}
