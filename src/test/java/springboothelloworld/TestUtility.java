package springboothelloworld;

import java.io.InputStream;
import java.util.function.Function;

public enum TestUtility {;
    public static <T> T safeLoad(String resource, Function<InputStream, T> fn) {
        try (InputStream is = TestUtility.class.getResourceAsStream(resource)) {
            return fn.apply(is);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
