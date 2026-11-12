package com.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServer {

    private final int port;
    private final HttpHandler httpHandler;

    public SimpleWebServer(int port, HttpHandler httpHandler) {
        this.port = port;
        this.httpHandler = httpHandler;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Web Sunucusu başlatıldı: http://localhost:" + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientConnectionHandler(clientSocket, httpHandler)).start();
            }
        } catch (IOException e) {
            System.err.println("Sunucu başlatılamadı (Port kullanımda olabilir): " + e.getMessage());
        }
    }
}