import java.net.Socket

fun main(args: Array<String>) {
    println("SocketClient - iniciando...")

    SocketClient(Socket("localhost", 9999)).start()
}