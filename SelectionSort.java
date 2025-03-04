public class SelectionSort {
    public static void main(String[] args) {
        int[] numbers={12,23,5,34,5,90,56,3,8,10};
        int size=numbers.length;
        int minIndex;
        int minValue;
        System.out.println("Before sorting: ");
        for(int i=0;i<size;i++)
        {
            System.out.print(numbers[i]+" ");
        }

        for (int i=0;i<size-1;i++)
        { 
           minIndex=i;
           minValue=numbers[i];
           for(int j=i+1;j<size;j++)
           {
            if(minValue>numbers[j])
            {
                minIndex=j;
                minValue=numbers[j];
            }
           } 
           int temp=numbers[i];
           numbers[i]=minValue;
           numbers[minIndex]=temp;
        }

        System.out.println();
        System.out.println("After sorting: ");
        for(int i=0;i<size;i++)
        {
            System.out.print(numbers[i]+" ");
        }
    }
}
// Time complexity = N ^ 2