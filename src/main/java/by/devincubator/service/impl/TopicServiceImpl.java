package by.devincubator.service.impl;

import by.devincubator.entity.Topic;
import by.devincubator.repository.TopicRepository;
import by.devincubator.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<Topic> getAll() {
        return topicRepository.findAll();
    }

    @Override
    public Topic getTestByTopicId(int id) {
        return topicRepository.findByTopicId(id);
    }

    @Override
    public List<String> getAllNames() {
        List<Topic> topics = topicRepository.findAll();
        List<String> names = new ArrayList<>();
        topics.forEach(t -> names.add(t.getName()));
        return names;
    }

    @Override
    public Optional<Topic> getByName(String name) {
        return topicRepository.findByName(name);
    }

    @Override
    public Topic save(String name, String description) {
        Topic topic = new Topic();
        topic.setName(name);
        topic.setDescription(description);
        return topicRepository.save(topic);
    }
}
