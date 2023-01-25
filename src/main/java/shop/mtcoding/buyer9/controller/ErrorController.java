package shop.mtcoding.buyer9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/notfound")
    public String notfound() {
        return "notfound";
    }
}
