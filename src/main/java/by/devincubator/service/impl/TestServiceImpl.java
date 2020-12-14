package by.devincubator.service.impl;

import by.devincubator.entity.Question;
import by.devincubator.entity.Test;
import by.devincubator.entity.Topic;
import by.devincubator.repository.QuestionRepository;
import by.devincubator.entity.view.TestStatistic;
import by.devincubator.repository.TestRepository;
import by.devincubator.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository repository;

    @Override
    public Test findByTestId(int testId) {
        return repository.findByTestId(testId);
    }

    @Override
    public List<String> getAllNames() {
        List<Test> tests = repository.findAll();
        List<String> names = new ArrayList<>();
        tests.forEach(t -> names.add(t.getName()));
        return names;
    }

    @Override
    public Double getPercentageOfCorrectAnswersToTest(Integer id) {
        return repository.getPercentageOfCorrectAnswersToTest(id);
    }

    @Override
    public Integer getHowManyTimesTestWasPassed(Integer id) {
        return repository.getHowManyTimesTestWasPassed(id);
    }

    @Override
    public List<TestStatistic> getTestStatisticList() {
        List<TestStatistic> testStatisticList = new ArrayList<>();
        List<Test> testList = repository.findAll();

        testList.forEach(t -> testStatisticList.add(new TestStatistic(
                t.getTestId(),
                t.getName(),
                repository.getHowManyTimesTestWasPassed(t.getTestId()),
                repository.getPercentageOfCorrectAnswersToTest(t.getTestId())
        )));

        return testStatisticList;
    }

    @Override
    public void save(String name, String description, Topic topic) {
        Test test = new Test();
        test.setName(name);
        test.setDescription(description);
        test.setTopic(topic);
        repository.save(test);
    }
}
