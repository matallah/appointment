package sbs.security;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class ErrorControllerImpl implements ErrorController {
    private final static String PATH = "/error";

    @Override
    @RequestMapping(PATH)
    public String getErrorPath() {
        return "404";
    }
}
