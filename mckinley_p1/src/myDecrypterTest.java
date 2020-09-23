import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class myDecrypterTest
{
    @Test
    void testDecrypt0189to1234()
        {
            Decrypter e = new Decrypter();
            assertEquals("0000", e.decrypt("7777"));
        }

}
