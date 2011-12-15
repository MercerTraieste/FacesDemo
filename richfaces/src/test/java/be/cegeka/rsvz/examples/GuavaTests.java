package be.cegeka.rsvz.examples;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class GuavaTests {

    @Test
    public void sortedStringList() {
        List<String> localeCodes = Arrays.asList("nl", "en_GB", "en");
        System.out.println(Ordering.from(String.CASE_INSENSITIVE_ORDER).immutableSortedCopy(localeCodes));
    }

    @Test
    public void sortedLocaleList() {
        List<Locale> locales = Arrays.asList(new Locale("nl"), new Locale("en", "GB"), new Locale("fr"));
        Function<Locale, String> getNameFunction = new Function<Locale, String>() {
            public String apply(Locale from) {
                return from.toString();
            }
        };

        Ordering<Locale> nameOrdering = Ordering.natural().onResultOf(getNameFunction);

        ImmutableSortedSet<Locale> sortedLocales = ImmutableSortedSet.orderedBy(
                nameOrdering).addAll(locales).build();
        System.out.println(sortedLocales);


    }
}
