package org.example;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.example.Attriibutes.*;

public class LetterImporter implements Importer {

    private static final String NAME_PREFIX = "Dear ";
    private static final String AMOUNT_PREFIX = "Amount:";
    @Override
    public Document importFile (final File file) throws IOException {
        final TextFile textFile = new TextFile(file);
        textFile.addLineSuffix(NAME_PREFIX, PATIENT);

        final int lineNumber = textFile.addLines(2, String::isEmpty,ADDRESS);
        textFile.addLines(lineNumber + 1, (line) -> line.startsWith("regards,"), BODY);
        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE, "LETTER");
        return  new Document(attributes);
    }
}
