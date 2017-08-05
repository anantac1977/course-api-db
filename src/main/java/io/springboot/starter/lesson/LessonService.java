package io.springboot.starter.lesson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

	@Autowired
	private LessonRepository repository;
		
	public List<Lesson> getAllLessons(String courseId){
		List<Lesson> lessonList = new ArrayList<>();
		repository.findByCourseId(courseId).forEach(lessonList::add);
		
		return lessonList;
	}
	
	public Lesson getLesson(String id){
		return repository.findOne(id);
	}

	public void addLesson(Lesson lesson) {
		repository.save(lesson);
		
	}

	public void updateLesson(Lesson lesson) {
		repository.save(lesson);
	}

	public void deleteLesson(String id) {
		repository.delete(id);
	}
}
