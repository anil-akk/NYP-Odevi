Java Socket Tabanlı Saf Web Sunucusu
​Bu proje, herhangi bir 3. parti kütüphane veya harici sunucu yazılımı kullanılmadan, yalnızca saf Java kütüphaneleri ile geliştirilmiş HTTP/1.1 uyumlu basit bir web sunucusudur.
​Proje Özellikleri
​Harici bağımlılık barındırmaz ve yalnızca standart Java API'lerini kullanır.
​Sunucu, standart HTTP portlarından bağımsız olarak özel bir port üzerinden hizmet verir.
​Aynı anda gelen tarayıcı isteklerini ayrı iş parçacıkları üzerinde eşzamanlı olarak karşılar, bu sayede kilitlenme yaşanmaz.
​Soket yönetimi, sunucu çekirdeği ve HTML içerik üretimi birbirine bağımlı olmayan modüler sınıflara ayrılmıştır.
​Proje Dosya Yapısı
​Proje, nesne yönelimli programlama ve SOLID prensiplerine uygun olarak şu paket ve dosya yapısıyla tasarlanmıştır:
​İstekleri işlemek için oluşturulan soyut arayüz
​HTML içerik, profil bilgileri ve şablonu üreten sınıf
​İstemci soket akışlarını yöneten eşzamanlı sınıf
​Portu dinleyen sunucu çekirdeği
​Uygulamanın başlatıldığı ana giriş noktası
​Kurulum ve Çalıştırma Adımları
​Projenizi yerel ortamınızda ayağa kaldırmak için sırasıyla kaynak kodları derleyebilir, sunucuyu başlatabilir ve herhangi bir web tarayıcısının adres çubuğuna ilgili yerel bağlantı adresini yazarak sunucunuza erişim sağlayabilirsiniz.
