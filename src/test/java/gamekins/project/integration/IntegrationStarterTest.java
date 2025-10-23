package gamekins.project.integration;

import gamekins.project.domain.Course;
import gamekins.project.domain.dto.SubjectDTO;
import gamekins.project.repository.CourseRepository;
import gamekins.project.service.SubjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
public class IntegrationStarterTest extends MySQLTestContainer {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void createIntegrationTestHere() {
        Course course = new Course();
        course.setName("Test Course");
        course.setCode("TC-01");
        course = courseRepository.save(course);

        SubjectDTO dto = new SubjectDTO();
        dto.setName("Test Subject");
        dto.setCode("TS-INT-01");
        dto.setCourseId(course.getId());

        var created = subjectService.create(dto);

        assertNotNull(created);
        assertEquals("Test Subject", created.getName());
    }
}