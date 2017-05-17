import java.io.ObjectOutputStream
import java.net.Socket
import kotlin.system.exitProcess

class MessageSender {

    fun start(accept: Socket, sender: String) {
        val objectOutputStream = ObjectOutputStream(accept.getOutputStream())
        do {
            val message = readLine()

            if (message!!.isNotEmpty()) {
                val toSend = Message(sender = sender, message = message)
                objectOutputStream.writeObject(toSend)
            }

        } while (message != "FIM")
        exitProcess(0)
    }
}