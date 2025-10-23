package gamekins.project.unityTests;

import gamekins.project.domain.Course;
import gamekins.project.domain.Subject;
import gamekins.project.domain.dto.SubjectDTO;
import gamekins.project.repository.CourseRepository;
import gamekins.project.repository.SubjectRepository;
import gamekins.project.service.SubjectService;
import gamekins.project.mapper.SubjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SubjectServiceTest {

    @Mock
    private SubjectRepository subjectRepository;

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private SubjectService subjectService;

    @Test
    void create_shouldSaveAndReturnDto() {
        Course course = new Course();
        course.setId(1L);
        course.setName("Engenharia");
        course.setCode("ENG-01");

        SubjectDTO dto = new SubjectDTO();
        dto.setName("Test Subject");
        dto.setCode("TS-01");
        dto.setCourseId(1L);

        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        Subject saved = new Subject();
        saved.setId(10L);
        saved.setName(dto.getName());
        saved.setCode(dto.getCode());
        saved.setCourse(course);

        when(subjectRepository.save(any(Subject.class))).thenReturn(saved);

        var result = subjectService.create(dto);

        assertNotNull(result);
        assertEquals(10L, result.getId());
        assertEquals("Test Subject", result.getName());

        verify(courseRepository).findById(1L);
        verify(subjectRepository).save(any(Subject.class));
    }
}