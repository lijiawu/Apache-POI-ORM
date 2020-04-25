import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketCase {
    public void process() {
        Server server = new Server();
        ClientGenerator cg = new ClientGenerator();
        cg.generateClients();
    }

    private class Server {
        ServerSocket serverSocket = null;
        Server() {
            try {
                serverSocket = new ServerSocket(5551, 101);
            } catch (IOException e) {
                e.printStackTrace();
            }
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            serverSocket.accept();
                            sleep(5000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
    }

    private class ClientGenerator {
        public void generateClients() {
            for(int i = 0; i < 100; ++i) {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            Socket socket = new Socket();
                            socket.connect(new InetSocketAddress("127.0.0.1", 5551),5000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String args[]) {
        ServerSocketCase sc = new ServerSocketCase();
        sc.process();
    }
}
