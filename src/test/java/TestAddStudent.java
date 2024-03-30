import junit.framework.*;
import org.example.console.UI;
import org.example.repository.NotaXMLRepository;
import org.example.repository.StudentXMLRepository;
import org.example.repository.TemaXMLRepository;
import org.example.service.Service;
import org.example.validation.NotaValidator;
import org.example.validation.StudentValidator;
import org.example.validation.TemaValidator;

public class TestAddStudent extends TestCase {
    protected Service service;
    protected StudentValidator studentValidator;
    protected TemaValidator temaValidator;
    protected NotaValidator notaValidator;
    protected StudentXMLRepository fileRepository1;
    protected TemaXMLRepository fileRepository2;
    protected NotaXMLRepository fileRepository3;
    protected UI console;

    protected void setUp() {
        studentValidator = new StudentValidator();
        temaValidator = new TemaValidator();
        notaValidator = new NotaValidator();
        fileRepository1 = new StudentXMLRepository(studentValidator, "studentitest.xml");
        fileRepository2 = new TemaXMLRepository(temaValidator, "temetest.xml");
        fileRepository3 = new NotaXMLRepository(notaValidator, "notetest.xml");
        service = new Service(fileRepository1, fileRepository2, fileRepository3);
        console= new UI(service);
    }
    //EC #1
    //Condition: Id not empty

    //Valid id
    public void testAddValidId() {
        int result = service.saveStudent("1", "Joseph", 931);
        assertEquals(0, result);
    }

    //Id is null
    public void testAddNullId() {
        int result = service.saveStudent(null, "Jack", 931);
        assertEquals(1, result);;
    }

    //Id is empty string
    public void testAddEmptyId() {
        int result = service.saveStudent("", "James", 931);
        assertEquals(1, result);
    }

    //EC #2
    //Condition: Name not empty

    //Valid name
    public void testAddValidName() {
        int result = service.saveStudent("2", "Jill", 931);
        assertEquals(0, result);
    }

    //Name is null
    public void testAddNullName() {
        int result = service.saveStudent("3", null, 931);
        assertEquals(1, result);
    }

    //Name is empty string
    public void testAddEmptyName() {
        int result = service.saveStudent("4", "", 931);
        assertEquals(1, result);
    }

    //EC #3
    //Condition: 110 < group < 938

    //Valid group
    public void testAddValidGroup1() {
        int result = service.saveStudent("5", "Josh", 111);
        assertEquals(0, result);
    }

    //Valid group
    public void testAddValidGroup2() {
        int result = service.saveStudent("6", "Jeremy", 937);
        assertEquals(0, result);
    }

    //Group is 110
    public void testAddNullGroup() {
        int result = service.saveStudent("7", "Jake", 110);
        assertEquals(1, result);
    }

    //Group is 938
    public void testAddEmptyGroup() {
        int result = service.saveStudent("8", "Jaeger", 938);
        assertEquals(1, result);
    }
}
