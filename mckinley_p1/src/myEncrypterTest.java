import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class myEncrypterTest
{
    @Test
    void testEncrypt1234to0189()
        {
            String encrypt;
            Encrypter e = new Encrypter();
            assertEquals("1290", e.encrypt("2345"));
        }
}