package hw5;

// The driver class to build a Binary search tree
public class GrowBTree {	
public static void main(String []args) {
Tree  root = null, temp;   // root represents the top of the tree
  for (int k = 1; k <= 10; ++k)       {
     temp = new Tree((int) (Math.random() * 10)); // create a Tree object
     System.out.println(temp.getValue());
     root = temp.growTree(root, temp); // Add the object to the binary tree
     } // for
  System.out.println("From tree...");
  root.printTree(root);	   // print the tree nodes  
  } // main
} // GrowBTree

class Tree  {   // A binary search tree class.
int  value;      
Tree  left, right;
public Tree (int k)  { value = k;  left = right = null;  } 
public int  getValue() { return  value; } 
public Tree growTree(Tree root, Tree newnode)  {
  if (root == null)      return  newnode;
  if (newnode.value>root.value) 
    root.right = root.growTree(root.right, newnode);
  else   
    root.left = root.growTree(root.left, newnode);
  return root;
  } // growbTree
public void  printTree(Tree root)     {
     if (root != null) 	  {
	  root.printTree(root.left);
	  System.out.println(root.value);
	  root.printTree(root.right);
	  } 
  } // printTree
} // Tree