import java.net.Socket

class SocketClient(val socketClient: Socket) {

    val messageReceiver = MessageReceiver()
    val messageSender = MessageSender()

    fun start() {
        println("Messages:")

        messageReceiver.start(socketClient)
        messageSender.start(socketClient, "client")
    }
}