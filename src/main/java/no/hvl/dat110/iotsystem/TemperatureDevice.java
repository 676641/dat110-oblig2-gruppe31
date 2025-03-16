package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

    private static final int COUNT = 10;

    public static void main(String[] args) {

        System.out.println("Temperature device starting ...");

        // Simulated temperature sensor
        TemperatureSensor sensor = new TemperatureSensor();

        // Create a client and connect to the broker
        Client client = new Client("sensor", Common.BROKERHOST, Common.BROKERPORT);
        client.connect();

        // Publish temperature readings COUNT times
        for (int i = 0; i < COUNT; i++) {
            int temp = sensor.read();
            System.out.println("READING: " + temp);
            client.publish(Common.TEMPTOPIC, Integer.toString(temp));
            
            try {
                Thread.sleep(1000); // Simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Disconnect from broker
        client.disconnect();
        System.out.println("Temperature device stopping ...");
    }
}
