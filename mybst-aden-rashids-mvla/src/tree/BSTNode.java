package tree;

// TODO: Auto-generated Javadoc
/**
 * The Class BSTNode. This is a Generic Binary Search Tree, and includes the methods for operating on 
 * that tree
 *
 * @param <E> the element type
 */
public class BSTNode<E> {
	
	/** The data. */
	private E data;
	
	/** The parent. */
	private BSTNode<E> parent;
	
	/** The left. */
	private BSTNode<E> left;
	
	/** The right. */
	private BSTNode<E> right;
	

	/**
	 * Instantiates a new BST node.
	 *
	 * @param e the e
	 * @param parent the parent
	 */
	public BSTNode(E e, BSTNode<E> parent) {
		// TODO: Complete the constructor
		this.data = e;
		this.parent = parent;
		this.left = null;
		this.right = null;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	E getData() {
		// TODO: Complete this method
		return data;
	}
	
	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	void setData(E data) {
		// TODO: Complete this method
		this.data = data;
	}
	
	/**
	 * Sets the parent to node
	 *
	 * @param node the new parent
	 */
	void setParent(BSTNode<E> node) {
		// TODO: Complete this method
		this.parent = node;
	}
	
	/**
	 * Gets the parent node
	 *
	 * @return the parent
	 */
	BSTNode<E> getParent() {
		// TODO: Complete this method
		return parent;
	}
	
	/**
	 * Gets the left child.
	 *
	 * @return the left child
	 */
	 BSTNode<E> getLeftChild() {
		// TODO: Complete this method
		return left;
	}

	/**
	 * Gets the right child.
	 *
	 * @return the right child
	 */
	BSTNode<E> getRightChild() {
		// TODO: Complete this method
		return right;
	}
	
	/**
	 * Sets the left child to the passed in node.
	 *
	 * @param node the new left child
	 */
	void setLeftChild(BSTNode<E> node) {
		// TODO: Complete this method
		this.left = node;
	}
	
	/**
	 * Sets the right child to the passed in node.
	 *
	 * @param node the new right child
	 */
	void setRightChild(BSTNode<E> node) {
		// TODO: Complete this method
		this.right = node;
	}
	
	
	/**
	 * Creates and initializes a new left child.
	 *
	 * @param element the new left child
	 */
	void addLeftChild(E element) {
		// TODO: Complete this method
		BSTNode<E> left = new BSTNode<E>(element, getParent());
	}

	/**
	 * Creates and initializes a new right child.
	 *
	 * @param element the new right child
	 */
	void addRightChild(E element) {
		// TODO: Complete this method
		BSTNode<E> right = new BSTNode<E>(element, getParent());
	}
	
	/**
	 * Checks if the current node is a leaf node.
	 *
	 * @return true, if is leaf
	 */
	// Part 2
	public boolean isLeaf() {
		return((left == null) && (right == null));
	}
	
	/**
	 * Checks if the current node has a left child
	 *
	 * @return true, if the current node has a left child; otherwise false
	 */
	public boolean hasLeft() {
		return (left != null);
	}

	/**
	 * Checks for right.
	 *
	 * @return true, if the current node has a right child; otherwise false
	 */
	public boolean hasRight() {
		return (right != null);
	}
}
