package com.company.ChainResponsability;


public class ChainResponsability {

    public static void main(String[] args) {

        Notifier reportNotifier = new SimpleReportNotifier(Priority.Routine);
        Notifier emailNotifier = new EmailNotifier(Priority.Important);
        Notifier smsNoTifier = new SmsNotifier(Priority.ASAP);

        reportNotifier.setNextNotifier(emailNotifier);
        emailNotifier.setNextNotifier(smsNoTifier);

       reportNotifier.notifyManager("Everything is ok ",Priority.Routine);
        reportNotifier.notifyManager("Something went wrong", Priority.Important);
        reportNotifier.notifyManager("Huston, we have problems",Priority.ASAP);

    }
}
abstract  class  Notifier
{
        private int idPriority;
        private Notifier nextNotifier;

    public Notifier(int idPriority) {
        this.idPriority = idPriority;
    }

    public void setNextNotifier(Notifier nextNotifier) {
        this.nextNotifier = nextNotifier;
    }
    public void notifyManager (String message ,int level)
    {
        if(level>=idPriority)
        {
            write(message);
        }
        if(nextNotifier!=null)
        {
            nextNotifier.notifyManager(message,level);
        }

    }
    abstract void write (String message);
}

class Priority
{
    public static final int Routine=1;
    public static final int Important=2;
    public static final int ASAP=3;
}
class SimpleReportNotifier extends Notifier
{
    public SimpleReportNotifier(int idPriority) {
        super(idPriority);
    }

    @Override
    void write(String message) {
            System.out.println("Notifying using simple report "+message);
    }
}
class EmailNotifier extends  Notifier
{
    public EmailNotifier(int idPriority) {
        super(idPriority);
    }

    @Override
    void write(String message) {
        System.out.println("Sending email "+message);
    }
}
class SmsNotifier extends Notifier
{
    public SmsNotifier(int idPriority) {
        super(idPriority);
    }

    @Override
    void write(String message) {
        System.out.println("Sending sms to Manager "+message);
    }
}


