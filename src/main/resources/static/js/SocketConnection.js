let stompClient;

function connect() {
    //event.preventDefault();

    // Now connect to the endpoint, defined in WebSocketConfiguration
    let socket = new SockJS('/mysocket');
    // Start a connection to the endpoint using the STOMP protocol
    stompClient = Stomp.over(socket);

    stompClient.connect({}, onConnected, onError);
}


function onConnected() {
    // Subscribe to the topic main (channel)
    // if you use a "/" in the end of a string, you will also have to use it in the controller mapping
    document.body.style.display = "block";
    stompClient.subscribe('/main/', onMessageReceived);
}

function setStreamer(name) {
    // if you use a "/" in the end of a string, you will also have to use it in the controller mapping
    stompClient.send("/server/streamer/",
        {},
        JSON.stringify({name: name, link: "some link"})
    )
}

function onMessageReceived(payload) {
    document.querySelector("#streamer").innerHTML = "Current streamer " + JSON.parse(payload.body).name;
}


function onError(error) {
    console.log("error");
}

/*document.querySelector("#connect").addEventListener(
    "click", connect
)*/

setTimeout(connect(), 2000);