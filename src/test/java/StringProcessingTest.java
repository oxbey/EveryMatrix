import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class StringProcessingTest {

    StringProcessing process = new StringProcessing();

    @Test
    public void processingTest(){
        List<String> values = process.strings;
        Assertions.assertEquals(values.get(1).concat(values.get(3)), process.processing(values,2));
    }


}