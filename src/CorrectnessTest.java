import java.util.ArrayList;
import java.util.List;

/**
 * @Purpose: The CorrectnessTest class is used to validate the correctness of
 *           the implemented algorithms. You can add additional methods if you
 *           need
 * 
 * @author RYK
 * @since 30/10/2019 extended by Eigminas Slavinskas
 */

public class CorrectnessTest {
	public static void main(String[] args) {
		System.out.println("*********************************************");
		System.out.println("*********** Correctness testing *************");
		System.out.println("*********************************************");
		System.out.println();

		/*
		 * Here you will need to validate that your algorithms (nextFit() and
		 * firstFit()) behave as expected on small data sets. 
		 * Think about normal cases and border cases. 
		 * You can use any additional method you created in this class
		 */
		
		testCase2();
		
		
	
	}
	
	private static void testFiveSheetSizeShapes(){
		
		/* Create a list of shapes */
		List<Shape> shapes = new ArrayList<Shape>();
		/* Add five equal shapes of size ( w = 300, h = 250 ) */
		shapes.add(new Shape(300, 250));
		shapes.add(new Shape(300, 250));
		shapes.add(new Shape(300, 250));
		shapes.add(new Shape(300, 250));
		shapes.add(new Shape(300, 250));
		
		System.out.println("Note that maximum capacity of one sheet is 300 width and 250 height.\n" +
		"In this test, we are giving 5 shapes of size ( w = 300, j = 250 ).\n"+
	    "Both algorithms should produce the same output because there is no\n"+
		"other way to pack these shapes than placing them in 5 seperate sheets.");
		
		System.out.println("\n---------------------------------------------");
		
		System.out.println("test input");
		
		System.out.println("---------------------------------------------");
		
		for(Shape shape: shapes){
			System.out.println("   ( w = " + shape.getWidth() + ", h = " + shape.getHeight() + " )");
		}
		
		//System.out.println("---------------------------------------------");
		
		/* call nextFit and firstFit algorithms */
		Algorithms algo = new Algorithms(); // Algorithms object
		
		List<Sheet> listNextFit = algo.nextFit(shapes);
		List<Sheet> listFirstFit = algo.firstFit(shapes);
		
		System.out.println("---------------------------------------------");
		System.out.println("NextFit output");
		for(Sheet sheet: listNextFit){
			System.out.println(sheet);
		}
		System.out.println("---------------------------------------------");
		System.out.println("FirstFit output");		
		for(Sheet sheet: listFirstFit){
			System.out.println(sheet);
		}
		System.out.println("---------------------------------------------");
		
		
	}
	
	private static void testCase1(){
		/* Create a list of shapes */
		List<Shape> shapes = new ArrayList<Shape>();
		/* Add 8 shapes. If n-th shape is w = 300, h = 125 then n+1-th shape is w = 300, h = 62 */
		shapes.add(new Shape(300, 125));
		shapes.add(new Shape(300, 62));
		shapes.add(new Shape(300, 125));
		shapes.add(new Shape(300, 62));
		shapes.add(new Shape(300, 125));
		shapes.add(new Shape(300, 62));
		shapes.add(new Shape(300, 125));
		shapes.add(new Shape(300, 62));
		
		System.out.println("In this test both algorithms are tested with 8 shapes where\n"
				+ "n-th shape is w = 300, h = 125 then n+1-th shape is w = 300, h = 62\n"
				+ "NextFit should require 4 containers and put 2 items in each while\n"
				+ "FirstFit should require 3 containers and put 3, 2, 3 items in each\n"
				+ "respectively.");
		
		System.out.println("\n---------------------------------------------");
		
		System.out.println("test input");
		
		System.out.println("---------------------------------------------");
		
		for(Shape shape: shapes){
			System.out.println("   ( w = " + shape.getWidth() + ", h = " + shape.getHeight() + " )");
		}
		
		//System.out.println("---------------------------------------------");
		
		/* call nextFit and firstFit algorithms */
		Algorithms algo = new Algorithms(); // Algorithms object
		
		List<Sheet> listNextFit = algo.nextFit(shapes);
		List<Sheet> listFirstFit = algo.firstFit(shapes);
		
		System.out.println("---------------------------------------------");
		System.out.println("NextFit output");
		for(Sheet sheet: listNextFit){
			System.out.println(sheet);
		}
		System.out.println("---------------------------------------------");
		System.out.println("FirstFit output");		
		for(Sheet sheet: listFirstFit){
			System.out.println(sheet);
		}
		System.out.println("---------------------------------------------");
	}
	
