package kz.roxy.tsoed.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDocToTsoed {

    private static final String template = "Hello, %s!";

    method=POST,
    @RequestMapping("/rs/")
    public Greeting docToTsoed(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
