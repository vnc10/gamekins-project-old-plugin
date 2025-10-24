package gamekins.project.mapper;

import gamekins.project.domain.Course;
import gamekins.project.domain.Subject;
import gamekins.project.domain.dto.SubjectDTO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SubjectMapperTest {

    @Test
    void shouldCorrectlyMapSubjecEntityToSubjectDTO() {

        Subject subjectEntity = new Subject();
        subjectEntity.setId(1L);
        subjectEntity.setName("Programação");
        subjectEntity.setCode("PRG-101");
        Course course = new Course();
        course.setId(3L);
        subjectEntity.setCourse(course);

        SubjectDTO resultDTO = SubjectMapper.toDTO(subjectEntity);

        assertNotNull(resultDTO);
        assertEquals(subjectEntity.getId(), resultDTO.getId());
        assertEquals(subjectEntity.getName(), resultDTO.getName());
        assertEquals(subjectEntity.getCode(), resultDTO.getCode());
        assertEquals(subjectEntity.getCourse().getId(), resultDTO.getCourseId());
    }

}
