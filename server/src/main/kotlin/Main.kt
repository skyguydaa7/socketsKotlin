import SocketCons.Companion.SOCKET_PORT
import java.net.ServerSocket
fun main(args: Array<String>) {

    println("SocketServer - Initializing...")

    try {
        SocketServer(ServerSocket(SOCKET_PORT)).create()
    } catch(e: Exception) {
        println("Error initializing server.")
    }
}

