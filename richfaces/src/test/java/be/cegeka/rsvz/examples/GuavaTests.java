package be.cegeka.rsvz.examples;

import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GuavaTests {

    @Test
    public void sortedList() {
        List<String> locales = Arrays.asList("aaa", "ccc", "bbb");
        System.out.println(Ordering.from(String.CASE_INSENSITIVE_ORDER).immutableSortedCopy(locales));
    }
}
