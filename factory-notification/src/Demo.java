interface Notification {
    void notifyUser();
}

class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an Email notification.");
    }
}

class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS notification.");
    }
}

class PushNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending a Push notification.");
    }
}

class NotificationFactory {
    public static Notification createNotification(String channel) {
        if (channel == null || channel.isEmpty()) return null;
        switch (channel.toLowerCase()) {
            case "email": return new EmailNotification();
            case "sms": return new SMSNotification();
            case "push": return new PushNotification();
            default: throw new IllegalArgumentException("Unknown channel " + channel);
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        System.out.println("Creating Email Notification:");
        Notification n1 = NotificationFactory.createNotification("EMAIL");
        n1.notifyUser();

        System.out.println("\nCreating SMS Notification:");
        Notification n2 = NotificationFactory.createNotification("SMS");
        n2.notifyUser();

        System.out.println("\nCreating Push Notification:");
        Notification n3 = NotificationFactory.createNotification("PUSH");
        n3.notifyUser();
    }
}
