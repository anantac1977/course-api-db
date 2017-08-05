package io.springboot.starter.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.starter.course.Course;
import io.springboot.starter.topic.Topic;

@RestController
public class LessonController {

	@Autowired
	private LessonService service;

	@RequestMapping("/topics/{id}/courses/{courseId}/lessons")
	public List<Lesson> getAllLessons(@PathVariable String courseId) {

		return service.getAllLessons(courseId);
	}

	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public Lesson getLesson(@PathVariable String lessonId) {
		return service.getLesson(lessonId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/{courseId}/lessons")
	public void addLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId) {
		lesson.setCourse(new Course(courseId, "", "",topicId));
		service.addLesson(lesson);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void updateLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId, @PathVariable String id) {

		lesson.setCourse(new Course(courseId, "", "",topicId));
		service.updateLesson(lesson);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void deleteLesson(@PathVariable String id) {

		service.deleteLesson(id);
	}
}
