/**
 * ListNode represents a signe-link list node
 * Each node contains an Object reference to data and a reference to the next node in the list.
*/
class ListNode<T> {
	// package access members; List can access these directly
	T item;
	ListNode<T> next;

	/**
	 * Constructor. It initializes data and sets next node to null
	 * @param item a reference to node's data
	*/
	ListNode(T item){
		this(item, null);

	} // end ListNode one-argument constructor

	/**
	 * constructor creates ListNode with passed data and next node
	 * @param item the reference to node's data
	 * @param node the next node in the list
	*/
	ListNode(T item, ListNode<T> node ) {
		this.item =  item;
		next = node;

	} // end ListNode two-argument constructor

	/**
	 * Returns this node's data
	 * @return the reference to node's data
	*/
	T getItem() {
		return item;
	} // end method getObject

	/**
	 * Get reference to next node
	 * @return the next node
	*/
	ListNode<T> getNext() {
		return next;
	} // end method getNext
} // end class ListNode
