package no.hvl.dat110.messages;

public class CreateTopicMsg extends Message {
    private String topic;

    // Constructor
    public CreateTopicMsg(String user, String topic) {
        super(MessageType.CREATETOPIC, user);
        this.topic = topic;
    }

    // Getter and Setter
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    // toString method for logging
    @Override
    public String toString() {
        return "CreateTopicMsg [user=" + getUser() + ", topic=" + topic + "]";
    }
}