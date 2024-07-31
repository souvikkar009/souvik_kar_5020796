package utils;


import models.Book;
import services.LibManagerOps;


import java.util.*;

public class LibraryManager implements LibManagerOps {
    private static LibraryManager libraryManager = null;
    private static List<Book> allBooks;
    private final Scanner sc = new Scanner(System.in);

    private LibraryManager(){
        allBooks = new ArrayList<>();
    }

    public static LibraryManager getLibraryManager(){
        if (libraryManager == null){
            libraryManager = new LibraryManager();
        }
        return libraryManager;
    }

    public void storeBooks(int size){
        System.out.println("*** Store Books ***");

        for (int i = 0; i < size; i++) {

            Book book = new Book();
            System.out.println("Enter bookId: ");
            book.setBookId(sc.nextInt());
            sc.nextLine();
            System.out.println("Enter book title: ");
            book.setTitle(sc.nextLine());
            System.out.println("Enter author name: ");
            book.setAuthor(sc.nextLine());
            allBooks.add(book);
        }
        allBooks.sort(Comparator.comparing(Book::getTitle));

    }

    public void displayBooks(){
        for(Book book : allBooks){
            System.out.println(book);
        }
    }


    @Override
    public void LinearSearch(String title) {
        for (Book book : allBooks) {
            if (book.getTitle().equals(title)) {
                System.out.println("Book Found!");
                System.out.println(book);
                break;
            }
        }
        System.out.println("Product Not Found!");
    }

    @Override
    public void BinarySearch(String title) {
        int ub = allBooks.size() - 1;
        int lb = 0;

        while (lb <= ub){
            int mid = (ub - lb) / 2 + lb;
            if (allBooks.get(mid).getTitle().compareTo(title) == 0){
                System.out.println("Book Found!");
                System.out.println(allBooks.get(mid));
                return;
            }else if(allBooks.get(mid).getTitle().compareTo(title) > 0){
                ub = mid - 1;
            }else {
                lb = mid + 1;
            }
        }
        System.out.println("Book Not Found!");
    }
}
