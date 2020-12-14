package by.devincubator.controller.admin;

import by.devincubator.entity.Topic;
import by.devincubator.service.TestService;
import by.devincubator.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/admin")
public class CreateTopicAndTestPage {

    @Autowired
    TopicService topicService;

    @Autowired
    TestService testService;

    @GetMapping(value = "/createTopicAndTest")
    public String showPage(Model model) {
        model.addAttribute("topicList", topicService.getAll());
        return "admin/createTopicAndTest";
    }

    @GetMapping(value = "/selectedTopic")
    @ResponseBody
    public String getDescription(@RequestParam(value = "topic", required = false) String topicName) {
        Optional<Topic> topic = topicService.getByName(topicName);
        String description = "";
        if (topic.isPresent()) {
            description = topic.get().getDescription();
        }
        return description;
    }

    @PostMapping(value = "/createTopicAndTest")
    public String createTopicAndTest(@RequestParam String topicName,
                                     @RequestParam String topicDescription,
                                     @RequestParam String newTestName,
                                     @RequestParam String newTestDescription,
                                     Model model) {

        Optional<Topic> topicOptional = topicService.getByName(topicName);
        Topic topic = topicOptional.orElseGet(() -> topicService.save(topicName, topicDescription));
        if (newTestName.equals("") & newTestDescription.equals("")) {
            model.addAttribute("result", "Топик '" + topicName + "' создан");
        } else if (newTestName.equals("") | newTestDescription.equals("")) {
            model.addAttribute("result", "Не заполнено поле с именем теста или c описапнием теста");
        } else {
            testService.save(newTestName, newTestDescription, topic);
            model.addAttribute("result", "Тест '" + newTestName + "' создан");
        }
        return "admin/resultPage";
    }
}
