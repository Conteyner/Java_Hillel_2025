package org.lessons.lesson26;

public class Client {
    public static void main(String[] args) {
        Client.run();
    }

    static void run(){
        TransportFactory carFactory = new CarFactory();
        TransportFactory planeFactory = new PlaneFactory();

        Transport car = carFactory.createTransport();
        Transport plane = planeFactory.createTransport();

        car.move();
        plane.move();
    }

}
