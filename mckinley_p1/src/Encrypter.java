public class Encrypter
{

    public static String encrypt(String encrypt)

        {
            int[] array = new int[4];
            int i;
            //String encrypt = "1234";
            System.out.println(encrypt);

            for (i = 0; i < 4; i++)
                {
                    //grabbing character and setting to variable
                    char x = encrypt.charAt(i);
                    //.getNumericValue to assign char to number for array
                    array[i] = Character.getNumericValue(x);
                }

            //algorithms for finding +7 /10 remainder
            for(i = 0; i < 4; i++)
                {
                    int placeholder;
                    placeholder = array[i];
                    placeholder = placeholder + 7;
                    placeholder = placeholder % 10;
                    array[i] = placeholder;
                }
            //System.out.println(array[0]);
            //System.out.println(array[1]);
            //System.out.println(array[2]);
            //System.out.println(array[3]);

            //switching around of 0 to 2 and 1 to 3
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

            int arrayConverter = 0;


            //for(int i = 0; i < 4; i++)
              //  arrayConverter = array[i];
            //String encryptedNum = Integer.toString(arrayConverter);


            for(i = 0; i < 4; i++)
                arrayConverter = array[i]+ + (arrayConverter * 10);

            String encryptedNum = Integer.toString(arrayConverter);

            if(array[0] == 0)
                encryptedNum = "0" + encryptedNum;

            //System.out.println(encryptedNum);
            return encryptedNum;
        }
}
