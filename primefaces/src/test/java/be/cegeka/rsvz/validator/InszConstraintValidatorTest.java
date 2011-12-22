package be.cegeka.rsvz.validator;

import junit.framework.Assert;
import org.junit.Test;

public class InszConstraintValidatorTest {
    @Test
    public void insqShouldBeValid() throws Exception {
        Assert.assertFalse(new InszConstraintValidator().isValid("113322", null));
        Assert.assertTrue(new InszConstraintValidator().isValid("11111111110", null));
    }
}
