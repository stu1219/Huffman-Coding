// AUTHOR :SAI RAM GANDLA(ULID:SGANDLA) Date:03-12-2023,Time : 10:00 AM
// UID : 807411976
// Here by I declare that I have not copied this code from any external resource,
// But referred few sites to learn the algorithm, which i mentioned in the report of this programming assignment.
// all copy rights belong to Sai Ram Gandla
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;
import java.util.LinkedList;

//AUTHOR :SAI RAM GANDLA(SGANDLA) Date:03-12-2023,Time : 10:00 AM
public class HuffmanCode {
	
    // Initializing root node of the Huffman tree as null
	node huffmanRootNode = null;

	// Initialize a HaspMap to store Huffman Codes
	HashMap<Character, String> huffCodeMap = null;
	
	// Defining a nested class called node to represent a node in the Huffman tree
	class node {
		// Pointer to the left child node
		node leftNode = null;
		// Pointer to the right child node
		node rightNode = null;
		// Depth of the node in the tree
		int nodeDepth = 1;
		// Count of nodes in the subtree rooted at this node
		int nodeCount = 1;
		// Frequency of the character represented by this node
		int nodeFrequency = Integer.MAX_VALUE;
		// Character value represented by this node
		char nodeCharVal;

		public node() {}
		// Constructor to initialize a node with a character value and frequency
		public node(char nodeVal, int nodeFrequency) {
			this.nodeCharVal = nodeVal;
			this.nodeFrequency = nodeFrequency;
		}
		
	}
	//AUTHOR :SAI RAM GANDLA(SGANDLA) Date:03-12-2023,Time : 10:00 AM
	// Method to get the node with minimum frequency from a list of nodes
	public node getMin(LinkedList<node> nodes) {
		// Initializing a new node object with default values
		node minnode = new node();
		// Looping through the list of nodes
		for (node n : nodes) {
			// Comparing the frequency of the current node with the frequency of the current minimum node
			if (minnode.nodeFrequency > n.nodeFrequency) {
				minnode = n;
			}
		}
		// Returning the node with the minimum frequency
		return minnode;
	}
	
    //AUTHOR :SAI RAM GANDLA(SGANDLA) Date:03-12-2023,Time : 10:00 AM
	// Constructor to initialize a HuffmanCode object with an array of characters and their corresponding frequencies
	public HuffmanCode(char[] a, int[] f) {
		// Creating a linked list to store the nodes of the Huffman tree
		LinkedList<node> nodes = new LinkedList<node>();
		// Creating nodes for each character and adding them to the linked list
		for (char ch : a) {
			node n = new node(ch, f[nodes.size()]);
			// Adding the node to the linked list
			nodes.add(n);
		}
        // Building the Huffman tree by merging nodes with minimum frequency
		while (!nodes.isEmpty()) {
			// Finding the nodes with the two minimum frequencies in the linked list
			node firstMin = null;
			node secondMin = null;

			if (!nodes.isEmpty() && nodes.getFirst() != null) {
				firstMin = getMin(nodes);
				nodes.remove(firstMin);
			}

			if (!nodes.isEmpty() && nodes.getFirst() != null) {
				secondMin = getMin(nodes);
				nodes.remove(secondMin);
			}
			// If either firstMin or secondMin is null, the tree is complete
			if (firstMin == null || secondMin == null) {
				break;
			}
            // Creating a new node by merging the two nodes with the minimum frequencies
			node mergeNode = getMergeNode(firstMin, secondMin);
            // Adding the new node to the linked list
			nodes.add(mergeNode);
            // Updating the root node of the Huffman tree
			huffmanRootNode = mergeNode;
		}

	}
	
