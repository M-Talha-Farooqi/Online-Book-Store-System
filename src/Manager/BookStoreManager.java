package manager;

import book.Book;

import java.util.ArrayList;
import java.util.List;

public class BookStoreManager {
	private static BookStoreManager instance;
	private List<Book> inventory = new ArrayList<>();

	private BookStoreManager() {
	}

	public static synchronized BookStoreManager getInstance() {
		if (instance == null) {
			instance = new BookStoreManager();
		}
		return instance;
	}

	public void addBook(Book book) {
		inventory.add(book);
	}

	public List<Book> getInventory() {
		return inventory;
	}

	public void editBook(String id, String title, String author, double price) {
		for (Book book : inventory) {
			if (book.getBookId().equals(id)) {
				book.setTitle(title);
				book.setAuthor(author);
				book.setPrice(price);
				return;
			}
		}
		throw new IllegalArgumentException("Book with ID " + id + " not found.");
	}

	public void removeBook(String id) {
		inventory.removeIf(book -> book.getBookId().equals(id));
	}
}
