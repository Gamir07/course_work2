package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {
    private final QuestionService service;

    public JavaController(QuestionService service) {
        this.service = service;
    }
    @PostMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer){
        return service.add(question,answer);
    }
    @GetMapping
    public Collection<Question> getQuestions(){
        return service.getAll();
    }
    @DeleteMapping("/delete")
    public Question removeCompletelyQuestion(@RequestParam String question, @RequestParam String answer){
        return service.remove(new Question(question,answer));
    }
}
