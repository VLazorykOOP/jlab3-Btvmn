public class FirstTask {
}
class PrintedPublication {
    protected String title;
    protected String author;
    protected int year;

    public PrintedPublication(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void Show() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
    }
}

class Magazine extends PrintedPublication {
    private int issueNumber;

    public Magazine(String title, String author, int year, int issueNumber) {
        super(title, author, year);
        this.issueNumber = issueNumber;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Issue Number: " + issueNumber);
    }
}

class Book extends PrintedPublication {
    private String publisher;

    public Book(String title, String author, int year, String publisher) {
        super(title, author, year);
        this.publisher = publisher;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Publisher: " + publisher);
    }
}

class Textbook extends Book {
    private String subject;

    public Textbook(String title, String author, int year, String publisher, String subject) {
        super(title, author, year, publisher);
        this.subject = subject;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Subject: " + subject);
    }
}
