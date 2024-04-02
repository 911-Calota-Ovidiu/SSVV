package org.example.validation;
import org.example.domain.Student;

public class StudentValidator implements Validator<Student> {
    public void validate(Student student) throws ValidationException {
        if (student.getID() == null || student.getID().equals("")) {
            throw new ValidationException("ID invalid! \n");
        }
        if (student.getNume() == null || student.getNume().equals("")) {
            throw new ValidationException("Nume invalid! \n");
        }
        if (student.getGrupa() < 111 || student.getGrupa() > 939 || student.getGrupa() % 10 == 0 || student.getGrupa() / 10 % 10 == 0 || student.getGrupa() / 10 % 10 > 3 || student.getGrupa() / 100 == 0) {
            throw new ValidationException("Grupa invalida! \n");
        }
    }
}

