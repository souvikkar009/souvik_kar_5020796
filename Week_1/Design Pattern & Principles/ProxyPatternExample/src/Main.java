import proxies.ProxyImage;

public class Main {
    public static void main(String[] args) {
        ProxyImage proxyImage = new ProxyImage();
        proxyImage.loadImage();
        proxyImage.lazyLoading();
        proxyImage.caching();
        proxyImage.display();
    }
}