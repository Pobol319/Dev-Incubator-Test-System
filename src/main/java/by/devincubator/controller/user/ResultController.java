package by.devincubator.controller.user;

import by.devincubator.controller.LoginController;
import by.devincubator.entity.*;
import by.devincubator.service.StatisticService;
import by.devincubator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/user")
public class ResultController {

    @Autowired
    StatisticService statisticService;

    @Autowired
    UserService userService;


    @GetMapping(value = "/result")
    public String resultPage(Model model, HttpSession session){

        Date firstAnswer = (Date) session.getAttribute("firstAnswer");
        session.removeAttribute("firstAnswer");
        Date lastAnswer = new Date();

        User user = userService.getByLogin(LoginController.getPrincipal());

        List<Statistic> statList = statisticService.getUserResultStatistic(user.getUserId(), firstAnswer, lastAnswer);
        double percentOfRightAnswer = statisticService.getPercentOfRightAnswerUserInTest(user.getUserId(), firstAnswer, lastAnswer);

        List<UserResultModel> userResultModelList = new ArrayList<>();

        for (Statistic statistic : statList){

            String description = statistic.getQuestion().getDescription();
            StringBuilder isCorrect = new StringBuilder();
            for (Answer answer : statistic.getQuestion().getCorrectAnswers()){
                isCorrect.append(answer.getDescription() + "\n");
            }

            List<String> literatureList = new ArrayList<>() ;
            List<String> linkList = new ArrayList<>() ;

            for (Literature literature : statistic.getQuestion().getLiteratureSet()){
                literatureList.add(literature.getDescription());
                linkList.add(literature.getLink().getLink());
            }


            userResultModelList.add(new UserResultModel(description, isCorrect.toString(), literatureList, linkList));
        }


        model.addAttribute("userResultModelList", userResultModelList);
        model.addAttribute("percentOfRightAnswer", percentOfRightAnswer);



        return "user/result";
    }

}
