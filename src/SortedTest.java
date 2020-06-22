import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Purpose: The SortedTest class is used to compare the implemented algorithms
 *           in term of the number of sheets used WHEN the list of
 *           shapes is SORTED
 *
 *           You can add additional methods if you need to in this class
 * 
 * @author RYK
 * @since 30/10/2019
 * extended by Eigminas Slavinskas
 */

public class SortedTest {
	public static void main(String[] args) {
		System.out.println("*********************************************");
		System.out.println("**************** Sorted Test ****************");
		System.out.println("*********************************************");
		System.out.println();

		/*
		 * Generate a random shape list and then check the number of sheets used
		 * when
		 ** this shape list is passed un-sorted
		 ** the list is sorted based on different criteria as set in the speciication document.
		 * 
		 * run several tests for different sizes of the "list of shapes" 
		 */

		/*
		 * HINT: you might want to implements the comparTo method in the Shape
		 * class or implement the Comparator Interface to do the sorting
		 */
		
		Generator gen = new Generator(); // Generator object needed for randomly generating shapes
		Algorithms algo = new Algorithms(); // Algorithms object needed to invoke NextFit and FirstFit methods
		
		/* Generate a list of shapes */
		
		
		System.out.printf("%50s\n\n", "****************************Sorted by ratio in decreasing order****************************");
		System.out.printf("%39s %23s %32s \n", "Unsorted", "Sorted", "Sorted - Unsorted");
		System.out.printf("%20s | %10s | %10s | %10s | %10s | %10s | %10s \n", "number of shapes", "Next Fit", "First Fit", "Next Fit", "First Fit", "Next Fit", "First Fit");
    	System.out.printf("%20s | %10s | %10s | %10s | %10s | %10s | %10s \n", "--------------------", "----------", "----------", "----------", "----------", "----------", "----------");
    	
    	double usedSheetsNFUnsorted = 0.0;
    	double usedSheetsFFUnsorted = 0.0;
    	double usedSheetsNFSorted = 0.0;
    	double usedSheetsFFSorted = 0.0;
    	/* User should customize the following 4 variables to run tests */
    	int noOfShapes = 1000; // number of shapes to be created
    	int increment = 1000; // increment
    	int noOfRep = 5;
    	int noOfTests = 5;
    	
    	for(int k = 0; k < noOfTests; k++){
    		for(int i = 0; i < noOfRep; i++){
        		List<Shape> shapes = gen.generateShapeList(noOfShapes);
        		usedSheetsNFUnsorted = usedSheetsNFUnsorted + testNF(shapes);
        		usedSheetsFFUnsorted = usedSheetsFFUnsorted + testFF(shapes);
        		
        		Collections.sort(shapes, Shape.sortByHeight().reversed());
        		
        		usedSheetsNFSorted = usedSheetsNFSorted + testNF(shapes);
        		usedSheetsFFSorted = usedSheetsFFSorted + testFF(shapes);
        	}
    		usedSheetsNFUnsorted = usedSheetsNFUnsorted/noOfRep;
    		usedSheetsFFUnsorted = usedSheetsFFUnsorted/noOfRep;
    		usedSheetsNFSorted = usedSheetsNFSorted/noOfRep;
    		usedSheetsFFSorted = usedSheetsFFSorted/noOfRep;
    		
    		System.out.printf("%20s | %10.3f | %10.3f | %10.3f | %10.3f | %10.3f | %10.3f \n", noOfShapes, usedSheetsNFUnsorted, usedSheetsFFUnsorted, usedSheetsNFSorted, usedSheetsFFSorted, usedSheetsNFUnsorted-usedSheetsNFSorted, usedSheetsFFUnsorted-usedSheetsFFSorted);
    		
    		noOfShapes = noOfShapes + increment;
    	}
    	
		
	}
	
	private static double testNF(List<Shape> shapes){
		//System.out.printf("%46s %10s \n", "|   number of used sheets", "|   time taken in ms");
    	
		
    	double usedSheets = 0;
		Algorithms algo = new Algorithms();
		usedSheets = algo.nextFit(shapes).size();

		return usedSheets;
		
		//System.out.printf("%20s | %10.3f | %10.3f \n", shapes.size(), usedSheetsNF, usedSheetsFF);
		
		}
	private static double testFF(List<Shape> shapes){
		//System.out.printf("%46s %10s \n", "|   number of used sheets", "|   time taken in ms");
    	
		
    	double usedSheets = 0;
		Algorithms algo = new Algorithms();
		usedSheets = algo.firstFit(shapes).size();

		return usedSheets;
		
		//System.out.printf("%20s | %10.3f | %10.3f \n", shapes.size(), usedSheetsNF, usedSheetsFF);
		
		}
}
