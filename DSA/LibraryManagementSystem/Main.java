package DSA.LibraryManagementSystem;

import java.util.*;

public class Main {

    // Linear Search
    public static Book linearSearch(Book[] books, String title) {

        for (Book book : books) {

            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    // Binary Search
    public static Book binarySearch(Book[] books, String title) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result =
                    books[mid].title.compareToIgnoreCase(title);

            if (result == 0) {
                return books[mid];
            }

            if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

   public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    try {

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine();

        Book[] books = new Book[n];

        // Input Books with Validation
        for (int i = 0; i < n; ) {

            System.out.println("\nEnter Book " + (i + 1));

            System.out.print("Book ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            // Check Duplicate Book ID
            boolean duplicate = false;

            for (int j = 0; j < i; j++) {
                if (books[j] != null && books[j].bookId == id) {
                    duplicate = true;
                    break;
                }
            }

            if (duplicate) {
                System.out.println("Book ID already exists! Enter a unique Book ID.");
                continue;
            }

            if (id <= 0) {
                System.out.println("Book ID must be positive.");
                continue;
            }

            System.out.print("Title: ");
            String title = sc.nextLine();

            if (title.trim().isEmpty()) {
                System.out.println("Title cannot be empty.");
                continue;
            }

            System.out.print("Author: ");
            String author = sc.nextLine();

            if (author.trim().isEmpty()) {
                System.out.println("Author cannot be empty.");
                continue;
            }

            books[i] = new Book(id, title, author);
            i++;
        }

        int choice;

        do {

            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Display Books");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Book Title: ");
                    String linearTitle = sc.nextLine();

                    Book found1 = linearSearch(books, linearTitle);

                    if (found1 != null) {
                        System.out.println("\nBook Found");
                        System.out.println(found1);
                    } else {
                        System.out.println("Book Not Found");
                    }

                    break;

                case 2:

                    Arrays.sort(
                            books,
                            Comparator.comparing(
                                    b -> b.title.toLowerCase()
                            )
                    );

                    System.out.print("Enter Book Title: ");
                    String binaryTitle = sc.nextLine();

                    Book found2 = binarySearch(books, binaryTitle);

                    if (found2 != null) {
                        System.out.println("\nBook Found");
                        System.out.println(found2);
                    } else {
                        System.out.println("Book Not Found");
                    }

                    break;

                case 3:

                    System.out.println("\nBooks in Library:");

                    boolean empty = true;

                    for (Book book : books) {
                        if (book != null) {
                            System.out.println(book);
                            empty = false;
                        }
                    }

                    if (empty) {
                        System.out.println("No Books Available.");
                    }

                    break;

                case 4:

                    System.out.println("Exiting...");
                    break;

                default:

                    System.out.println("Invalid Choice! Please enter a value between 1 and 4.");
            }

        } while (choice != 4);

    }
    catch (InputMismatchException e) {
        System.out.println("Invalid Input! Please enter numeric values where required.");
    }
    catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    finally {
        sc.close();
    }
}
}