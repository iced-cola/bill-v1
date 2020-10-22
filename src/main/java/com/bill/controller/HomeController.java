package com.bill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-21-2020 23:12:52
 * @description :  home controller
 * @since :  v1.0
 */
@RequestMapping("/")
@Controller
public class HomeController {

    @GetMapping("/")
    public String forward() {
        return "forward:/bill/list";
    }
}
