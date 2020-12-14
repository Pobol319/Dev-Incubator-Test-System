package by.devincubator.service;

import by.devincubator.entity.Topic;

import java.util.List;
import java.util.Optional;

public interface TopicService {

    List<Topic> getAll();

    Topic getTestByTopicId(int id);

    List<String> getAllNames();

    Optional<Topic> getByName(String name);

    Topic save(String name, String description);
}
