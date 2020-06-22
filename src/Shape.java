import java.util.Comparator;

/**
 * @Purpose: The shape class represents a single shape. DO NOT MODIFY THE
 *           SIGNITURE OF EXISTING METHODS, You may add additional methods if
 *           you wish
 * 
 * @author RYK
 * @since 30/10/2019 
 * extended by Eigminas Slavinskas 
 * 
 **/

public class Shape implements Comparable<Shape> {

	private int sWidth;   // width of the shape
	private int sHeight;  // height of the shape
	/** 3 static comparators for sorting shapes in SortedTest.java **/
	static Comparator<Shape> sortByHeight(){
		return new Comparator<Shape>(){

			@Override
			public int compare(Shape shape1, Shape shape2) {
				return shape1.getHeight() < shape2.getHeight() ? -1 : shape1.getHeight() == shape2.getHeight() ? 0 : 1;
			}
			
		};
	}
	static Comparator<Shape> sortByWidth(){
		return new Comparator<Shape>(){

			@Override
			public int compare(Shape shape1, Shape shape2) {
				return shape1.getWidth() < shape2.getWidth() ? -1 : shape1.getWidth() == shape2.getWidth() ? 0 : 1;
			}
			
		};
	}
	static Comparator<Shape> sortByRatio(){
		return new Comparator<Shape>(){

			@Override
			public int compare(Shape shape1, Shape shape2) {
				return shape1.getRatio() < shape2.getRatio() ? -1 : shape1.getRatio() > shape2.getRatio() ? 1 : 0;
			}
			
		};
	}
	
	/**
	 * A Shape constructor to set the width and height of a shape. 
	 * @param width of a shape
	 * @param height of a shape
	 **/
	
	public Shape(int width, int height) {

		// Shape width and height should not be greater than the sheet width and height
		if (width > Sheet.SHEET_WIDTH || height > Sheet.SHEET_HEIGHT) {
			throw new IllegalArgumentException("Shape width or height is not valid");
		}

		this.sWidth = width;
		this.sHeight = height;
	}

	/**
	 * @return height of a shape
	 **/
	public int getHeight() {
		return sHeight;
	}

	/**
	 * @return width of a shape
	 */
	public int getWidth() {
		return sWidth;
	}
	
	/**
	 * @return ratio
	 */
	public double getRatio() {
		return sHeight/ (double) sWidth;
	}
	@Override
	public int compareTo(Shape arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
