package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
@RequestMapping(value = "events")
public class EventsController {

    private static ArrayList<String> events = new ArrayList<>();

    // Lives at /events
    @GetMapping("")
    public String displayAllEvents(Model model) {

        model.addAttribute("events", events);
        model.addAttribute("title", "All Events");

        return "events/index";
    }

    // lives at /events/create
    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create New Event");
        return "events/create";
    }

    // lives at /events/create
    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String event) {
        events.add(event);
        return "redirect:";
    }


}
