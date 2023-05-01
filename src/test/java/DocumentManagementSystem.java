import org.example.Attriibutes;
import org.example.Document;
import org.example.DocumentManagementSystem;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matcher.*;

import java.io.File;
import java.util.List;


public class DocumentManagementSystemTest {
    private static final String RESOURCES =
            "src" + File.separator + "test" + File.separator + "resources" + File.separator;
    private static final String LETTER = RESOURCES + "patient.letter";
    private static final String REPORT = RESOURCES + "patient.report";
    private static final String XRAY = RESOURCES + "xray.jpg";
    private static final String INVOICE = RESOURCES + "patient.invoice";
    private static final String JOE_BLOGGS = "Joe Bloggs";
    private DocumentManagementSystem system = new DocumentManagementSystem();

    @Test
    public void shouldImportFile() throws Exception{
        system.importFile(LETTER);
        final Document document = onlyDocument();
        assertAttributeEquals(document, Attriibutes.PATH, LETTER);
    }


    private Document onlyDocument(){
        final List<Document> documents = system.contents();
        assertThat(documents, hasSize(1));
        return documents.get(0);
    }


}
