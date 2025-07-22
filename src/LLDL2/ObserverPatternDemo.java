package LLDL2;

import java.util.ArrayList;
import java.util.List;

// Single file with all classes
public class ObserverPatternDemo {

    // Main method
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        NewsChannel channel1 = new NewsChannel("CNN");
        NewsChannel channel2 = new NewsChannel("BBC");

        agency.addObserver(channel1);
        agency.addObserver(channel2);

        agency.setNews("Elections coming soon!");
        agency.setNews("New tax reforms announced.");
    }

    // Observer Interface
    interface Observer {
        void update(String news);
    }

    // Subject Interface
    interface Subject {
        void addObserver(Observer o);

        void removeObserver(Observer o);

        void notifyObservers();
    }

    // Concrete Subject
    static class NewsAgency implements Subject {
        private List<Observer> observers = new ArrayList<>();
        private String news;

        public void setNews(String news) {
            this.news = news;
            notifyObservers();
        }

        @Override
        public void addObserver(Observer o) {
            observers.add(o);
        }

        @Override
        public void removeObserver(Observer o) {
            observers.remove(o);
        }

        @Override
        public void notifyObservers() {
            for (Observer o : observers) {
                o.update(news);
            }
        }
    }

    // Concrete Observer
    static class NewsChannel implements Observer {
        private String name;

        public NewsChannel(String name) {
            this.name = name;
        }

        @Override
        public void update(String news) {
            System.out.println(name + " received news: " + news);
        }
    }
}
