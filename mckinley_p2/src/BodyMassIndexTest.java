import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BodyMassIndexTest
    {
        @Test
        void testBmiCalculatorMethod()
        {
            BodyMassIndex bmi = new BodyMassIndex(60, 126);
            assertEquals(24.61, bmi.bmiMath(60, 126));
        }
        @Test
        void testCategorizeMethod()

        {
            BodyMassIndex cat = new BodyMassIndex(76, 250);
            assertEquals("Underweight", cat.Categorize(17));
        }
        @Test
        void testCategory1()

        {
            BodyMassIndex cat1 = new BodyMassIndex(76, 250);
            assertEquals("Underweight", cat1.Categorize(18.4));
        }
        @Test
        void testCategory2()

        {
            BodyMassIndex cat2 = new BodyMassIndex(76, 250);
            assertEquals("Normal weight", cat2.Categorize(18.5));
        }
        @Test
        void testCategory3()

        {
            BodyMassIndex cat3 = new BodyMassIndex(76, 250);
            assertEquals("Overweight", cat3.Categorize(25));
        }
        @Test
        void testCategory4()

        {
            BodyMassIndex cat = new BodyMassIndex(76, 250);
            assertEquals("Obesity", cat.Categorize(30));
        }
    }


