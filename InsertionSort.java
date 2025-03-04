public class InsertionSort{
    public static void main (String [] args){
        int[] numbers={32,16,22,21,30,16,8,50};
        int size=numbers.length;
        System.out.println("Before sorting: ");
        for(int i=0;i<size;i++)
        {
            System.out.print(numbers[i]+" ");
        }
        //Sorting logic
        //int[] numbers={32,16,22,21,30,16,8,50};
        for (int i = 1; i < size; i++){    //i = 2
        int temp = numbers[i];
        int j = i - 1; //j = 1
        while (j >= 0 && temp < numbers[j]){
            numbers[j+1] = numbers[j];
            j--;
        }
        numbers[j+1] = temp;
        }
        System.out.println();
        System.out.println("After sorting: ");
        for(int i=0;i<size;i++)
        {
            System.out.print(numbers[i]+" ");
        }
    }
}