    //AUTHOR :SAI RAM GANDLA(SGANDLA) Date:03-13-2023,Time : 5:00 PM
	// This method takes in two nodes as parameters and returns a new node which is the merge of the two nodes
	public node getMergeNode(node left, node right) {
		// Create a new node for the merge
		node mergeNode = new node();
		// Assign the sum of the character values of the left and right nodes to the character value of the merge node
		mergeNode.nodeCharVal = (char) (left.nodeCharVal + right.nodeCharVal);
		// Assign the sum of the frequencies of the left and right nodes to the frequency of the merge node
		mergeNode.nodeFrequency = left.nodeFrequency + right.nodeFrequency;
		// Assign the sum of the node counts of the left and right nodes to the node count of the merge node
		mergeNode.nodeCount = left.nodeCount + right.nodeCount;
		// Check if the depths of the left and right nodes are the same
		if (left.nodeDepth == right.nodeDepth) {
			// If the node count of the left node is less than the node count of the right node, assign the left node to the left of the merge node and the right node to the right of the merge node
			if (left.nodeCount < right.nodeCount) {
				mergeNode.rightNode = right;
				mergeNode.leftNode = left;
				mergeNode.nodeDepth = right.nodeDepth;
				return mergeNode;
			}
			// If the node count of the right node is less than the node count of the left node, assign the right node to the left of the merge node and the left node to the right of the merge node 
			else if (left.nodeCount > right.nodeCount) {
				mergeNode.rightNode = left;
				mergeNode.leftNode = right;
				mergeNode.nodeDepth = left.nodeDepth;
				return mergeNode;
			} 
			// If the node counts of the left and right nodes are the same, compare their character values and assign the nodes to the left and right of the merge node accordingly
			else if (left.nodeCount == right.nodeCount) {
				if ((int) left.nodeCharVal < (int) right.nodeCharVal) {
					mergeNode.rightNode = right;
					mergeNode.leftNode = left;
					mergeNode.nodeDepth = right.nodeDepth;
					return mergeNode;
				} else {
					mergeNode.rightNode = left;
					mergeNode.leftNode = right;
					mergeNode.nodeDepth = left.nodeDepth;
					return mergeNode;
				}
			}
		}
		// If the depths of the left and right nodes are different, assign the node with the greater depth to the left of the merge node and the node with the lesser depth to the right of the merge node
		if (left.nodeDepth < right.nodeDepth) {
			mergeNode.rightNode = right;
			mergeNode.leftNode = left;
			mergeNode.nodeDepth = right.nodeDepth;
			return mergeNode;
		}
		if (left.nodeDepth > right.nodeDepth) {
			mergeNode.rightNode = left;
			mergeNode.leftNode = right;
			mergeNode.nodeDepth = left.nodeDepth;
			return mergeNode;
		}
		// Return the merge node
		return mergeNode;
	}
	
    //AUTHOR :SAI RAM GANDLA(SGANDLA) Date:03-13-2023,Time : 5:00 PM
	// This method takes in a node and a Huffman code as parameters and prints out the Huffman code for the node's character value, along with its frequency
    public void printLine(node n, String huffCode) {
		// If the node is null, return
        if (n == null)
            return;
		// If the node has no left or right child, it is a leaf node, so print out its character value, its Huffman code, and its frequency
        else if (n.leftNode == null && n.rightNode == null) {
        	System.out.println(n.nodeCharVal + "[" + (int)n.nodeCharVal + "]:" + huffCode + " " + "(" + n.nodeFrequency + ")");
            // Add the character value and its corresponding Huffman code to the Huffman code map
        	huffCodeMap.put(n.nodeCharVal, huffCode);
        }
        // Recursively call the method on the left child of the node, adding a "0" to the Huffman code
        printLine(n.leftNode, huffCode + "0");
        // Recursively call the method on the right child of the node, adding a "1" to the Huffman code
        printLine(n.rightNode, huffCode + "1");
    }

    //AUTHOR :SAI RAM GANDLA(SGANDLA) Date:03-13-2023,Time : 5:00 PM
	// This method prints out the Huffman codes for each character in the Huffman tree
    public void printCodeWords() {
		// Create a new node and set it to the Huffman root node
        node n = new node();
        n = this.huffmanRootNode;
		// Create a new HashMap to hold the Huffman codes for each character
        huffCodeMap = new HashMap<Character, String>();
        System.out.println("Huffman Codes :");
        printLine(n, "");
    }

    //AUTHOR :SAI RAM GANDLA(SGANDLA) Date:03-13-2023,Time : 5:00 PM
	// This method takes in a String input and encodes it using the Huffman codes generated by the Huffman tree
	public Object encode(String input) {
		String encodedString = "";
		CharacterIterator it = new StringCharacterIterator(input);
		while (it.current() != CharacterIterator.DONE) {
			// Get the Huffman code for the current character and add it to the encoded String
			encodedString += huffCodeMap.get(it.current());
			// Move to the next character in the String
			it.next();
		}
		// Return the encoded String
		return encodedString;
	}

    //AUTHOR :SAI RAM GANDLA(SGANDLA) Date:03-13-2023,Time : 5:00 PM
	// This method takes in an encoded String and decodes it using the Huffman tree
	public Object decode(String input) {
		String decodedString = "";
		// Create a new node and set it to the Huffman root node
		node n = new node();
		n = this.huffmanRootNode;
		// Create a CharacterIterator to iterate through the input String
		CharacterIterator it = new StringCharacterIterator(input);

		while (it.current() != CharacterIterator.DONE) {
			// If the current character is '0', move to the left child node of the current node
			if (Character.compare('0', it.current()) == 0) {
				n = n.leftNode;
			}
			// If the current character is '1', move to the right child node of the current node
			else {
				n = n.rightNode;
			}
			// If the left child node of the current node is null, we have reached a leaf node and can add the decoded character to the decoded String
			if (n.leftNode == null) {
				decodedString += n.nodeCharVal;
				// Reset the current node to the Huffman root node
				n = this.huffmanRootNode;
			}
			// Move to the next character in the input String
			it.next();
		}
		// Return the decoded String
		return decodedString;
	}

}