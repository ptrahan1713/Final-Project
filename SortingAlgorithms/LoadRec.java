
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author pattr
 */
public class LoadRec
{

    private String load = "";
    private int low;
    private int[] leftArray;
    private int[] rightArray;
    private ArrayList<Integer> leftArrayList = new ArrayList<>();
    private ArrayList<Integer> rightArrayList = new ArrayList<>();

    public LoadRec()
    {

    }

    public String loaderRec(int start, int[] nums)
    {
        if (start >= nums.length)
        {
            return load;
        }

        load = load + nums[start] + " ";

        start++;

        return loaderRec(start, nums);
    }

    public boolean groupSum(int start, int[] nums, int target)
    {
        if (start >= nums.length)
        {
            return (target == 0);
        }

        if (groupSum(start + 1, nums, target - nums[start]))
        {
            return true;
        }

        if (groupSum(start + 1, nums, target))
        {
            return true;
        }

        return false;
    }
    
    /**
     * Selection sort
     *
     * @param list
     * @return
     */
    public int[] orderLow(int[] list)
    {
        for (int i = 0; i < list.length; i++)
        {
            low = i;

            for (int j = i; j < list.length; j++)
            {
                if (list[j] < list[low])
                {
                    low = j;
                }
            }
            int temp = list[low];
            list[low] = list[i];
            list[i] = temp;

        }
        return list;
    }
    
    /**
     * This is the algorithm for the bubble sort 
     * @param userArray
     * @return 
     */
    public int[] bubbleSort(int[] userArray)
    {
        for (int j = 0; j < userArray.length - 1; j++)
        {
            for (int i = 0; i < userArray.length - j - 1; i++)
            {
                if (userArray[i] > userArray[i + 1])
                {
                    int temp = userArray[i];
                    userArray[i] = userArray[i + 1];
                    userArray[i + 1] = temp;
                }
            }
        }
        return userArray;
    }
    
    /**
     * This the splitting of the array and recurvisely runs it
     * 
     * @param userArray
     * @param beg
     * @param end 
     */
   public void mergeSort(int[] userArray, int beg, int end)
    {
        if(end <= beg)
        {
            return;
        }
        
        int mid = (beg + end) / 2;
        
        mergeSort(userArray, beg, mid);
        mergeSort(userArray, mid + 1, end);
        
        merge(userArray, beg, mid, end);
    }
    
    public int[] merge(int[] userArray, int beg, int mid, int end)
    {
        leftArray = new int[mid - beg + 1];
        rightArray = new int[end - mid];
        
        for (int i = 0; i < leftArray.length; i++)
        {
            leftArray[i] = userArray[beg + i];
        }

        for (int i = 0; i < rightArray.length; i++)
        {
            rightArray[i] = userArray[i + mid + 1];
        }
        
        //place holders for each of the arrays
        
        //for the left array
        int left = 0;
        
        //for the right array
        int right = 0;
        
        for(int i = beg; i < end + 1; i++)
        {
            if(left < leftArray.length && right < rightArray.length)
            {
                if(leftArray[left] < rightArray[right])
                {
                    userArray[i] = leftArray[left];
                    left++;
                }
                else
                {
                    userArray[i] = rightArray[right];
                    right++;
                }
            }
            else if(left < leftArray.length)
            {
                userArray[i] = leftArray[left];
                left++;
            }
            else if(right < rightArray.length)
            {
                userArray[i] = rightArray[right];
                right++;
            }
        }
        //System.out.println(Arrays.toString(userArray));
        
        return userArray;
    }
    
    /**
     * This is the method for insertion sort. 
     * @param userArray is the array that was randomly generated 
     * @return the sorted array
     */
    public int[] insertionSort(int[] userArray)
    {
        //loops through the entire Array 
        for(int position = 0; position < userArray.length - 1; position++)
        {
            //stores the value at the given position of the for loop
            //at the next value of the Array
            int holder = userArray[position + 1];
            
            //enters the while loop if position is greater than or equal to 0
            //and if the value of the Array at the position is greater than the 
            //holder which is the value of the next position of the array
            while((position >= 0) && (userArray[position] > holder))
            {
                //swaps the value
                userArray[position + 1] = userArray[position];
                //moves to the next position
                position = position - 1;
            }
            //stores the value into the array
            userArray[position + 1] = holder;
        }
        return userArray;
    }
    
    /**
     * This is the method for the shell sort
     * @param userArray the array that was randomly generated
     * @return the sorted array
     */
    public int[] shellSort(int[] userArray)
    {
        //in this for loop you divide length of the array by 2 and that is set to gap
        // while gap is greater than 0 and divide gap by 2 for every increment
        for(int gap = userArray.length / 2; gap > 0; gap = gap / 2)
        {
            //The rest of this is similar to the insertion sort method
            for(int position = gap; position < userArray.length; position++)
            {
                //stores the value at the position i in the array
                int holder = userArray[position];
                
                //enters the while loop if the position is less than or equal to the gap
                // AND if the array at position - gap is less than the holder value
                while((position >= gap) && (userArray[position - gap] > holder))
                {
                    //swap the values
                    userArray[position] = userArray[position - gap];
                    
                    //decrement the position by the size of gap
                    position = position - gap;
                }
                //store the value in the correct position
                userArray[position] = holder;
            }
        }
        return userArray;
    }
    
    /**
     * Swaps the first value of the array with the second value of the array
     * @param userArray array that is being sorted
     * @param first int of the first position of the array
     * @param second  int of the second position of the array
     */
    public void quickSwap(int[] userArray, int first, int second)
    {
        //temportary stores the value of the position first in the array
        int temp = userArray[first];
        
        //stores the array value of position second in position first
        userArray[first] = userArray[second];
        
        //stores the value of temp in the position of second in the array
        userArray[second] = temp;
    }
    
    public int quickPartition(int[] userArray, int low, int high)
    {
        //This loop is similar to the shell sort or insertion sort
        
        //holds the value of the high index of array
        int holder = userArray[high];
        
        // sets the element to be 1 less than the lowest index
        int element = low - 1;
        
        //same for loop as insertion and shell sort
        for(int position = low; position <= high - 1; position++)
        {
            //if the value of the array at the position is less than the value of holder
            //enter the if loop 
            //if not increment the for loop
            if(userArray[position] < holder)
            {
                //increment element
                element++;
                
                //call the swap method to switch the values
                quickSwap(userArray, element, position);
            }
        }
        //swap the highest value with 1 plus the lowest value
        quickSwap(userArray, element + 1, high);
        
        //returns that index
        return (element + 1);
    }
    
    public int[] quickSort(int[] userArray, int startElement, int max)
    {
        //will enter the if statement when the starting element is less than max
        if(startElement < max)
        {
            //calls into the partition method and returns a new index
            int index = quickPartition(userArray, startElement, max);
            
            //recurvsively calls the quickSort method
            quickSort(userArray, startElement, index - 1);
            quickSort(userArray, index + 1, max);
        }
        return userArray;
    }
    
    /**
     * Method to print the array 
     * @param userArray 
     */
    public void printArray(int[] userArray)
    {
        System.out.println("Modified");
        for (int i = 0; i < userArray.length; i++)
        {
            System.out.print(userArray[i] + " ");
        }
        System.out.println("\n");
    }
    
    /**
     * Validates the array to make sure it is in order 
     * @param userArray
     * @return 
     */
    public boolean validate(int[] userArray)
    {
        for (int i = 0; i < userArray.length - 1; i++)
        {
            if (userArray[i] > userArray[i + 1])
            {
                return false;
            }
        }
        return true;
    }
}
