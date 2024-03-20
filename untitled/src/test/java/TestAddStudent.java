import junit.framework.*;
import org.example.repository.NotaXMLRepository;
import org.example.repository.StudentXMLRepository;
import org.example.repository.TemaXMLRepository;
import org.example.service.Service;
import org.example.validation.NotaValidator;
import org.example.validation.StudentValidator;
import org.example.validation.TemaValidator;

public class TestAddStudent extends TestCase{
    protected int grupa;
    protected String id1,nume,id2;
    protected Service service;
    protected StudentValidator studentValidator;
    protected TemaValidator temaValidator;
    protected NotaValidator notaValidator ;
    protected StudentXMLRepository fileRepository1;
    protected TemaXMLRepository fileRepository2;
    protected NotaXMLRepository fileRepository3 ;
    protected void setUp(){
        grupa=931;
        id1="1234";
        id2="";
        nume="Ion Cemaifaci";
        studentValidator = new StudentValidator();
        temaValidator = new TemaValidator();
        notaValidator = new NotaValidator();
        fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");
        service=new Service(fileRepository1,fileRepository2,fileRepository3);
    }
    public void testAdd(){
        int result=service.saveStudent(id1,nume,grupa);
        assertEquals(0, result);
    }
    public void testInvalidAdd(){
        int result=service.saveStudent(id2,nume,grupa);
        assertEquals(1, result);
    }
}
