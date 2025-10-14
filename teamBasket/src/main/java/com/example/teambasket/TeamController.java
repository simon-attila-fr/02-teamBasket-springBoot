package com.example.teambasket;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    private static final String template = "%s Basket Club";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/team")
    public BasketTeam basketTeam(@RequestParam(defaultValue="No Name") String teamName) {
        return new BasketTeam(counter.incrementAndGet(), String.format(template, teamName));
    }

}
