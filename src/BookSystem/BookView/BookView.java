package BookSystem.BookView;


import java.util.InputMismatchException;
import java.util.Scanner;

public class BookView {
    BookSystem.BookService.BookService BS = new BookSystem.BookService.BookService();
    Scanner sc = new Scanner(System.in);
    int num =0;

    public void BookStart() {
        while(true) {
            System.out.println("=== 도서관리 시스템 ===\n");
            System.out.println("메뉴: 1. 도서정보추가, 2. ISBN조회, 3.도서수정,\n\t4.도서삭제, 5.출력(모든 도서), 6.종료\n");
            System.out.printf("메뉴를 입력하세요(1~6): ");

            while (true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    num = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.printf("정확히 입력하시오: ");
                }
            }

            if(num==6) {break;}

            switch (num){
                case 1:
                    BS.BookInfo();
                    break;
                case 2:
                    BS.searchBook();
                    break;
                case 3:
                    BS.UpdateBook();
                    break;
                case 4:
                    System.out.println("--- 도서삭제 ---\n");
                    BS.DeleteBook();
                    break;
                case 5:
                    System.out.println("--- 도서출력(모든도서) ---\n");
                    BS.AllBooks();
                    break;

                default:
                    System.out.println("\n다시 입력하시오\n");
                    BookStart();
                    break;
            }
        }









    }








}
