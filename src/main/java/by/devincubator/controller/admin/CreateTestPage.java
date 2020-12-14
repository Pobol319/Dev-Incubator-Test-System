package by.devincubator.controller.admin;

import by.devincubator.service.QuestionService;
import by.devincubator.service.TestService;
import by.devincubator.service.TestQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping(path = "/admin")
public class CreateTestPage {

    @Autowired
    private TestService testService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private TestQuestionService testQuestionService;

    @GetMapping(value = "/createTest")
    public String createTest(Model model) {
        model.addAttribute("tests", testService.getAllNames());
        model.addAttribute("questions", questionService.getAllDescriptions());
        return "admin/createTest";
    }

    @PostMapping(value = "/addNewTest")
    @ResponseBody
    public String addNewQuestion(
            @RequestParam(value = "test", required = false) String test,
            @RequestParam(value = "questions", required = false) String questions) throws UnsupportedEncodingException {

        String answer;
        if (!testQuestionService.isQuestionsDescriptionPresent(questions)) {
            answer = URLEncoder.encode("Вы не добавили вопросы", "UTF-8");
            return "/admin/resultPage?result=" + answer;
        } else {
            answer = URLEncoder.encode("Тест создан успешно", "UTF-8");
        }
        testQuestionService.saveTest( test, questions);

        return "/admin/resultPage?result=" + answer;
    }
}