	private static void testCase2(){
		/* Create a list of shapes */
		List<Shape> shapes = new ArrayList<Shape>();
		/* Add shapes */
		shapes.add(new Shape(100, 50));
		shapes.add(new Shape(150, 51));
		shapes.add(new Shape(100, 52));
		shapes.add(new Shape(100, 50));
		shapes.add(new Shape(150, 45));
		shapes.add(new Shape(300, 250));
		shapes.add(new Shape(50, 40));

		
		
		System.out.println("In this test both algorithms are tested with 7 shapes.\n"
				+ "NextFit should use 3 sheets while FirstFit should\n"
				+ "use only 2 sheets.");
		
		System.out.println("\n---------------------------------------------");
		
		System.out.println("test input");
		
		System.out.println("---------------------------------------------");
		
		for(Shape shape: shapes){
			System.out.println("   ( w = " + shape.getWidth() + ", h = " + shape.getHeight() + " )");
		}
		
		//System.out.println("---------------------------------------------");
		
		/* call nextFit and firstFit algorithms */
		Algorithms algo = new Algorithms(); // Algorithms object
		
		List<Sheet> listNextFit = algo.nextFit(shapes);
		List<Sheet> listFirstFit = algo.firstFit(shapes);
		
		System.out.println("---------------------------------------------");
		System.out.println("NextFit output");
		for(Sheet sheet: listNextFit){
			System.out.println(sheet);
		}
		System.out.println("---------------------------------------------");
		System.out.println("FirstFit output");		
		for(Sheet sheet: listFirstFit){
			System.out.println(sheet);
		}
		System.out.println("---------------------------------------------");
	}
	
	private static void testCase3(){
		/* Create a list of shapes */
		List<Shape> shapes = new ArrayList<Shape>();
		/* Add shapes */
		shapes.add(new Shape(50, 10));
		shapes.add(new Shape(50, 20));
		shapes.add(new Shape(50, 10));
		shapes.add(new Shape(50, 20));
		shapes.add(new Shape(50, 10));
		shapes.add(new Shape(50, 20));
		shapes.add(new Shape(50, 10));
		shapes.add(new Shape(50, 20));

		
		
		System.out.println("In this test, algorithms are tested with 8 shapes where\n"
				+ "if n-th shape is (w=50, h=10) n+1-th shape is (w=50, h=20).\n"
				+ "NextFit should require 1 sheet and use 3 shelves while FirstFit\n"
				+ "should use one sheet and only 2 shelves in that sheet.\n");
		
		System.out.println("\n---------------------------------------------");
		
		System.out.println("test input");
		
		System.out.println("---------------------------------------------");
		
		for(Shape shape: shapes){
			System.out.println("   ( w = " + shape.getWidth() + ", h = " + shape.getHeight() + " )");
		}
		
		//System.out.println("---------------------------------------------");
		
		/* call nextFit and firstFit algorithms */
		Algorithms algo = new Algorithms(); // Algorithms object
		
		List<Sheet> listNextFit = algo.nextFit(shapes);
		List<Sheet> listFirstFit = algo.firstFit(shapes);
		
		System.out.println("---------------------------------------------");
		System.out.println("NextFit output");
		for(Sheet sheet: listNextFit){
			System.out.println(sheet);
		}
		System.out.println("---------------------------------------------");
		System.out.println("FirstFit output");		
		for(Sheet sheet: listFirstFit){
			System.out.println(sheet);
		}
		System.out.println("---------------------------------------------");
	}
	
