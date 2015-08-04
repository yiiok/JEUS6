package ejb.basic.messageDriven;

import javax.jms.*;
import javax.naming.*;
import java.util.Hashtable;


public class Client
{
    private final static int NUM_MSGS = 3;

    public static void main(String[] args)
    {
        InitialContext context = null;
        QueueConnectionFactory connectionFactory = null;
        QueueConnection connection = null;
        QueueSession session = null;
        Queue queue = null;
        QueueSender sender = null;
        TextMessage message = null;

        try {
            context = new InitialContext();
        }
        catch (NamingException e) {
            System.err.println("Fail to create JNDI context: " + e.toString());
            return;
        }

        try {
            connectionFactory = (QueueConnectionFactory) context.lookup("basic/QueueCF");
            queue = (Queue) context.lookup("queue/Example1");
        }
        catch (NamingException e) {
            System.err.println("Fail to look up connection factory: " + e.toString());
            return;
        }

        try {
            connection = connectionFactory.createQueueConnection();
            session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            sender = session.createSender(queue);
            message = session.createTextMessage();

            for (int i = 0; i < NUM_MSGS; i++) {
                message.setText("This is message " + (i + 1));
                System.out.println("Sending message: " + message.getText());
                sender.send(message);
            }
        }
        catch (JMSException e) {
            System.err.println("Exception occurred: " + e.toString());
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (JMSException e) {
                }
            }
        }
    }
}
