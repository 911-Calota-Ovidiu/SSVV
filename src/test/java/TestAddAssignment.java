import org.example.console.UI;
import org.example.repository.NotaXMLRepository;
import org.example.repository.StudentXMLRepository;
import org.example.repository.TemaXMLRepository;
import org.example.service.Service;
import org.example.validation.NotaValidator;
import org.example.validation.StudentValidator;
import org.example.validation.TemaValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAddAssignment {
    private Service service;

    @BeforeEach
    void setUp() {
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        NotaValidator notaValidator = new NotaValidator();
        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studentitest.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "temetest.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "notetest.xml");
        service = new Service(fileRepository1, fileRepository2, fileRepository3);
        UI console = new UI(service);
    }

    @Test
    void testAddValidAssignment(){
        int result = service.saveTema("1", "Description", 14, 1);
        Assertions.assertEquals(result,0);
    }

    @Test
    void testAddInvalidAssignment(){
        int result = service.saveTema("1", null, 14, 1);
        Assertions.assertEquals(result,1);
    }
}
