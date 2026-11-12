package com.webserver;

public interface HttpHandler {
    String handleRequest(String requestLine);
}