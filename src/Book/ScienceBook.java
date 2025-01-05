package book;

public class ScienceBook extends Book {
	public ScienceBook(String bookId, String title, String author, double price) {
		super(bookId, title, author, price);
	}

	@Override
	public String getDetails() {
		return "Science Book [ID=" + bookId + ", Title=" + title + ", Author=" + author + ", Price=" + price + "]";
	}
}
