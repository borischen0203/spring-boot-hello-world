package springboothelloworld.parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import springboothelloworld.model.Agreement;


public class AgreementParser extends JsonParser<Agreement> {
    public AgreementParser(ObjectMapper objectMapper) {
        super(objectMapper, Agreement.class);
    }

    public AgreementParser() {
        this(new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false));
    }
}

