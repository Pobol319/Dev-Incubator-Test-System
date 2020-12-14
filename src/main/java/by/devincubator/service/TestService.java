package by.devincubator.service;

import by.devincubator.entity.Question;
import by.devincubator.entity.Test;

import java.util.List;
import java.util.Set;

import by.devincubator.entity.Topic;
import by.devincubator.entity.view.TestStatistic;

public interface TestService {

    Test findByTestId(int testId);

    List<String> getAllNames();

    Double getPercentageOfCorrectAnswersToTest(Integer id);

    Integer getHowManyTimesTestWasPassed(Integer id);

    List<TestStatistic> getTestStatisticList();

    void save(String name, String description, Topic topic);
}
