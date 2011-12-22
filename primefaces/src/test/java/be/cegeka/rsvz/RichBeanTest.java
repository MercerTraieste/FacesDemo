package be.cegeka.rsvz;

import junit.framework.Assert;
import org.junit.Test;

public class RichBeanTest {
    @Test
    public void completeShouldReturnAllCitiesWithEmptyString() throws Exception {
        Assert.assertEquals(4, new RichBean().completeCity("").size());
    }

    @Test
    public void completeShouldReturnSomeCitiesWithTheCitiesFirstCharacters() throws Exception {
        Assert.assertEquals(2, new RichBean().completeCity("b").size());
    }
}
