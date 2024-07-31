package proxies;

import generics.Image;
import reals.RealImage;

public class ProxyImage implements Image {
    private RealImage realImage = new RealImage();

    @Override
    public void display() {
        realImage.display();
    }
    public void loadImage(){
        realImage.loadImage();
    }
    public void lazyLoading(){
        System.out.println("Lazy loading image");
    }
    public void caching(){
        System.out.println("Image caching");
    }
}
