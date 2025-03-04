package rest.service;

import rest.model.Student;
import rest.repository.StudentDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentDao studentDao;

  @Override
  public List<Student> getAll() {
    return studentDao.getAll();
  }

  @Override
  public Student getById(final long id) {
    return studentDao.getById(id);
  }

  @Override
  public long createStudent(final Student student) {
    return studentDao.createStudent(student);
  }

  @Override
  public long updateStudent(final Student student) {
    return studentDao.updateStudent(student);
  }

  @Override
  public long deleteStudentById(final long id) {
    return studentDao.deleteStudentById(id);
  }
}
