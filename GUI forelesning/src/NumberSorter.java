import java.util.Arrays;

/**
 * Created by slafa on 29.04.2017.
 */
public class NumberSorter
{
    static int [] grr = new int[10];

    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(grr));
       // oddetall(new int[]{1, 2, 5, 6, 7, 4, 3, 3, 5, 6});
    }


    public static void oddetall(int [] array)
    {
        int[] partall = new int[array.length];
        int[] oddetall = new int[array.length];

        int g = 0;
        int j = 0;
        for (int i = 0; i < array.length; i++)

        {

            if(array[i] % 2 == 0) {

                partall[g] = array[i];
                g++;
            }
            else {

                oddetall[j] = array[i];
                j++;
            }
            System.out.println("array number :"+ array[i]);

        }

        System.out.println("Partall: " +  Arrays.toString(partall));
        System.out.println("Oddetall: " + Arrays.toString(oddetall));
//for(int i = 0; i < partall.length;i++)
  //      System.out.print(partall[i]+ ", ");
    }
}
