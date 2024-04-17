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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestApplication {
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
        int result = service.saveTema("25", "Description of a valid tema(for testing purposes only, studends ignore)", 6, 1);
        assertEquals(result,0);
    }

    @Test
    void testAddValidStudent() {
        int result = service.saveStudent("12345", "Joseph", 931);
        assertEquals(0, result);
    }

    @Test
    void testAddValidGrade() {
        int result = service.saveNota("12345", "25", 9.0, 7, "Slab frate, mai invata");
        assertEquals(0, result);
    }

    @Test
    void testApplication(){
        int result1 = service.saveTema("23", "Description of a valid tema(for testing purposes only, studends ignore)", 6, 1);
        int result2 = service.saveStudent("69", "Joseph", 931);
        int result3 = service.saveNota("69", "23", 9.0, 4, "Slab frate, mai invata");
        assertEquals(0,result1);
        assertEquals(0,result2);
        assertEquals(0,result3);
    }
}
