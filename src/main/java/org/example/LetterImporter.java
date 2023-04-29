package org.example;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;

import static org.example.Attriibutes.*;

public class LetterImporter implements Importer {

    private static final String NAME_PREFIX = "Dear ";
    private static final String AMOUNT_PREFIX = "Amount:";
    @Override
    public Document importFile (final File file) throws IOException {
        final TextFile textFile = new TextFile(file);
        textFile.addLineSuffix(NAME_PREFIX, PATIENT);

        final int lineNumber = textFile.addLineSuffix();

    }
}
