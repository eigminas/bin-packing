import java.util.List;

/**
 * @Purpose: The PerformanceTest class is used to compare the implemented
 *           algorithms in term of time and the number of sheets used
 *
 *           You can add additional methods if you need to in this class
 * 
 * @author RYK
 * @since 30/10/2019
 * extended by Eigminas Slavinskas
 */

public class PerformanceTest {

	public static void main(String[] args) {

		System.out.println("***********************************************");
		System.out.println("*********** Performance analysis **************");
		System.out.println("**********************************************");

		System.out.println();
		/*
		 * You must complete the Generator class in order to generate a random
		 * test values. You must complete the Algorithms class in order to call
		 * the two algorithms.
		 * 
		 * You can use any additional method you created in this class
		 */

		

		/**
		 * Remember: You need to calculate the time and number of sheets used
		 * for each run of each algorithm.
		 * 
		 * You are expected to run several tests (e.g. noOfTests=5) of your
		 * programs for, 10000, 20000, 30000, 40000, 50000 shapes
		 * (noOfShapes=10000, increment=10000) so that one can see how the
		 * algorithms perform for large datasets.
		 * 
		 * You are expected to run the same test a number of times to ensure
		 * accurate result (noOfRep=4). In this case, you need to calculate the
		 * average time and sheets needed for each run
		 **/

		// total number of tests - you need to CHANGE this value
		int noOfTests = 5;

		// number of repetitions for each test - you need to CHANGE this value
		int noOfRep = 5;

		// number of shapes needed for the first run - you need to CHANGE this
		// value
		int noOfShapes = 10000;

		// the increment in the number of shapes - you need to CHANGE this value
		int increment = 10000;
		
		test(noOfTests, noOfRep, noOfShapes, increment);

	}
	
	private static void test(int noOfTests, int noOfRep, int noOfShapes, int increment){
		System.out.printf("%46s %10s \n", "|   number of used sheets", "|   time taken in ms");
    	System.out.printf("%20s | %10s | %10s | %10s | %10s \n", "number of shapes", "Next Fit", "First Fit", "Next Fit", "First Fit");
    	System.out.printf("%20s | %10s | %10s | %10s | %10s \n", "--------------------", "----------", "----------", "----------", "----------");
		
		double timeNF = 0.0;
		double timeFF = 0.0;
		double usedSheetsNF = 0.0;
		double usedSheetsFF = 0.0;
		Generator gen = new Generator();
		Algorithms algo = new Algorithms();
		/*  The following iteration is used to warm up JVM. Warming up before actual tests helps to get more precise results  */
		for(int f = 0; f < 10; f++){
			List<Shape> shapes = gen.generateShapeList(noOfShapes);
			List<Sheet> sheetsNF = algo.nextFit(shapes);
			List<Sheet> sheetsFF = algo.firstFit(shapes);
		}
		
		for(int i = 0; i < noOfTests; i++){
			timeNF = 0;
			timeFF = 0;
			usedSheetsNF = 0.0;
			usedSheetsFF = 0.0;
			for(int k = 0; k < noOfRep; k++){
				List<Shape> shapes = gen.generateShapeList(noOfShapes);
				
				long startTimeNF = System.nanoTime();
				List<Sheet> sheetsNF = algo.nextFit(shapes);
				long finishTimeNF = System.nanoTime();
				timeNF = timeNF + (finishTimeNF - startTimeNF)/1000000;
				usedSheetsNF = usedSheetsNF + sheetsNF.size();
				
				long startTimeFF = System.nanoTime();
				List<Sheet> sheetsFF = algo.firstFit(shapes);
				long finishTimeFF = System.nanoTime();
				timeFF = timeFF + (finishTimeFF - startTimeFF)/1000000;
				usedSheetsFF = usedSheetsFF + sheetsFF.size();
			}
			timeNF = timeNF/noOfRep;
			usedSheetsNF = usedSheetsNF/noOfRep;
			timeFF = timeFF/noOfRep;
			usedSheetsFF = usedSheetsFF/noOfRep;
			System.out.printf("%20s | %10.3f | %10.3f | %10.3f | %10.3f \n", noOfShapes, usedSheetsNF, usedSheetsFF, timeNF, timeFF);
			noOfShapes = noOfShapes + increment;
			
			
		}
		
		
	}
	
	
	
	
	
}
