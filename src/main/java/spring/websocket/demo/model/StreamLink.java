package spring.websocket.demo.model;

// Random data object, which will automatically be parsed from the given input
public class StreamLink {

    private final String name;
    private final String link;

    public StreamLink(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }
}
