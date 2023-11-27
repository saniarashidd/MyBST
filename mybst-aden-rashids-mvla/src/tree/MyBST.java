package tree;

import java.util.LinkedList;
import java.util.Queue;

// TODO: Auto-generated Javadoc
/**
 * The Class MyBST.
 *
 * @param <E> the element type
 */
public class MyBST<E extends Comparable<E>> {
	
	/** The root of the BST. */
	private BSTNode<E> root;
	
	/** The size of the BST. */
	int size;
	
	/** The str order. */
	String strOrder;

	/**
	 * Instantiates a new MyBST .
	 */
	public MyBST() {
		// TODO: Complete this constructor
		root = null;
		size = 0;
	}
	
	// Part 1 - code and validate the insert and search methods
	
	/**
	 * Gets the root.
	 *
	 * @return the root node of the Binary Search Tree
	 */
	public BSTNode<E> getRoot() {
		// TODO: Write this method
		return root;
	}

	
	/**
	 * Gets the size of the Binary Search Tree.
	 *
	 * @return the size of the Binary Search Tree
	 */
	public int getSize() {
		// TODO: Write this method
		return size;
	}
	/**
	 * Insert.
	 *
	 * @param e the element to insert into the BST
	 * @return true, if successful; false if e already exists in the BST
	 */
	public boolean insert(E e) {
		// TODO: Write the insert method. Refer to the pseudocode in the 
		//       slides to help you if needed.
		if(root == null) {
			root = new BSTNode<E>(e, null);
			size++;
			return true;
		}
		
		else {
			BSTNode<E> node = root;
			while(((e.compareTo(node.getData()) < 0) && node.getLeftChild() != null) ||
					((e.compareTo(node.getData()) > 0) && node.getRightChild() != null)) {
				
				if(e.compareTo(node.getData()) < 0) {
					node = node.getLeftChild();
				}
				else if(e.compareTo(node.getData()) > 0) {
					node = node.getRightChild();
				}
				
			}
			
			if(e.compareTo(node.getData()) < 0) {
				node.setLeftChild(new BSTNode<E>(e, node));
				
			}
			else if(e.compareTo(node.getData()) > 0) {
				node.setRightChild(new BSTNode<E>(e, node));
				
			}
			else {
				return false;
			}
		}
		size++;
		return true;
	}
	
	/**
	 * Search the BST.
	 *
	 * @param e the element to search for
	 * @return true, if the element was found in the list...
	 */
	public boolean search(E e) {
		// TODO: Write the search method. Refer to the pseudocode in the 
		//       slides to help you if needed.
		if(root == null) {
			return false;
		}
		BSTNode<E> node = root;
		while(((e.compareTo(node.getData()) < 0) && node.getLeftChild() != null) ||
				((e.compareTo(node.getData()) > 0) && node.getRightChild() != null)) {
			if(e.compareTo(node.getData()) < 0) {
				node = node.getLeftChild();
			}
			else if(e.compareTo(node.getData()) > 0) {
				node = node.getRightChild();
			}
			
		}
		//System.out.println(e.compareTo(node.getData()) == 0);
		return (e.compareTo(node.getData()) == 0); 
	}
	

	// Part 2: Pre/Post/In order traversals
	
	/**
	 * Debug method to dump the results of a traversal as a string
	 *
	 * @return the str order
	 */
	public String getStrOrder() {
		return(strOrder);
	}
	
	/**
	 * Preorder - traverse the BST using the preorder search algorithm.
	 * This should be written recursively, and will require two overloaded
	 * methods
	 */
	public void preorder() {
		strOrder = "";
		preorder(root);
	}
	
	/**
	 * Preorder traversal - process node, then left then right.
	 * Update strOrder with node.getData() when processed
	 *
	 * @param node the node
	 */
	private void preorder(BSTNode<E> node) {
		// TODO: write the private preorder recursive method
		if(node == null) {
			return;
		}
		strOrder += node.getData() + ",";
		preorder(node.getLeftChild());
		preorder(node.getRightChild());
		
	}

	/**
	 * Inorder - traverse the BST using the inorder search algorithm.
	 * This should be written recursively, and will require two overloaded
	 * methods
	 */
	public void inorder() {
		strOrder = "";
		inorder(root);
	}
	
	/**
	 * Inorder traversal - process left, node, then right
	 * Update strOrder with node.getData() when processed
	 *
	 * @param node the node being traversed
	 */
	private void inorder(BSTNode<E> node) {
		// TODO: write the private inorder recursive method
		if(node == null) {
			return;
		}
		inorder(node.getLeftChild());
		strOrder += node.getData() + ",";
		inorder(node.getRightChild());
		
		
	}
	
	/**
	 * Postorder - traverse the BST using the postorder search algorithm.
	 * This should be written recursively, and will require two overloaded
	 * methods
	 */
	public void postorder() {
		strOrder = "";
		postorder(root);
	}
	
