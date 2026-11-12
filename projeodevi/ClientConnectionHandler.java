package com.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientConnectionHandler implements Runnable {

    private final Socket clientSocket;
    private final HttpHandler httpHandler;

    public ClientConnectionHandler(Socket clientSocket, HttpHandler httpHandler) {
        this.clientSocket = clientSocket;
        this.httpHandler = httpHandler;
    }

    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));
            OutputStream out = clientSocket.getOutputStream()
        ) {
            String requestLine = in.readLine();
            if (requestLine != null && !requestLine.isEmpty()) {
                System.out.println("Gelen İstek: " + requestLine);
                String httpResponse = httpHandler.handleRequest(requestLine);
                out.write(httpResponse.getBytes(StandardCharsets.UTF_8));
                out.flush();
            }
        } catch (IOException e) {
            System.err.println("İletişim hatası: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                // Kapatma hatası
            }
        }
    }
}