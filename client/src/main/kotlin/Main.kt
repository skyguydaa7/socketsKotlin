import SocketCons.Companion.SOCKET_PORT
import SocketCons.Companion.SOCKET_SERVER
import java.net.Socket

fun main(args: Array<String>) {
    println("SocketClient - Connecting...")

    try {
        SocketClient(Socket(SOCKET_SERVER, SOCKET_PORT)).start()
    } catch(e: Exception) {
        println("Error connecting to the server.")
    }
}