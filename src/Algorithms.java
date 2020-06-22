
/**
 * @Purpose: The Algorithms class contains the two algorithms you have to implement  
 * Do NOT modify the names and signatures of the two algorithm methods
 * 
 * @author  RYK
 * @since   30/10/2019
 * extended by Eigminas Slavinskas 
 *
 **/

import java.util.ArrayList;
import java.util.List;

public class Algorithms {

	/**
	 * This method is used to implement the next fit algorithm
	 * 
	 * @param shapes:a
	 *            list of shapes representing customer requests(shapes to be
	 *            cut/placed)
	 * @return a list of the sheets used to fulfil all customer requests (i.e.
	 *         place all the shapes). e.g. if you pass a "shapes" list that has
	 *         two shapes {(w=200,h=200),(w=50,h=100)}, then the returned list
	 *         of sheets should show us all the information needed (e.g. that
	 *         one sheet is used, this sheet has one shelf and this shelf has
	 *         two shapes in it). In the test program, you can use the returned
	 *         list to retrieve the total number of sheets used.
	 **/

	public List<Sheet> nextFit(List<Shape> shapes) {
		
		List<Sheet> usedSheets = new ArrayList<Sheet>(); // usedSheets will be returned
		// sheetInd - index of current sheet
		// shelfInd - index of current shelf
		// items - number of shapes placed on the current sheet ( we want to make sure items <= Sheet.Shape_LIMIT>
		int sheetInd = 0, shelfInd = 0, items = 1; // items = 1 because we place first item before iteration.
		/* GET FIRST SHEET READY */
		usedSheets.add(new Sheet()); // take new sheet
		Sheet currentSheet = usedSheets.get(sheetInd); // get reference to taken sheet object
		/* GET FIRST SHELF READY */
		currentSheet.addShelf(new Shelf()); // add new shelf to empty sheet
		Shelf currentShelf = usedSheets.get(sheetInd).getShelves().get(shelfInd); // get reference to recently added shelf object
		currentShelf.place(shapes.get(0)); // place first shape onto first shelf of the first sheet
		
		for(int i = 1; i < shapes.size(); i++){
			Shape shape = shapes.get(i); // take first shape from the list
			/* Check if one more item can be placed onto this sheet */
			if(items < Sheet.SHAPE_LIMIT){
				/*   Place at the right of previous item if possible  */
				if(shape.getHeight() <= currentShelf.getHeight() && shape.getWidth() <= Sheet.SHEET_WIDTH - currentShelf.getWidth()){
					currentShelf.place(shape);
					items++;
				}
				/*Try rotation*/
				else if(shape.getWidth() <= currentShelf.getHeight() && shape.getHeight() <= Sheet.SHEET_WIDTH - currentShelf.getWidth()){
					shape = new Shape(shape.getHeight(), shape.getWidth()); // rotate
					currentShelf.place(shape); // place shape
					items++; // increment items counter
				}
				
				/*   Create new Shelf if possible  */
				else if(shape.getHeight() + currentSheet.allShelvesHeight() <= Sheet.SHEET_HEIGHT){
					shelfInd++; // go to the next shelf
					currentSheet.addShelf(new Shelf()); // add new shelf
					currentShelf = usedSheets.get(sheetInd).getShelves().get(shelfInd); // get reference to new shelf
					currentShelf.place(shape); // place shape onto new shelf
					items++; // increment items counter
				}
				/*Try rotation*/
				else if(shape.getWidth() + currentSheet.allShelvesHeight() <= Sheet.SHEET_HEIGHT){
					shape = new Shape(shape.getHeight(), shape.getWidth());
					shelfInd++;
					currentSheet.addShelf(new Shelf()); // add new shelf
					currentShelf = usedSheets.get(sheetInd).getShelves().get(shelfInd); // get reference to new shelf
					currentShelf.place(shape); // place shape onto new shelf
					items++;
				}
				/* Create new Sheet*/
				else{
					sheetInd++; // go to the next sheet
					shelfInd = 0;
					usedSheets.add(new Sheet()); // take new sheet
					currentSheet = usedSheets.get(sheetInd); // get reference to current sheet object
					
					currentSheet.addShelf(new Shelf()); // add new shelf to empty sheet
					currentShelf = usedSheets.get(sheetInd).getShelves().get(shelfInd); // get reference to current shelf object
					currentShelf.place(shape);
					items = 1;
				}
			}
			else{
				sheetInd++;
				shelfInd = 0;
				usedSheets.add(new Sheet()); // take new sheet
				currentSheet = usedSheets.get(sheetInd); // get reference to current sheet object
				
				currentSheet.addShelf(new Shelf()); // add new shelf to empty sheet
				currentShelf = usedSheets.get(sheetInd).getShelves().get(shelfInd); // get reference to current shelf object
				currentShelf.place(shape);
				items = 1;
			}
		}
		
		
		
		return usedSheets;
	}

