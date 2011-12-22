package be.cegeka.rsvz.validator;

import junit.framework.Assert;
import org.junit.Test;

public class InszConstraintValidatorTest {
    @Test
    public void testIsValid() throws Exception {
        Assert.assertTrue(new InszConstraintValidator().isValid("113322", null));
    }
}
