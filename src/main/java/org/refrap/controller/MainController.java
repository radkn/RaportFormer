package org.refrap.controller;

import org.refrap.service.ILineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private ILineService lineService;

    @GetMapping("/")
    public String home(Model model){
        String homePageMsg = "There will be authorization!";
        model.addAttribute("homeMsg", homePageMsg);

        return "/index";
    }

    @GetMapping("/scenes")
    public String scene(Model model){

        model.addAttribute("scenes", lineService.getAllSceneId());

        return "/sceneSelect";
    }

    @GetMapping("/lines")
    public String line(@RequestParam(value = "scene") String scene, Model model){
        model.addAttribute("lines", lineService.getLineBySceneid(scene));
        model.addAttribute("dates", lineService.getAllData());
        return "/testLineGetter";
    }

    @PostMapping("/lines/bytitledate")
    public String getLineByTitleAndDate(Model model,
                                        @RequestParam("lineTitle") String lineTitle,
                                        @RequestParam("status") String status,
                                        @RequestParam("date") String date,
                                        @RequestParam("timeStart") String timeStart,
                                        @RequestParam("timeEnd") String timeEnd){

        model.addAttribute("lines", lineService.getAllLineName());
        model.addAttribute("dates", lineService.getAllData());
        model.addAttribute("count", lineService.getCountByTitleAndDate(lineTitle, date,
                Integer.parseInt(timeStart), Integer.parseInt(timeEnd), status));

        return "/linesList";
    }


}
