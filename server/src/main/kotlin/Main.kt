import java.net.ServerSocket
fun main(args: Array<String>) {
    println("SocketServer - iniciando...")

    SocketServer(ServerSocket(9999)).start()
}

