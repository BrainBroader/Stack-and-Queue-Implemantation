/**
 * NoSuchElementException is a simple class that extends RuntimeException. It 
 * is thrown by {@link List} when get methods are called on an empty list. 
 */
public class NoSuchElementException extends RuntimeException {
	/**
	 * Default constructor, calls constructor with parameter name set to "List"
	 */
	public NoSuchElementException() {
		this( "List" ); // call other NoSuchElementException constructor
	} // end NoSuchElementException no-argument constructor

	/**
	 * Constructor with list's name, calls RuntimeException(String)
	 * @param name the list name
	 */
	public NoSuchElementException( String name ) {
		super( name + " is empty" ); // call superclass constructor
	} 
} 
