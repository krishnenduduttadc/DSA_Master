package DesignPatternL1;

public class SingleResponsibilityPrincipal {
    public static void main(String[] args) {
        Book book = new Book("Java Programming", "John Doe", "Learn Java in simple steps.");

        BookPrinter printer = new BookPrinter();
        printer.print(book);

        BookRepository repository = new BookRepository();
        repository.save(book);
    }

    // Class responsible for storing book information
    public static class Book {
        private String title;
        private String author;
        private String text;

        public Book(String title, String author, String text) {
            this.title = title;
            this.author = author;
            this.text = text;
        }

        // Getters and setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    // Class responsible for printing the book details
    public static class BookPrinter {
        public void print(Book book) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Text: " + book.getText());
        }
    }

    // Class responsible for saving the book to a database
    public static class BookRepository {
        public void save(Book book) {
            // Code to save the book to a database
            System.out.println("Saving book to database...");
        }
    }
}
