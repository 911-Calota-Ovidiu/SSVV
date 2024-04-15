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
    }

    @Test
    void testAddValidAssignment(){
        int result = service.saveTema("1", "Description of a valid tema(for testing purposes only, studends ignore)", 14, 1);
        Assertions.assertEquals(result,0);
    }

    @Test
    void testAddInvalidIdAssignment1(){
        int result = service.saveTema("", "Description", 14, 1);
        Assertions.assertEquals(result,1);
    }
    @Test
    void testAddInvalidIdAssignment2(){
        int result = service.saveTema(null, "Description", 14, 1);
        Assertions.assertEquals(result,1);
    }
    @Test
    void testAddInvalidDescriptionAssignment1(){
        int result = service.saveTema("2", "", 14, 1);
        Assertions.assertEquals(result,1);
    }

    @Test
    void testAddInvalidDescriptionAssignment2(){
        int result = service.saveTema("3", null, 14, 1);
        Assertions.assertEquals(result,1);
    }

    @Test
    void testAddInvalidStartlineAssignment1(){
        int result = service.saveTema("4", "Description", 14, 0);
        Assertions.assertEquals(result,1);
    }

    @Test
    void testAddInvalidStartlineAssignment2(){
        int result = service.saveTema("5", "Description", 4, 123);
        Assertions.assertEquals(result,1);
    }

    @Test
    void testAddInvalidStartlineAssignment3(){
        int result = service.saveTema("6", "Description", 2, 3);
        Assertions.assertEquals(result,1);
    }

    @Test
    void testAddInvalidDeadlineAssignment1(){
        int result = service.saveTema("7", "Description", 0, 3);
        Assertions.assertEquals(result,1);
    }

    @Test
    void testAddInvalidDeadlineAssignment2(){
        int result = service.saveTema("8", "Description", 15, 3);
        Assertions.assertEquals(result,1);
    }

    @Test
    void testAddInvalidDeadlineAssignment3(){
        int result = service.saveTema("9", "Description", 2, 3);
        Assertions.assertEquals(result,1);
    }
}
