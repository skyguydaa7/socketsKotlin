import java.lang.String.format
import java.net.ServerSocket
import java.net.Socket
import kotlin.concurrent.thread

class SocketServer(val serverSocket: ServerSocket) {

    fun start() {
        do {
            println("SocketServer - Aguardando cliente...")
            val accept = serverSocket.accept()

            println(format("Conectado com cliente: %s", accept.localSocketAddress))
            println("Mensagens:")

            startClientConnection(accept)

            clientMessageSending(accept)

        } while (true)
    }

    private fun clientMessageSending(accept: Socket) {
        thread {
            val outputStream = accept.getOutputStream()
            do {
                println("Entre sua mensagem:")
                val message = readLine()

                outputStream.write(message!!.toByteArray())
            } while (accept.isConnected)
        }
    }

    private fun startClientConnection(accept: Socket) {
        thread {
            val inputStream = accept.getInputStream()
            do {
                val received = ByteArray(DEFAULT_BUFFER_SIZE)
                inputStream.read(received)

                println(received)
            } while (received.contentToString().trim() != "FIM")
        }
    }
}