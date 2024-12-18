package springboothelloworld.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springboothelloworld.TestUtility;
import springboothelloworld.model.Agreement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgreementParserTest {

    private Agreement actual;

    @BeforeEach
    void setUp() {
        actual = TestUtility.safeLoad("/example.json", new AgreementParser());
    }

    @Test
    void testAgreementId(){
        assertEquals(123,actual.getAgreementId());
    }

    @Test
    void testReviewId(){
        assertEquals(3345678,actual.getAgreementReviewId());
    }

    @Test
    void testTitle(){
        assertEquals("testTitle",actual.getAgreementTitle());
    }

    @Test
    void testUserName(){
        assertEquals("Darren",actual.getUserName());
    }

    @Test
    void testUserAccount(){
        assertEquals("DarrenChang",actual.getUserAccount());
    }


}
