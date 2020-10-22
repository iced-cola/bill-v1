package com.bill.controller;

import com.bill.form.SysInfo;
import com.bill.util.ResultUtil;
import com.bill.vo.ResultVO;
import org.springframework.boot.SpringBootVersion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-21-2020 18:08:47
 * @description :  获取系统信息api
 * @since :  v1.0
 */
@Controller
@RequestMapping("/sys")
public class SysInfoController {

    /**
     * 获取系统信息，包括：
     * 1. 操作系统版本         o
     * 3. 数据库版本           x
     * 4. Java版本            o
     * 5. SpringBoot版本      o
     * 6. Thymeleaf版本       x
     */
    @GetMapping("/info")
    public ModelAndView sysInfo() {
        Map<String, String> map = new HashMap<>();
        ModelAndView modelAndView = new ModelAndView();
        Properties properties = System.getProperties();
        SysInfo sysInfo = new SysInfo();
        sysInfo.setJavaVersion(properties.getProperty("java.version"));
        sysInfo.setOsVersion(properties.getProperty("os.version"));
        sysInfo.setSpringBootVersion(SpringBootVersion.getVersion());
        sysInfo.setMysqlVersion("MySQL 5.7.24");
        sysInfo.setThymeleafVersion("thymeleaf v2.3.4");
        modelAndView.addObject("sysInfo", sysInfo);
        modelAndView.setViewName("sys");
        return modelAndView;
    }

}