	private static void testRotationCase1(){
		/* Create a list of shapes */
		List<Shape> shapes = new ArrayList<Shape>();
		/* Add shapes */
		shapes.add(new Shape(50, 60));
		shapes.add(new Shape(50, 150));
		
		System.out.println("In this test, we will check if algorithms rotate shape when it's smart to do so.\n"
				+ "We will pass 2 shapes and the second shape should be rotated by both algorithms.");
		
		System.out.println("\n---------------------------------------------");
		
		System.out.println("test input");
		
		System.out.println("---------------------------------------------");
		
		for(Shape shape: shapes){
			System.out.println("   ( w = " + shape.getWidth() + ", h = " + shape.getHeight() + " )");
		}
		
		//System.out.println("---------------------------------------------");
		
		/* call nextFit and firstFit algorithms */
		Algorithms algo = new Algorithms(); // Algorithms object
		
		List<Sheet> listNextFit = algo.nextFit(shapes);
		List<Sheet> listFirstFit = algo.firstFit(shapes);
		
		System.out.println("---------------------------------------------");
		System.out.println("NextFit output");
		for(Sheet sheet: listNextFit){
			System.out.println(sheet);
		}
		System.out.println("---------------------------------------------");
		System.out.println("FirstFit output");		
		for(Sheet sheet: listFirstFit){
			System.out.println(sheet);
		}
		System.out.println("---------------------------------------------");
	}
	
	private static void testShapeLimit(){
		/* Create a list of shapes */
		List<Shape> shapes = new ArrayList<Shape>();
		/* Add shapes */
		for(int i = 0; i < 40; i++){
			shapes.add(new Shape(1, 1));
		}
		
		System.out.println("In this test, we will check if algorithms prevent from adding more than 20 shapes in one sheet.\n"
				+ "Test succeeds if both algorithms use 2 sheets to place 40 shapes in total.");
		
		System.out.println("\n---------------------------------------------");
		
		System.out.println("test input");
		
		System.out.println("---------------------------------------------");
		
		for(Shape shape: shapes){
			System.out.println("   ( w = " + shape.getWidth() + ", h = " + shape.getHeight() + " )");
		}
		
		//System.out.println("---------------------------------------------");
		
		/* call nextFit and firstFit algorithms */
		Algorithms algo = new Algorithms(); // Algorithms object
		
		List<Sheet> listNextFit = algo.nextFit(shapes);
		List<Sheet> listFirstFit = algo.firstFit(shapes);
		
		System.out.println("---------------------------------------------");
		System.out.println("NextFit output");
		for(Sheet sheet: listNextFit){
			System.out.println(sheet);
		}
		System.out.println("---------------------------------------------");
		System.out.println("FirstFit output");		
		for(Sheet sheet: listFirstFit){
			System.out.println(sheet);
		}
		System.out.println("---------------------------------------------");
	}
	private static void testCase4(){
		/* Create a list of shapes */
		List<Shape> shapes = new ArrayList<Shape>();
		/* Add shapes */
		Shape s1 = new Shape(221,118);
        Shape s2 = new Shape(284,30);
        Shape s3 = new Shape(233,55);
        Shape s4 = new Shape(295,157);
        Shape s5 = new Shape(62,135);
        
        shapes.add(s1);
        shapes.add(s2);
        shapes.add(s3);
        shapes.add(s4);
        shapes.add(s5);
		
		System.out.println("In this test, we will test algorithms with 5 shapes.\n"
				+ "Test succeeds if both algorithms produce the same output, last shape\n"
				+ "should be rotated.");
		
		System.out.println("\n---------------------------------------------");
		
		System.out.println("test input");
		
		System.out.println("---------------------------------------------");
		
		for(Shape shape: shapes){
			System.out.println("   ( w = " + shape.getWidth() + ", h = " + shape.getHeight() + " )");
		}
		
		//System.out.println("---------------------------------------------");
		
		/* call nextFit and firstFit algorithms */
		Algorithms algo = new Algorithms(); // Algorithms object
		
		List<Sheet> listNextFit = algo.nextFit(shapes);
		List<Sheet> listFirstFit = algo.firstFit(shapes);
		
		System.out.println("---------------------------------------------");
		System.out.println("NextFit output");
		for(Sheet sheet: listNextFit){
			System.out.println(sheet);
		}
		System.out.println("---------------------------------------------");
		System.out.println("FirstFit output");		
		for(Sheet sheet: listFirstFit){
			System.out.println(sheet);
		}
		System.out.println("---------------------------------------------");
	}
	
}
