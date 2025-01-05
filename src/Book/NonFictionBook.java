package book;

public class NonFictionBook extends Book {
	public NonFictionBook(String bookId, String title, String author, double price) {
		super(bookId, title, author, price);
	}

	@Override
	public String getDetails() {
		return "Non-Fiction Book [ID=" + bookId + ", Title=" + title + ", Author=" + author + ", Price=" + price + "]";
	}
}
