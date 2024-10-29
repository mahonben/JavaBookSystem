package BookSystem.BookService;


import BookSystem.BookDTO.BookDTO;
import java.util.ArrayList;
import java.util.Scanner;

public class BookService {

    ArrayList<BookDTO> BL = new ArrayList<>();

    Scanner sc = new Scanner(System.in);


    public BookDTO BookInfo() {
        System.out.println("--- 도서정보추가 ---\n");

        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("도서명: ");
        String bookName = sc.nextLine();
        System.out.print("저자: ");
        String author = sc.nextLine();
        System.out.print("출판사: ");
        String publisher = sc.nextLine();
        System.out.print("가격: ");
        int price = sc.nextInt();
        sc.nextLine();

        BookDTO newBook = new BookDTO(isbn, bookName, author, publisher, price);

        BL.add(newBook);
        return newBook;
    }


    public BookDTO findBook(String isbn) {
        for (int i =0;i<BL.size(); i++) {
            if (BL.get(i).getIsbn().equals(isbn)) {
                return BL.get(i);
            }
        }
        return null;
    }
    public void searchBook() {
        System.out.println("--- 도서 조회 ---\n");
        System.out.print("조회할 도서의 ISBN을 입력하세요: ");
        String isbn = sc.nextLine();

        BookDTO book = findBook(isbn);

        if (book != null) {
            System.out.println("조회된 도서 정보:");
            System.out.println(book);
        } else {
            System.out.println("해당 ISBN의 도서를 찾을 수 없습니다.");
        }
    }

    public BookDTO findBookIsbn(String isbn) {
        for (BookDTO BDTO : BL) {
            if (BDTO.getIsbn().equals(isbn)) {
                return BDTO;
            }
        }
        return null;
    }
    public boolean updateBook(String isbn, String newisbn, String newBookName, String newAuthor, String newPublisher, int newPrice) {
        BookDTO BDTO = findBookIsbn(isbn);

        if (BDTO != null) {
            BDTO.setIsbn(newisbn);
            BDTO.setBookName(newBookName);
            BDTO.setAuthor(newAuthor);
            BDTO.setPublisher(newPublisher);
            BDTO.setPrice(newPrice);
            return true;
        }
        return false;
    }
    public void UpdateBook() {
        System.out.println("--- 수정할 도서를 선택하세요 ---");
        ArrayList<BookDTO> BDTO = AllBooks();

        if (BDTO.size() <= 0) {
            System.out.println("등록된 도서가 없습니다.");
            return;
        }

        System.out.print("수정할 도서의 번호를 입력하세요: ");
        int num = sc.nextInt() - 1;
        sc.nextLine();

        if (num < 0 || num >= BDTO.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }

        BookDTO selectedBook = BDTO.get(num);
        System.out.println("선택한 도서 정보: " + selectedBook);

        System.out.print("새로운 ISBN을 입력하세요 (기존: " + selectedBook.getIsbn() + "): ");
        String newisbn = sc.nextLine();

        System.out.print("새로운 도서명을 입력하세요 (기존: " + selectedBook.getBookName() + "): ");
        String newBookName = sc.nextLine();

        System.out.print("새로운 저자를 입력하세요 (기존: " + selectedBook.getAuthor() + "): ");
        String newAuthor = sc.nextLine();

        System.out.print("새로운 출판사를 입력하세요 (기존: " + selectedBook.getPublisher() + "): ");
        String newPublisher = sc.nextLine();

        System.out.print("새로운 가격을 입력하세요 (기존: " + selectedBook.getPrice() + "): ");
        int newPrice = sc.nextInt();
        sc.nextLine();

        updateBook(selectedBook.getIsbn(), newisbn, newBookName, newAuthor, newPublisher, newPrice);
        System.out.println("도서 정보가 수정되었습니다.");
    }



    public boolean deleteBook(String isbn) {
        BookDTO BDTO = findBookIsbn(isbn);
        if (BDTO != null) {
            BL.remove(BDTO);
            return true;
        }
        return false;
    }

    public void DeleteBook() {
        System.out.println("--- 삭제할 도서를 선택하세요 ---");
        ArrayList<BookDTO> BDTO = AllBooks();
        if (BDTO.isEmpty()) {
            System.out.println("등록된 도서가 없습니다.");
            return;
        }

        System.out.print("삭제할 도서의 번호를 입력하세요: ");
        int num = sc.nextInt() - 1;
        sc.nextLine();

        if (num < 0 || num >= BDTO.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }

        BookDTO selectBook = BDTO.get(num);
        System.out.println("선택한 도서 정보: " + selectBook);

        if (deleteBook(selectBook.getIsbn())) {
            System.out.println("도서가 삭제되었습니다.");
        } else {
            System.out.println("도서 삭제에 실패했습니다.");
        }
    }


    public ArrayList<BookDTO> AllBooks() {
        for (int i = 0; i < BL.size(); i++) {
            System.out.printf("%d번 %s\n", i+1, BL.get(i).toString());
        }
        return BL;
    }
}
