package reals;

import generics.Image;

public class RealImage implements Image {
    @Override
    public void display() {
        System.out.println("Displaying Image");
    }
    public void loadImage(){
        System.out.println("Image loading from a remote server");
    }
}
