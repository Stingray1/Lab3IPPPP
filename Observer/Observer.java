package com.company.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vadim on 12/7/16.
 */
public class Observer {

    public static void main(String[] args) {
            JavaDeveloperJobSite javaDeveloperJobSite = new JavaDeveloperJobSite();
            javaDeveloperJobSite.addVacancy("junior java");
            javaDeveloperJobSite.addVacancy("Middle java");

            iObserver firstSubscriber = new Subscriber("Vadim");
            iObserver secondSubscriber = new Subscriber("Marcel");

            javaDeveloperJobSite.addObserver(firstSubscriber);
            javaDeveloperJobSite.addObserver(secondSubscriber);

         javaDeveloperJobSite.addVacancy("Senior Java");


           javaDeveloperJobSite.removeVacancy("junior java");
    }
}

interface iObserver
{
    public void eventHandle(List<String>vacancies);
}
interface Observed
{
    public void addObserver(iObserver observer);
    public void removeObserver(iObserver observer);
    public void notifyObservers();
}


class Subscriber implements  iObserver
{
    String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void eventHandle(List<String> vacancies) {
        System.out.println("Dear "+name+"\nWe have some changes in vacancies\n"+vacancies);
    }
}

class JavaDeveloperJobSite implements Observed
{
    List<String>vacancies = new ArrayList<>();
    List<iObserver> subscribers = new ArrayList<>();


    public void addVacancy(String Vacancy)
    {
        this.vacancies.add(Vacancy);
        notifyObservers();
    }

    public void removeVacancy(String Vacancy)
    {
        this.vacancies.remove(Vacancy);
        notifyObservers();
    }

    @Override
    public void addObserver(iObserver observer) {

            subscribers.add(observer);
    }

    @Override
    public void removeObserver(iObserver observer) {

        subscribers.remove(observer );

    }

    @Override
    public void notifyObservers() {
        for(iObserver observer :subscribers)
        {
            observer.eventHandle(this.vacancies);
        }

    }
}

