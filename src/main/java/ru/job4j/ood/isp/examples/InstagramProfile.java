package ru.job4j.ood.isp.examples;

public class InstagramProfile implements SocialMediaProfile {

    @Override
    public void postMessage() {

    }

    /**
     * Причина нарушения: InstagramProfile вынужден реализовывать методы,
     * которые не имеет смысла использовать в данном контексте, например,
     * makeCall() и sendEmail() здесь лишние
     *
     */

    @Override
    public void makeCall() {

    }

    @Override
    public void sendEmail() {

    }

    @Override
    public void editProfile() {

    }
}
