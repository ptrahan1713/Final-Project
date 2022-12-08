package binaryproblem1;

import java.util.LinkedList;

/**
 * This is the search tree for the Binary Tree Problem 1
 *
 * @author Patrick Trahan
 */
public class BinarySearch<E extends Comparable<E>>
{

    private Node root;
    private String preOrderOutput = "";
    private String inOrderOutput = "";
    private String postOrderOutput = "";
    private LinkedList<Node> queue = new LinkedList<>();

    /**
     * This is the method that the main method calls and all it does is calls a
     * same but different method that has the Node in it
     *
     * @param data is the value that is being added to the tree
     */
    public void insertData(E data)
    {
        root = insertData(root, data);
    }

    /**
     * This is the method to insert data into the tree.
     *
     * @param tree is the binary search tree
     * @param data is the value that is being inserted into the tree
     * @return the new tree
     */
    public Node insertData(Node tree, E data)
    {
        if (tree == null)
        {
            //creates the root tree with the data
            tree = new Node(data);
        } else
        {
            //had to make a variable to store the data of the root tree
            E rootData = (E) tree.getData();

            //the if checks to see if the data is the same as the root data
            if (data.compareTo(rootData) == 0)
            {
                System.out.println("Cannot add value is equal to the Root data");
            } // checks to see if the data is less than the root which means add it to the left
            else if (data.compareTo(rootData) < 0)
            {
                //recurvsively calls the left till it is at the correct position
                tree.setLeft(insertData(tree.leftTree(), data));
            } // checks to see if the data is greater than the root which means add it to the right
            else
            {
                //recurvsively calls the right till it is at the correct position
                tree.setRight(insertData(tree.rightTree(), data));
            }
        }
        return tree;
    }

    /**
     * Will store a string of the preorder traversal of the search tree will
     * recursively do so
     *
     * @param tree the binary search tree
     * @return the output as a string
     */
    public String preOrder(Node tree)
    {
        if (tree != null)
        {
            //stores the value in the string
            preOrderOutput = preOrderOutput + tree.getData() + " ";

            //recursively calls the left tree
            preOrder(tree.leftTree());

            //recursively calls the right tree
            preOrder(tree.rightTree());
        }
        return preOrderOutput;
    }

    /**
     * Will store a string of the inorder traversal of the binary search tree
     * will recursively do so
     *
     * @param tree the binary search tree
     * @return the output as a string
     */
    public String inOrder(Node tree)
    {
        if (tree != null)
        {
            //recursively calls the left tree
            inOrder(tree.leftTree());

            //stores the value as a string
            inOrderOutput = inOrderOutput + tree.getData() + " ";

            //recursively calls the right tree
            inOrder(tree.rightTree());
        }
        return inOrderOutput;
    }

    /**
     * Will store a string of the post order traversal of the binary search tree
     * will recursively do so
     *
     * @param tree the binary search tree
     * @return the output as a string
     */
    public String postOrder(Node tree)
    {
        if (tree != null)
        {
            //recursively calls the left tree
            postOrder(tree.leftTree());

            //recursively calls the right tree
            postOrder(tree.rightTree());

            //stores the value as a string
            postOrderOutput = postOrderOutput + tree.getData() + " ";
        }
        return postOrderOutput;
    }

    /**
     * The method to print out all of the Depth First Search
     */
    public void dft()
    {
        if (root != null)
        {
            System.out.println("Pre Order: ");
            System.out.println(preOrder(root));

            System.out.println("\nIn Order: ");
            System.out.println(inOrder(root));

            System.out.println("\nPost Order: ");
            System.out.println(postOrder(root));
        } else
        {
            System.out.println("Tree is null");
        }
        
        //resetting the strings 
        preOrderOutput = null;
        inOrderOutput = null;
        postOrderOutput = null;
        
    }
    
    /**
     * This method will call the actual method to print it
     */
    public void bfs()
    {
        if (root != null)
        {
            System.out.println("\nBreadth First Search: ");
            bfs(root);
            System.out.println();
        } else
        {
            System.out.println("Tree is emtpy");
        }
    }
    
    /**
     * This will print the tree in Breadth First Search order 
     * @param tree is the binary search tree
     */
    public void bfs(Node tree)
    {
        //in case there is anything still left in the queue
        queue.clear();
        
        //temp Node for the while loop
        Node temp;
        
        //adds the root to the queue
        queue.add(tree);
        
        while(!queue.isEmpty())
        {
            //prints the value in the queue
            System.out.print(queue.peek().getData() + " ");
            
            //stores the Node in the temp and removes it from the queue
            temp = queue.pop();
            
            //checks to see if the left sub tree is null or not 
            if(temp.leftTree() != null)
            {
                //adds that value to the queue
                queue.add(temp.leftTree());
            }
            //checks to see if the right sub tree is null or not
            if(temp.rightTree() != null)
            {
                //adds that value to the queue
                queue.add(temp.rightTree());
            }
        }
    }

    /**
     * Calls the method to see if the targeted value is in the tree
     * @param target the value that you want to check for
     */
    public void dfsContain(E target)
    {
        System.out.println("\nCheck via Depth First Search");
        System.out.println("Does the tree contain " + target + ": " + dfsCheck(root, target));
    }
    
    /**
     * This will loop through the tree using the pre Order traversal to check if the 
     * targeted value is in the tree
     * @param tree is the binary search tree
     * @param target is the value that you are searching for
     * @return whether true or false if the value is in the tree
     */
    public boolean dfsCheck(Node<E> tree, E target)
    {
        //tree is null so has to be false
        if (tree == null)
        {
            return false;
        }
        
        //if the Node's value is the targetted value so return true
        if (target.equals(tree.getData()))
        {
            return true;
        }
        
        //checks if the left sub tree is not null
        if (tree.leftTree() != null)
        {
            //checks again using recursion in the if statement
            //if true it will return true if not it will move on
            if(dfsCheck(tree.leftTree(), target))
            {
                return true;
            }
        }
        
        //the same as with the left sub tree but with the right
        if (tree.rightTree() != null)
        {
            if(dfsCheck(tree.rightTree(), target))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * This method will call the check method to see if the target value is in the tree
     * @param target is the value that you are seeing is in the tree
     */
    public void bfsContain(E target)
    {
        System.out.println("\nCheck via Breadth First Search");
        System.out.println("Does the tree contain " + target + ": " + bfsCheck(target));
    }

    /**
     * This will look through the tree with the breadth first traversal to see if the 
     * value is in the tree
     * @param target the value that you want to see is in the tree or not
     * @return true or false depending on the outcome
     */
    public boolean bfsCheck(E target)
    {
        //clears whatever was in the queue before
        queue.clear();
        
        Node temp;
        
        //adds the root to the queue
        queue.add(root);
        
        //loops until the queue is empty
        while(!queue.isEmpty())
        {
            //this is the part that matters in this method
            //this will check if the target value is the same as the Node that is in
            //the queue
            if(queue.peek().getData().equals(target))
            {
                return true;
            }
            temp = queue.pop();
            if(temp.leftTree() != null)
            {
                queue.add(temp.leftTree());
            }
            if(temp.rightTree() != null)
            {
                queue.add(temp.rightTree());
            }
        }
        return false;
    }
}
