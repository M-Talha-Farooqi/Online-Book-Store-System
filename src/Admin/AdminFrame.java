package admin;

import book.Book;
import book.BookFactory;
import manager.BookStoreManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private BookStoreManager manager;

	public AdminFrame() {
		manager = BookStoreManager.getInstance();
		setTitle("Online Bookstore - Admin");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		setContentPane(mainPanel);
		showLoginPanel();

		setVisible(true);
	}

/*************  ✨ Codeium Command ⭐  *************/
	/**
	 * Sets up the login panel, where the administrator can enter their username
	 * and password to access the admin panel.
	 */
/******  fe2ffb5f-754d-4f9c-b324-c0347ed95c3e  *******/
	private void showLoginPanel() {
		mainPanel.removeAll();
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

		JLabel usernameLabel = new JLabel("Username:");
		JTextField usernameField = new JTextField();
		usernameField.setPreferredSize(new Dimension(200, 30));

		JLabel passwordLabel = new JLabel("Password:");
		JPasswordField passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(200, 30));

		JButton loginButton = new JButton("Login");
		loginButton.setPreferredSize(new Dimension(100, 30));
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				if (username.equals("admin") && password.equals("admin123")) {
					JOptionPane.showMessageDialog(null, "Login successful!");
					showAdminPanel();
				} else {
					JOptionPane.showMessageDialog(null, "Invalid credentials. Try again.");
				}
			}
		});

		mainPanel.add(usernameLabel);
		mainPanel.add(usernameField);
		mainPanel.add(passwordLabel);
		mainPanel.add(passwordField);
		mainPanel.add(loginButton);
	}

	private void showAdminPanel() {

		mainPanel.removeAll();
		mainPanel.setLayout(new GridLayout(5, 1, 10, 10));

		JButton addButton = new JButton("Add Book");
		JButton editButton = new JButton("Edit Book");
		JButton removeButton = new JButton("Remove Book");
		JButton displayButton = new JButton("Display Inventory");
		JButton logoutButton = new JButton("Logout");

		addButton.addActionListener(e -> addBookDialog());
		editButton.addActionListener(e -> editBookDialog());
		removeButton.addActionListener(e -> removeBookDialog());
		displayButton.addActionListener(e -> displayInventory());
		logoutButton.addActionListener(e -> showLoginPanel());

		mainPanel.add(addButton);
		mainPanel.add(editButton);
		mainPanel.add(removeButton);
		mainPanel.add(displayButton);
		mainPanel.add(logoutButton);

		mainPanel.revalidate();
		mainPanel.repaint();

	}

	private void displayInventory() {
		java.util.List<Book> inventory = manager.getInventory();
		StringBuilder inventoryData = new StringBuilder();

		if (inventory.isEmpty()) {
			inventoryData.append("No books in inventory.");
		} else {
			inventoryData.append("Book Inventory:\n");
			for (Book book : inventory) {
				inventoryData.append("Book ID: ").append(book.getBookId()).append("\n").append("Title: ")
						.append(book.getTitle()).append("\n").append("Author: ").append(book.getAuthor()).append("\n")
						.append("Price: ").append(book.getPrice()).append("\n")
						.append("----------------------------\n");
			}
		}

		JOptionPane.showMessageDialog(this, inventoryData.toString(), "Book Inventory",
				JOptionPane.INFORMATION_MESSAGE);
	}

	private void addBookDialog() {
		JTextField typeField = new JTextField();
		JTextField idField = new JTextField();
		JTextField titleField = new JTextField();
		JTextField authorField = new JTextField();
		JTextField priceField = new JTextField();

		Object[] fields = { "Type (fiction/nonfiction/science):", typeField, "Book ID:", idField, "Title:", titleField,
				"Author:", authorField, "Price:", priceField };

		int result = JOptionPane.showConfirmDialog(this, fields, "Add Book", JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {
			try {
				String type = typeField.getText();
				String id = idField.getText();
				String title = titleField.getText();
				String author = authorField.getText();
				double price = Double.parseDouble(priceField.getText());

				Book book = BookFactory.createBook(type, id, title, author, price);
				manager.addBook(book);
				JOptionPane.showMessageDialog(this, "Book added successfully!");
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Invalid price. Please enter a valid number.");
			}
		}
	}

	private void editBookDialog() {
		JTextField idField = new JTextField();
		JTextField titleField = new JTextField();
		JTextField authorField = new JTextField();
		JTextField priceField = new JTextField();

		Object[] fields = { "Book ID to Edit:", idField, "New Title:", titleField, "New Author:", authorField,
				"New Price:", priceField };

		int result = JOptionPane.showConfirmDialog(this, fields, "Edit Book", JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {
			String id = idField.getText();
			String title = titleField.getText();
			String author = authorField.getText();
			try {
				double price = Double.parseDouble(priceField.getText());
				manager.editBook(id, title, author, price);
				JOptionPane.showMessageDialog(this, "Book updated successfully!");
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Invalid price. Please enter a valid number.");
			}
		}
	}

	private void removeBookDialog() {
		JTextField idField = new JTextField();

		Object[] fields = { "Book ID to Remove:", idField };

		int result = JOptionPane.showConfirmDialog(this, fields, "Remove Book", JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {
			String id = idField.getText();
			manager.removeBook(id);
			JOptionPane.showMessageDialog(this, "Book removed successfully!");
		}
	}
}
