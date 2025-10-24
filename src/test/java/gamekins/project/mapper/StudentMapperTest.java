package gamekins.project.mapper;

import gamekins.project.domain.Course;
import gamekins.project.domain.Student;
import gamekins.project.domain.dto.StudentDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StudentMapperTest {

    @Test
    void shouldCorrectlyMapStudentEntityToStudentDTO() {

        Student studentEntity = new Student();
        studentEntity.setId(1L);
        studentEntity.setName("João Silva");
        studentEntity.setRaNumber("RA123456");
        Course course = new Course();
        course.setId(2L);
        studentEntity.setCourse(course);

        StudentDTO resultDTO = StudentMapper.toDTO(studentEntity);

        assertNotNull(resultDTO);
        assertEquals(studentEntity.getId(), resultDTO.getId());
        assertEquals(studentEntity.getName(), resultDTO.getName());
        assertEquals(studentEntity.getRaNumber(), resultDTO.getRaNumber());
        assertEquals(studentEntity.getCourse().getId(), resultDTO.getCourseId());
    }

}
