package book;

public class FictionBook extends Book {
	public FictionBook(String bookId, String title, String author, double price) {
		super(bookId, title, author, price);
	}

	@Override
	public String getDetails() {
		return "Fiction Book [ID=" + bookId + ", Title=" + title + ", Author=" + author + ", Price=" + price + "]";
	}
}
