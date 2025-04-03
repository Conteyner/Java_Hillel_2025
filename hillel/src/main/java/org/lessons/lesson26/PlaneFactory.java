package org.lessons.lesson26;

public class PlaneFactory extends TransportFactory{
    @Override
    public Transport createTransport() {
        return new Plane();
    }
}
