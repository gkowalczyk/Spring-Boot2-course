package com.example.springboot2course.catApi;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class CatController {

    public CatController() {
        RestTemplate restTemplate = new RestTemplate();

        String forObject = restTemplate.getForObject("https://api.trello.com/1/boards/61e5c2abc318827c477aec96?fields=name&lists=all&list_fields=id,name,closed,pos,softLimit,idBoard,subscribed&key=69c064e094808a0e085f9cd217e7ab90&token=bc86958ffff01c0f455718852169cdc35b7fdc0f2ba2de585309240cd2dfa095", String.class);
        System.out.println(forObject);
    }
}
