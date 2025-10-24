package gamekins.project.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import gamekins.project.domain.Enrollment;
import gamekins.project.domain.Student;
import gamekins.project.domain.Subject;
import gamekins.project.domain.dto.EnrollmentDTO;

public class EnrollmentMapTest {
    
    @Test
    void shouldCorrectlyMapEnrrolmentEntityToEnrrolmentDTO() {
        Enrollment enrollmentEntity = new Enrollment();
        enrollmentEntity.setId(1L);
        enrollmentEntity.setStatus("Enrolled");
        Student student = new Student();
        student.setId(4L);
        enrollmentEntity.setStudent(student);
        Subject subject = new Subject();
        subject.setId(5L);
        enrollmentEntity.setSubject(subject);

        EnrollmentDTO resultDTO = EnrollmentMapper.toDTO(enrollmentEntity);

        assertNotNull(resultDTO);
        assertEquals(enrollmentEntity.getId(), resultDTO.getId());
        assertEquals(enrollmentEntity.getStatus(), resultDTO.getStatus());
        assertEquals(enrollmentEntity.getStudent().getId(), resultDTO.getStudentId());
        assertEquals(enrollmentEntity.getSubject().getId(), resultDTO.getSubjectId());
       
    }
}
