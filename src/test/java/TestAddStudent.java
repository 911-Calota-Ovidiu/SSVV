import org.example.console.UI;
import org.example.repository.NotaXMLRepository;
import org.example.repository.StudentXMLRepository;
import org.example.repository.TemaXMLRepository;
import org.example.service.Service;
import org.example.validation.NotaValidator;
import org.example.validation.StudentValidator;
import org.example.validation.TemaValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestAddStudent {
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
    void testAddValidId() {
        int result = service.saveStudent("1", "Joseph", 931);
        assertEquals(0, result);
    }

    @Test
    void testAddNullId() {
        int result = service.saveStudent(null, "Jack", 931);
        assertEquals(1, result);
    }

    @Test
    void testAddEmptyId() {
        int result = service.saveStudent("", "James", 931);
        assertEquals(1, result);
    }

    @Test
    void testAddValidName() {
        int result = service.saveStudent("2", "Jill", 931);
        assertEquals(0, result);
    }

    @Test
    void testAddNullName() {
        int result = service.saveStudent("3", null, 931);
        assertEquals(1, result);
    }

    @Test
    void testAddEmptyName() {
        int result = service.saveStudent("4", "", 931);
        assertEquals(1, result);
    }

    @Test
    void testAddValidGroup1() {
        int result = service.saveStudent("5", "Josh", 111);
        assertEquals(0, result);
    }

    @Test
    void testAddValidGroup2() {
        int result = service.saveStudent("6", "Jeremy", 939);
        assertEquals(0, result);
    }

    @Test
    void testAddInvalidGroup0() {
        int result = service.saveStudent("7", "Jake", 110);
        assertEquals(1, result);
    }

    @Test
    void testAddInvalidGroup1() {
        int result = service.saveStudent("8", "Jaeger", 941);
        assertEquals(1, result);
    }

    @Test
    void testAddInvalidGroup2() {
        int result = service.saveStudent("9", "Jolyne", 21);
        assertEquals(1, result);
    }

    @Test
    void testAddInvalidGroup3() {
        int result = service.saveStudent("10", "Jamison", 201);
        assertEquals(1, result);
    }

    @Test
    void testAddInvalidGroup4() {
        int result = service.saveStudent("11", "Jordan", 210);
        assertEquals(1, result);
    }

    @Test
    void testAddInvalidGroup5() {
        int result = service.saveStudent("12", "Jasmine", 241);
        assertEquals(1, result);
    }
}
