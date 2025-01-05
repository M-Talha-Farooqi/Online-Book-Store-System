# Online Bookstore Management System (CLI)

This is a Command-Line Interface (CLI) based Bookstore Management System developed in Java. The project has proper user registration and authentication functionality that allows users to browse from book catalog in a bookstore, including admin panel with feautures like adding, deleting, updating books. It also provides functionalities of order management and payment integration with multiple payment methods.

## Table of Contents

- [Online Bookstore Management System (CLI)](#online-bookstore-management-system-cli)
  - [Table of Contents](#table-of-contents)
  - [Features](#features)
  - [Technologies Used](#technologies-used)
  - [File Structure](#file-structure)
  - [Installation](#installation)
  - [Collaborators](#collaborators)

---

## Features

The core features of the Bookstore Management System are as follows:

1. **User Registation & Authentication**

   - Registers a new user
   - Passwords entered during account creation will be encrypted

2. **Browse & Search Books**
   - The software displays a list of books categorized by genres such as Fiction, Non-fiction, Science, etc.
   - User can search boooks for books by entering keywords related to titles, authors, or categories.
3. **Admin Panel**

   - Add a new book (Title, Author, Price, Quantity)
   - Update book details
   - Delete a book
   - View all books in the inventory

4. **Order Management**

   - Place an order for a customer
   - Customer can Add to Cart
   - Track order status
   - Update order status (Processing, Shipped, Delivered)

5. **Payment Integration**
   - Support Multiple Payment Methods

---

## Technologies Used

- **Java** - Programming language
- **JDK 11** - Java Development Kit
- **Maven** - Dependency management and build tool
- **Text-based CLI** - Command-Line Interface for interaction

---

## File Structure

## Installation

To install and run the Bookstore Management System locally, follow these steps:

1.  Clone the repository:
    ```bash
    git clone https://github.com/M-Talha-Farooqi/Online-Book-Store-System.git
    ```
2.  Navigate to the project directory:

    ```bash
    cd online-bookstore-system

    ```

3.  Build the project using Maven:

    ```bash
    mvn clean install

    ```

4.  Run the application:

    ```bash
      mvn exec:java
    ```

    The application should now run in your terminal or command prompt.

## Collaborators

- **[M. Talha Farooqi](https://github.com/M-Talha-Farooqi)** - Project Manager
- **[Fatima Jawad](https://github.com/Fatima-jawad-115)** - Project Designer
- **[Mahnoor Mustafa](https://github.com/mahnoor418)** - Requirement Analyst
- **[Khansa Usman]()** - Developer
- **[Eman Azam]()** - Developer
