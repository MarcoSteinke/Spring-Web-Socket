package spring.websocket.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.websocket.demo.model.StreamLink;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DefaultStreamLinksConfiguration {

    // List of StreamLink's, which the WebSocketDemoController will be instantiated with
    @Bean
    public List<StreamLink> returnSomeStreamLinks() {
        return new ArrayList<>(
                List.of(
                    new StreamLink("Niloc", "https://www.twitch.tv/Niloc"),
                    new StreamLink("MontanaOnCrack", "https://www.twitch.tv/MontanaOnCrack"),
                    new StreamLink("bestboy93", "https://www.twitch.tv/bestboy93"),
                    new StreamLink("830to1230boy", "https://www.twitch.tv/830to1230boy")
                )
        );
    }
}
