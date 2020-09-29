import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BodyMassIndexTest
    {
        @Test
        void testBmiCalculatorMethod()
        {
            BodyMassIndex bmi = new BodyMassIndex(76, 200);
            assertEquals(24.34, bmi.bmiMath(76, 200));
        }
        @Test
        void testCategorizeMethod()

        {
            BodyMassIndex cat = new BodyMassIndex(76, 100);
            assertEquals("Underweight", cat.Categorize(cat.bmi));
        }
        @Test
        void testCategory1()

        {
            BodyMassIndex cat1 = new BodyMassIndex(76, 100);
            assertEquals("Underweight", cat1.Categorize(cat1.bmi));
        }
        @Test
        void testCategory2()

        {
            BodyMassIndex cat2 = new BodyMassIndex(76, 200);
            assertEquals("Normal weight", cat2.Categorize(cat2.bmi));
        }
        @Test
        void testCategory3()

        {
            BodyMassIndex cat3 = new BodyMassIndex(76, 240);
            assertEquals("Overweight", cat3.Categorize(cat3.bmi));
        }
        @Test
        void testCategory4()

        {
            BodyMassIndex cat4 = new BodyMassIndex(76, 250);
            assertEquals("Obesity", cat4.Categorize(cat4.bmi));
        }
    }


