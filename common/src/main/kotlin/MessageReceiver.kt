import java.net.Socket
import kotlin.concurrent.thread
import kotlin.system.exitProcess

class MessageReceiver {

    fun start(accept: Socket) {
        thread {
            val inputStream = accept.getInputStream()
            do {
                val received = ByteArray(DEFAULT_BUFFER_SIZE)
                inputStream.read(received)

                val receivedString = String(received, Charsets.UTF_8).replace("\u0000", "").trim()

                println(String.format("Mensagem recebida: %s", receivedString))
            } while (receivedString != "FIM" && !accept.isInputShutdown)
            exitProcess(0)
        }
    }
}
