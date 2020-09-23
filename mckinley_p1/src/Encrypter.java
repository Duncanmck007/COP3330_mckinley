import java.util.Arrays;

public class Encrypter
{
    //accept string encrypt from external class
    public static String encrypt(String encrypt)
    {
        //need new array for storage of the 4 string values
        int[] array = new int[4];
        int[] placeholderArray = new int[4];
        int i;

        for (i = 0; i < 4; i++)
        {
            //grabbing character and setting to variable
            char x = encrypt.charAt(i);
            //.getNumericValue to assign char to number for array
            array[i] = Character.getNumericValue(x);
        }

        //algorithms for finding +7 /10 remainder
        for (i = 0; i < 4; i++)
        {
            array[i] = (array[i] + 7)% 10;     //math for algorithms
            placeholderArray[i] = array[i];    //for later use in position switching
        }

        //switching around of 0 to 2 and 1 to 3
        array[0] = placeholderArray[2];
        array[1] = placeholderArray[3];
        array[2] = placeholderArray[0];
        array[3] = placeholderArray[1];


        String test = Arrays.toString(array)
            .replace(",", "")
            .replace("[", "")
            .replace("]", "")
            .replace(" ", "");
        String encryptedNum = test;
        return encryptedNum;

    }
}


