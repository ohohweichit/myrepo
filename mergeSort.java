import java.io.*;
import java.util.*;

public class mergeSort
{
    public static void main (String[]args) throws FileNotFoundException, IOException
    {
        long startTime = System.currentTimeMillis();
        Scanner scan = new Scanner(new File("input.txt"));
        int counter = 0;
        while(scan.hasNextInt())
        {
            counter++;
            scan.nextInt();
        }
        Scanner scanN = new Scanner(new File("input.txt"));
        int array[] = new int [counter];
        for(int i=0; i<counter; i++)
        {
            array[i] = scanN.nextInt();
        }
        
        scan.close();
        scanN.close();
        
        int N = array.length;
        int[] aux = new int[N];
        merge_srt(array,aux,0,N-1);
        
            
        PrintWriter writer = new PrintWriter (new FileWriter("output.txt"));
                      
        for (Integer number : array)
        {
            writer.println(number+"\n");
            //System.out.print(number + " ");
        }
        //System.out.println();
        writer.close(); 
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Running Time= "+totalTime+"ms");
    }

        
    public static void merge_srt(int array[],int aux[], int lo, int hi)
    {
        int low = lo;
        int high = hi;
        if(low >= high) {
            return;
        }
        int mid = (low+high)/2;
        merge_srt(array, aux, low, mid);
        merge_srt(array, aux, mid+1, high);
        int i = lo;
        int j = mid+1;
        
        for(int k=lo; k<=hi; k++)
        {
            aux[k] = array[k];
            if(i>mid)
                array[k]=aux[j++];
            else if(j>hi)
                array[k]=aux[i++];
            else if(aux[j] < aux[i])
                array[k]=aux[j++];
            else
                array[k]=aux[i++];
        }
    }
}

                
