import java.io.ObjectInputStream
import java.net.Socket
import kotlin.concurrent.thread
import kotlin.system.exitProcess

class MessageReceiver {

    fun start(accept: Socket) {
        thread {
            val objectInputStream = ObjectInputStream(accept.getInputStream())
            do {
                var lastMessageReceivedText = ""
                try {
                    val receivedMessage = objectInputStream.readObject() as Message
                    lastMessageReceivedText = receivedMessage.message
                    println(String.format("Message from %s: %s", receivedMessage.sender, lastMessageReceivedText))
                } catch (e: Exception) {
                    println("Error reading message content.")
                }
            } while (lastMessageReceivedText != "FIM" && !accept.isInputShutdown)
            exitProcess(0)
        }
    }
}