	/**
	 * Postorder traversal - process left, then right then node.
	 * Update strOrder with node.getData() when processed
	 *
	 * @param node the node being traversed
	 */
	private void postorder(BSTNode<E> node) {
		// TODO: write the private postorder recursive method
		if(node == null) {
			return;
		}
		postorder(node.getLeftChild());
		postorder(node.getRightChild());
		strOrder += node.getData() + ",";
	}
	
	// Part 3: Level order Traversal and node removal

	/**
	 * Levelorder. Processes the nodes of a binary tree by level, starting at the root. 
	 * Note that this is not recursive. Update strOrder when a node is removed from the
	 * queue.
	 */
	public void levelorder() {
		strOrder = "";
		// TODO: write the levelorder method
		Queue <BSTNode <E>> levelQ = new LinkedList<BSTNode <E>>();
		
		levelQ.add(root);
		while(!levelQ.isEmpty()) {
			BSTNode<E> node = levelQ.peek();
			levelQ.poll();
			
			if(node != null) {
				levelQ.add(node.getLeftChild());
				levelQ.add(node.getRightChild());
				strOrder = strOrder + node.getData() + ",";
			}
		}
	}
	
	/**
	 * Returns the BSTNode whose data contains the given element.
	 *
	 * @param e the element to be matched
	 * @return the matching BSTNode if element was found; null otherwise.
	 */
	private BSTNode<E> getMatchingNode(E e) {
		// TODO: write this method - should be similar to search except that it
		//       returns a BSTNode
		if(root == null) {
			return null;
		}
		BSTNode<E> node = root;
		while(((e.compareTo(node.getData()) < 0) && node.getLeftChild() != null) ||
				((e.compareTo(node.getData()) > 0) && node.getRightChild() != null)) {
			if(e.compareTo(node.getData()) < 0) {
				node = node.getLeftChild();
			}
			else if(e.compareTo(node.getData()) > 0) {
				node = node.getRightChild();
			}
			
		}
		if((e.compareTo(node.getData()) == 0)) {
			return node;
		}
		return null;
	}

	/**
	 * Connect to parent node to the child node in both directions.
	 * Must handle the case where the parent is null - connect to root
	 * Must handle the case where the child is null and NOT attempt to
	 * set the parent of the child!
	 *
	 * @param e the element value used to determine if connecting child to 
	 *          left or right branch of the parent
	 * @param parent the parent
	 * @param child the child
	 */
	private void connectToParent(boolean left, BSTNode<E> parent, BSTNode<E> child) {
		// TODO: write this method
		if(parent == null) {
			root = child;
			if(child != null) {
				child.setParent(null);
			}
		}
		else {
			if(left) {
				parent.setLeftChild(child);
			}
			else {
				parent.setRightChild(child);
			}
			if(child != null) {
				child.setParent(parent);
			}
		}		
	}
				
	
	/**
	 * Finds left-most node in the right child of the specified node.
	 *
	 * @param node the node
	 * @return the BST node
	 */
	private BSTNode<E> findLeftMostNode(BSTNode<E> node) {
		// TODO: write this method
		BSTNode<E> rightOfNode = node.getRightChild();
		if(rightOfNode != null) {
			while(rightOfNode.getLeftChild() != null) {
				rightOfNode = rightOfNode.getLeftChild();
			}
		}
		return rightOfNode;
	}

	/**
	 * Remove the BST node that contains the supplied element
	 *
	 * @param e the element to be searched for in the BST
	 * @return true if the element was found and deleted; false otherwise
	 */
	public boolean remove(E e) {
		// TODO: write this method. Refer to the slides to review all cases
		//       that must be handled. Use the helper methods above to simplify
		//       your code.
		boolean isLeftOfParent = false;
		BSTNode<E> node = getMatchingNode(e);
		if(node == null) {
			return false;
		}
		else {
			
			BSTNode<E> rightCh = node.getRightChild();
			BSTNode<E> leftCh = node.getLeftChild();
			BSTNode<E> parent = node.getParent();
			if(parent != null) {
				isLeftOfParent = node.getData().compareTo(parent.getData()) < 0;
			}
			//case 1
			if(rightCh == null & leftCh == null) {
				connectToParent(isLeftOfParent, parent, null);
			}
			//case 2a
			else if(rightCh == null && leftCh != null) {
				connectToParent(isLeftOfParent, parent, leftCh);
			}
			//case 2b
			else if(rightCh != null && leftCh == null) {
				//connectToParent(isRightOfParent, )
				connectToParent(isLeftOfParent, parent, rightCh);
			}
			//case 3
			else { //if(rightCh != null && leftCh != null)
				BSTNode<E> lmNode = findLeftMostNode(node);
				//3a
				if(lmNode == rightCh) {
					connectToParent(true, lmNode, leftCh);
					connectToParent(isLeftOfParent, parent, lmNode);
				}
				//3b
				else {
					connectToParent(true, lmNode.getParent(), lmNode.getRightChild());
					connectToParent(true, lmNode, leftCh);
					connectToParent(false, lmNode, rightCh);
					connectToParent(isLeftOfParent, parent, lmNode);
				}
			}
			size--;
			return true;
		}
		
	}
}



