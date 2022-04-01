package spring.websocket.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Add endpoint with URL for SockJS
        registry.addEndpoint("/mysocket").withSockJS();
    }

    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Name of the broker, which will be receiving the messages
        // Could be understood as a channel, which the messages will be sent to
        registry.enableSimpleBroker("/main");

        // Name of the server, which the client (SockJS in the browser) will connect to
        registry.setApplicationDestinationPrefixes("/server");
    }
}
