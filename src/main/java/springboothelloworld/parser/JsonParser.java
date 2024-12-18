package springboothelloworld.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public abstract class JsonParser<T> implements Function<InputStream, T> {

    private final ObjectMapper objectMapper;
    private final Class<T> clazz;

    @Override
    @SneakyThrows
    public T apply(InputStream inputStream) {
        return objectMapper.readValue(inputStream, clazz);
    }
}
