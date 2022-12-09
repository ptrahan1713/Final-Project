
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author pattr
 */
public class LoadRecRun
{
    private int[] check;
    private LoadRec loader;
    
    public LoadRecRun()
    {

    }
    
    public void run(int[] nums)
    {
        long start = System.currentTimeMillis();

        loader = new LoadRec();
        
        //Merge Sort
        loader.mergeSort(nums, 0, nums.length - 1);
        
        //Bubble Sort
        //loader.bubbleSort(nums);
        
        //Insertion Sort
        //check = loader.insertionSort(nums);
        
        //Shell Sort
        //check = loader.shellSort(nums);
        
        //Quick Sort
        //check = loader.quickSort(nums, 0, nums.length - 1);
        
        //Selection sort
        //loader.orderLow(nums);
        
        System.out.println(System.currentTimeMillis() - start);
        
        //loader.printArray(check);
    }
    
    int numOfIncrements = 100;
    
    //dumb down all of the javaDocs
    /**
     * Loops the increments of the array and will call the run method to 
     * sort the array. After calling run it will increment the arraySize and repeat.
     * @param intArraySize 
     */
    public void loop(int intArraySize)
    {
        for (int i = 1; i <= numOfIncrements; i++)
        {
            int arraySize = intArraySize * i;
            int[] nums = new int[arraySize];

            for (int j = 0; j < arraySize; j++)
            {
                Random rng = new Random();

                nums[j] = rng.nextInt(10000000);
            }

            run(nums);
        }
        
    }
}
