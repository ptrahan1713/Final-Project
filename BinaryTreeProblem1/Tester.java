package binaryproblem1;

/**
 * This is the main method for the Binary Tree Problem 1
 * @author Patrick Trahan
 */
public class Tester
{
    public static void main(String[] args)
    {
        BinarySearch<Integer> search = new BinarySearch<>();
        
        search.insertData(5);
        search.insertData(4);
        search.insertData(10);
        search.insertData(1);
        search.insertData(8);
        
        search.dft();
        
        search.bfs();
        
        search.bfsContain(4);
        
        search.bfs();
        
        search.dfsContain(1);
    }
}
