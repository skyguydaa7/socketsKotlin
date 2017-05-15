import java.net.Socket
import kotlin.system.exitProcess

class MessageSender {

    fun start(accept: Socket) {
        val outputStream = accept.getOutputStream()
        do {
            val message = readLine()

            outputStream.write(message!!.trim().toByteArray(Charsets.UTF_8))
        } while (message != "FIM")
        exitProcess(0)
    }
}
