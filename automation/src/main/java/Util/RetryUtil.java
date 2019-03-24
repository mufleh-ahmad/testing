package Util;

import com.google.common.base.Stopwatch;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import gherkin.lexer.Th;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Created by Mufleh on 24/03/2019.
 */
public class RetryUtil {

    protected void doWithRetry(String msg, Supplier<Boolean> test){
        Stopwatch stopwatch = Stopwatch.createStarted();

        if (!getValueWithRetry(() -> test.get() ? Optional.of(true) : Optional.empty()).orElse(false)){
            Assert.fail(msg + " failed after" + stopwatch.elapsed(TimeUnit.SECONDS) + "seconds");
        }
    }

    protected <T>Optional<T> getValueWithRetry(Supplier<Optional<T>> supplier){
        return getValuesWithRetry(() -> {
            return supplier.get().map(Collections :: singleton).orElse(Collections.emptySet());
        }).stream().findFirst();
    }

    protected <T> Collection<T> getValuesWithRetry(Supplier<? extends Collection<T>> supplier){
        for (int numTries = 0; numTries < 100; numTries++) {
            Collection<T> result = supplier.get();

            if (result.isEmpty()){
                try {
                    Thread.sleep(1000L + (numTries*100));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    Assert.fail("Interrupted");
                    return Collections.emptySet();
                }
            } else {
                return result;
            }
        }
        return Collections.emptySet();
    }
}
