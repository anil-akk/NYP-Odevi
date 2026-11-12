package com.webserver;

import java.nio.charset.StandardCharsets;

public class ProfileHtmlProvider implements HttpHandler {

    private final String fullName;
    private final String studentId;
    private final String biography;

    public ProfileHtmlProvider(String fullName, String studentId, String biography) {
        this.fullName = fullName;
        this.studentId = studentId;
        this.biography = biography;
    }

    @Override
    public String handleRequest(String requestLine) {
        String htmlBody = "<!DOCTYPE html>" +
                "<html lang='tr'>" +
                "<head>" +
                "<meta charset='UTF-8'>" +
                "<title>Öğrenci Profili</title>" +
                "<style>" +
                "  body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f0f4f8; color: #333; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }" +
                "  .card { background-color: #ffffff; padding: 40px; border-radius: 12px; box-shadow: 0 4px 15px rgba(0,0,0,0.1); max-width: 600px; text-align: center; border-top: 6px solid #2b6cb0; }" +
                "  h1 { color: #1a365d; font-size: 32px; margin-bottom: 5px; }" +
                "  h2 { color: #2b6cb0; font-size: 20px; font-weight: normal; margin-top: 0; border-bottom: 1px solid #e2e8f0; padding-bottom: 15px; }" +
                "  p { font-size: 16px; line-height: 1.6; color: #4a5568; text-align: justify; }" +
                "  .highlight { color: #d69e2e; font-weight: bold; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='card'>" +
                "  <h1>" + fullName + "</h1>" +
                "  <h2>Öğrenci No: " + studentId + "</h2>" +
                "  <p>" + biography + "</p>" +
                "</div>" +
                "</body>" +
                "</html>";

        byte[] contentBytes = htmlBody.getBytes(StandardCharsets.UTF_8);
        return "HTTP/1.1 200 OK\r\n" +
               "Content-Type: text/html; charset=UTF-8\r\n" +
               "Content-Length: " + contentBytes.length + "\r\n" +
               "Connection: close\r\n" +
               "\r\n" +
               htmlBody;
    }
}