package com.shine.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hq on 2016/11/11.
 */
@Controller
public class GameController {

    @RequestMapping(value ="/gogame")
    public ModelAndView getGame(){
        ModelAndView modelAndView = new ModelAndView("game/index.html");

        return modelAndView;
    }

}
