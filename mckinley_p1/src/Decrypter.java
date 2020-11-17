import java.util.Arrays;
//added comments to try to get github to update
public class Decrypter
{
    public static String decrypt(String decrypt)
    {
        int[] array = new int[4];
        int[] placeholderArray = new int[4];
        int i;
        for (i = 0; i < 4; i++)
        {
            char x = decrypt.charAt(i);
            array[i] = Character.getNumericValue(x);
            placeholderArray[i] = array[i];
        }

        array[0] = placeholderArray[2];
        array[1] = placeholderArray[3];
        array[2] = placeholderArray[0];
        array[3] = placeholderArray[1];

        for (i = 0; i < 4; i++)
        {
            array[i] = (array[i] + 3)% 10;     //math for algorithms
            placeholderArray[i] = array[i];
        }

        String test = Arrays.toString(array)
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "");
        String decryptedNum = test;
        return decryptedNum;

    }
}
