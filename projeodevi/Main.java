package com.webserver;

public class Main {
    public static void main(String[] args) {
        int port = 1989;
        String adSoyad = "Anıl Ak";
        String ogrenciNo = "1250505043"; 
        String biyografi = "Merhaba, ben <span class='highlight'>Yazılım Mühendisliği</span> öğrencisiyim. " +
                           "Ağ programlama, nesne yönelimli tasarım prensipleri ve arka uç sistemleri üzerine çalışmalar yapmaktayım. " +
                           "Bu web sayfası, harici kütüphane kullanılmadan saf Java Socket API ile sunulmaktadır.";

        HttpHandler profileHandler = new ProfileHtmlProvider(adSoyad, ogrenciNo, biyografi);
        SimpleWebServer server = new SimpleWebServer(port, profileHandler);
        server.start();
    }
}