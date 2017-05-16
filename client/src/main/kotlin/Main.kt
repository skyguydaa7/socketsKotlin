import java.net.Socket

fun main(args: Array<String>) {
    val SERVER = "localhost"
    val PORT = 9999

    println("SocketClient - Connecting...")

    try {
        SocketClient(Socket(SERVER, PORT)).start()
    } catch(e: Exception) {
        println("Error connecting to the server.")
    }
}