import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class myEncrypterTest
{
    @Test
    void testEncrypt0189to1234()
    {
        Encrypter e = new Encrypter();
        assertEquals("0000", e.encrypt("3333"));
    }

}