package book;

public class BookFactory {
	public static Book createBook(String type, String bookId, String title, String author, double price) {
		switch (type.toLowerCase()) {
		case "fiction":
			return new FictionBook(bookId, title, author, price);
		case "nonfiction":
			return new NonFictionBook(bookId, title, author, price);
		case "science":
			return new ScienceBook(bookId, title, author, price);
		default:
			throw new IllegalArgumentException("Invalid book type: " + type);
		}
	}
}
