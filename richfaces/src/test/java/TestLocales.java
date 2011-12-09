import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;


public class TestLocales {
    
    @Test
    public void localesAreEqual() {
        Assert.assertFalse(new Locale("el").equals(new Locale("el", "GR")));
    }
}
