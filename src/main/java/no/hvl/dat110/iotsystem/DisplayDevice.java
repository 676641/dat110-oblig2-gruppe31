package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		// Create a client object and connect to the broker
        Client client = new Client("display", Common.BROKERHOST, Common.BROKERPORT);
        client.connect();
        
        // Create and subscribe to the temperature topic
        client.createTopic(Common.TEMPTOPIC);
        client.subscribe(Common.TEMPTOPIC);
        
        // Receive COUNT messages from the topic
        for (int i = 0; i < COUNT; i++) {
            Message msg = client.receive();
            if (msg instanceof PublishMsg) {
                System.out.println("DISPLAY: " + ((PublishMsg) msg).getMessage());
            }
        }
        
        // Unsubscribe and disconnect from the broker
        client.unsubscribe(Common.TEMPTOPIC);
        client.disconnect();
		
		System.out.println("Display stopping ... ");
				
	}
}
