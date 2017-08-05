package io.springboot.starter.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository repository;
		
	public List<Course> getAllCourses(String topicId){
		List<Course> courseList = new ArrayList<>();
		repository.findByTopicId(topicId).forEach(courseList::add);
		
		return courseList;
	}
	
	public Course getCourse(String id){
		return repository.findOne(id);
	}

	public void addCourse(Course course) {
		repository.save(course);
		
	}

	public void updateCourse(Course course) {
		repository.save(course);
	}

	public void deleteCourse(String id) {
		repository.delete(id);
	}
}
