package DesignPatternL2;

public class VisitorPatternDemo {

    public static void main(String[] args) {
        Element[] items = {new Book(), new DVD()};
        Visitor priceChecker = new PriceVisitor();

        for (Element e : items) {
            e.accept(priceChecker);
        }
    }

    interface Element {
        void accept(Visitor visitor);
    }

    interface Visitor {
        void visit(Book book);

        void visit(DVD dvd);
    }

    static class Book implements Element {
        String title = "Design Patterns";

        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    static class DVD implements Element {
        String title = "Java Tutorial";

        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    static class PriceVisitor implements Visitor {
        public void visit(Book book) {
            System.out.println("Book price: $20");
        }

        public void visit(DVD dvd) {
            System.out.println("DVD price: $15");
        }
    }
}

