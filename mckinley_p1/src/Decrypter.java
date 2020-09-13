public class Decrypter
{
    //run encrypt enough to learn the modulo formula backwards
    public static String decrypt(String decrypt)
    {
        int[] array = new int[4];
        //String decrypt = ("0189");
        //Assigning char to an array - same as encrypter
        for (int i = 0; i < 4; i++)
        {
            char x = decrypt.charAt(i);
            array[i] = Character.getNumericValue(x);
        }

        int placeholder = array[0];
        array[0] = array[2];
        array[2] = placeholder;
        placeholder = array[1];
        array[1] = array[3];
        array[3] = placeholder;

        //System.out.println(array[0]);
        //System.out.println(array[1]);
        //System.out.println(array[2]);
        //System.out.println(array[3]);

        placeholder = 0;

        for(int i = 0; i < 4; i++)
        {
            placeholder = array[i];
            placeholder = placeholder + 3;
            placeholder = placeholder % 10;
            array[i] = placeholder;
            System.out.println(placeholder);
        }
        int arrayConverter = 0;

        for(int i = 0; i < 4; i++)
            arrayConverter = array[i] + (arrayConverter * 10);

        String decryptedNum = Integer.toString(arrayConverter);

        //if(array[0] == 0)
           // decryptedNum = "0" + decryptedNum;
        if(array[1] == 0)
            decryptedNum = "0" + decryptedNum;
        if(array[2] == 0)
            decryptedNum = "0" + decryptedNum;
        if(array[3] == 0)
            decryptedNum = "0" + decryptedNum;

     return decryptedNum;
    }
}
