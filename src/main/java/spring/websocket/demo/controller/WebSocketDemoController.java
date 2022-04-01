package spring.websocket.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import spring.websocket.demo.model.StreamLink;

import java.util.List;

@Controller
public class WebSocketDemoController {

    private final List<StreamLink> links;
    private static String streamer;

    @ModelAttribute("links")
    public List<StreamLink> addLinks() {
        return this.links;
    }

    public WebSocketDemoController(List<StreamLink> links) {
        this.links = links;
        WebSocketDemoController.streamer = links.get(0).getName();
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("streamer", WebSocketDemoController.streamer);
        return "index";
    }

    // It is essential to add the "/" at the end of each string in the annotations
    // it will not work by using "/streamer" and "/main"
    @MessageMapping("/streamer/")
    @SendTo("/main/")
    public StreamLink sendLinks(@Payload StreamLink streamLink) {
        return streamLink;
    }
}
