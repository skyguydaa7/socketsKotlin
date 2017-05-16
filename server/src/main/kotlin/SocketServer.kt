import java.lang.String.format
import java.net.ServerSocket

class SocketServer(val serverSocket: ServerSocket) {

    val messageReceiver = MessageReceiver()
    val messageSender = MessageSender()

    fun create() {
        println("SocketServer - Waiting for client...")
        val accept = serverSocket.accept()

        println(format("Client connected: %s", accept.localSocketAddress))
        println("Messages:")

        messageReceiver.start(accept)
        messageSender.start(accept)
    }
}