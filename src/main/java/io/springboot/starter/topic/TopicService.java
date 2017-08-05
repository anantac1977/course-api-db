package io.springboot.starter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository repository;
		
	public List<Topic> getAllTopics(){
		List<Topic> topicList = new ArrayList<>();
		repository.findAll().forEach(topicList::add);
		
		return topicList;
	}
	
	public Topic getTopic(String id){
		return repository.findOne(id);
	}

	public void addTopic(Topic topic) {
		repository.save(topic);
		
	}

	public void updateTopic(Topic topic) {
		repository.save(topic);
	}

	public void deleteTopic(String id) {
		repository.delete(id);
	}
}