	/**
	 * This method is used to implement the first fit algorithm
	 * 
	 * @param shapes:a
	 *            list of shapes representing customer requests (shapes to be
	 *            cut/placed)
	 * @return a list of the sheets used to fulfil all customer requests (i.e.
	 *         place all the shapes). e.g. if you pass a "shapes" list that has
	 *         two shapes {(w=200,h=200),(w=50,h=100)}, then the returned list
	 *         of sheets should show us all the information needed (e.g. that
	 *         one sheet is used, this sheet has one shelf and this shelf has
	 *         two shapes in it). In the test program, you can use the returned
	 *         list to retrieve the total number of sheets used
	 **/
	public List<Sheet> firstFit(List<Shape> shapes) {
		/*
		 * Start with an empty list of sheets (remember each sheet has a width
		 * of 300 and a height of 250 as specified in the Sheet class)
		 */
		
		List<Sheet> usedSheets = new ArrayList<Sheet>(); // usedSheets will be returned
		
		// sheetInd - index of current sheet
		// shelfInd - index of current shelf
		// items - number of shapes placed on the current sheet ( we want to make sure items < Sheet.Shape_LIMIT>
		int sheetInd = 0, shelfInd = 0;
		int[] items = new int[shapes.size()]; // we want to keep track how many items are in our sheets
		
		/* GET FIRST SHEET READY */
		usedSheets.add(new Sheet()); // take new sheet
		Sheet currentSheet = usedSheets.get(sheetInd); // get reference to taken sheet object
		
		/* GET FIRST SHELF READY */
		currentSheet.addShelf(new Shelf()); // add new shelf to empty sheet
		Shelf currentShelf = usedSheets.get(sheetInd).getShelves().get(shelfInd); // get reference to recently added shelf object
		
		currentShelf.place(shapes.get(0)); // place first shape onto first shelf of the first sheet
		items[sheetInd]++;
		boolean flag = true; // flag will tell us if shape was placed
		
		
		/* Iterate through shapes */
		for(int i = 1; i < shapes.size(); i++){
			Shape shape = shapes.get(i); // take one item from the list
			sheetInd = 0;
			flag = true;
			/* Iterate through sheets */
			while(flag && sheetInd < usedSheets.size()){
				currentSheet = usedSheets.get(sheetInd); // get reference to the current sheet
				shelfInd = 0; // start from first shelf
				/* Check if one more item can be placed onto this sheet */
				if(items[sheetInd] < Sheet.SHAPE_LIMIT){
					
					/* Iterate through shelves of the sheet */
					while(flag && shelfInd < currentSheet.getShelves().size()){
						currentShelf = currentSheet.getShelves().get(shelfInd); // get reference to the current shelf
/**********************************************************************************************************************************************************/
						
						/*   Place at the right of previous item if possible  */
						if(shape.getHeight() <= currentShelf.getHeight() && shape.getWidth() <= Sheet.SHEET_WIDTH - currentShelf.getWidth()){
							currentShelf.place(shape); // place
							items[sheetInd]++; // increment items counter
							flag = false; // item placed, we need to exit inner loops
						}
						/*Try rotation*/
						else if(shape.getWidth() <= currentShelf.getHeight() && shape.getHeight() <= Sheet.SHEET_WIDTH - currentShelf.getWidth()){
							shape = new Shape(shape.getHeight(), shape.getWidth()); // rotate
							currentShelf.place(shape); // place
							items[sheetInd]++; // increment items counter
							flag = false; // item placed, we need to exit inner loops
						}
						
						
						else if(shelfInd == currentSheet.getShelves().size() - 1){
							/*   Create new Shelf   */
							if(shape.getHeight() + currentSheet.allShelvesHeight() <= Sheet.SHEET_HEIGHT){
								currentSheet.addShelf(new Shelf()); // add new shelf
								currentShelf = usedSheets.get(sheetInd).getShelves().get(shelfInd+1); // get reference to new shelf
								currentShelf.place(shape); // place shape onto new shelf
								items[sheetInd]++;
								flag = false; // item placed, we need to exit inner loops
							}
							/*Try rotation*/
							else if(shape.getWidth() + currentSheet.allShelvesHeight() <= Sheet.SHEET_HEIGHT){
								shape = new Shape(shape.getHeight(), shape.getWidth());
								currentSheet.addShelf(new Shelf()); // add new shelf
								currentShelf = usedSheets.get(sheetInd).getShelves().get(shelfInd+1); // get reference to new shelf
								currentShelf.place(shape); // place shape onto new shelf
								items[sheetInd]++;
								flag = false; // item placed, we need to exit inner loops
							}
						}
						
/**********************************************************************************************************************************************************/
						
						shelfInd++; // go to next shelf
					}
				
				if(flag){
					/*   Create new Shelf   */
					if(shape.getHeight() + currentSheet.allShelvesHeight() <= Sheet.SHEET_HEIGHT){
						currentSheet.addShelf(new Shelf()); // add new shelf
						currentShelf = usedSheets.get(sheetInd).getShelves().get(currentSheet.getShelves().size() - 1); // get reference to new shelf
						currentShelf.place(shape); // place shape onto new shelf
						items[sheetInd]++;
						flag = false; // item placed, we need to exit inner loops
					}
					/*Try rotation*/
					else if(shape.getWidth() + currentSheet.allShelvesHeight() <= Sheet.SHEET_HEIGHT){
						shape = new Shape(shape.getHeight(), shape.getWidth());
						currentSheet.addShelf(new Shelf()); // add new shelf
						currentShelf = usedSheets.get(sheetInd).getShelves().get(currentSheet.getShelves().size() - 1); // get reference to new shelf
						currentShelf.place(shape); // place shape onto new shelf
						items[sheetInd]++;
						flag = false; // item placed, we need to exit inner loops
					}
				}
				}
				sheetInd++; // go to next sheet
			}
			
			/* Create new Sheet*/
			if(flag){
				usedSheets.add(new Sheet()); // take new sheet
				currentSheet = usedSheets.get(usedSheets.size()-1); // get reference to current sheet object
				
				currentSheet.addShelf(new Shelf()); // add new shelf to empty sheet
				currentShelf = usedSheets.get(sheetInd).getShelves().get(0); // get reference to current shelf object
				currentShelf.place(shape);
				items[usedSheets.size()-1] = 1;
			}
		}
		
		
		return usedSheets;
	}

}
