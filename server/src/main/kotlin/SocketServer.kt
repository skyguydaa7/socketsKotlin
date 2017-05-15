import java.lang.String.format
import java.net.ServerSocket

class SocketServer(val serverSocket: ServerSocket) {

    val messageReceiver = MessageReceiver()
    val messageSender = MessageSender()

    fun create() {
        println("SocketServer - Aguardando cliente...")
        val accept = serverSocket.accept()

        println(format("Conectado com cliente: %s", accept.localSocketAddress))
        println("Mensagens:")

        messageReceiver.start(accept)
        messageSender.start(accept)
    }
}