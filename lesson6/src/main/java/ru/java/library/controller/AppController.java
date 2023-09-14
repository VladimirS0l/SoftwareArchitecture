package ru.java.library.controller;

import ru.java.library.entity.Book;
import ru.java.library.entity.User;
import ru.java.library.ui.Library;

import java.util.Scanner;
/**
 * Контроллер для управления основными функциями приложения
 */
public class AppController {
    static Scanner scanner = new Scanner(System.in);

    public static void startApp() {
        Library library = new Library();
        library.initialize();
        boolean f = true;
        while (f) {
            library.printMainMenu();
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (no) {
                        case 0:
                            System.out.println("Завершение работы приложения");
                            f = false;
                            break;
                        case 1:
                            library.showAllUsers();
                            break;
                        case 2:
                            System.out.print("Укажите ID пользователя: ");
                            if (scanner.hasNextInt()) {
                                int idUser = scanner.nextInt();
                                scanner.nextLine();
                                library.showOneUser(idUser);
                            } else {
                                System.out.println("ID пользователя указан некорректно.");
                            }
                            break;
                        case 3:
                            System.out.println("Введите имя пользователя: ");
                            String name = scanner.nextLine();
                            System.out.println("Введите телефон пользователя: ");
                            String phone = scanner.nextLine();
                            User user = new User(name, phone);
                            library.addNewUser(user);
                            break;
                        case 4:
                            System.out.print("Укажите ID пользователя для редактирования: ");
                            int idUserEdit = -1;
                            if (scanner.hasNextInt()) {
                                idUserEdit = scanner.nextInt();
                                scanner.nextLine();
                            } else {
                                System.out.println("ID пользователя указан некорректно.");
                            }
                            System.out.println("Введите новое имя пользователя: ");
                            String nameEdit = scanner.nextLine();
                            System.out.println("Введите новый телефон пользователя: ");
                            String phoneEdit = scanner.nextLine();
                            User userEdit = new User(nameEdit, phoneEdit);
                            library.editUser(userEdit, idUserEdit);
                            break;
                        case 5:
                            System.out.print("Укажите ID пользователя для удаления: ");
                            if (scanner.hasNextInt()) {
                                int idUserForDelete = scanner.nextInt();
                                scanner.nextLine();
                                library.deleteUser(idUserForDelete);
                            } else {
                                System.out.println("ID пользователя указан некорректно.");
                            }
                            break;
                        case 6:
                            library.showAllBooks();
                            break;
                        case 7:
                            int idUserForAddBook = -1;
                            int idBookForRealise = -1;
                            System.out.print("Укажите ID пользователя для добавления новой книги: ");
                            if (scanner.hasNextInt()) {
                                idUserForAddBook = scanner.nextInt();
                                scanner.nextLine();
                            } else {
                                System.out.println("ID пользователя указан некорректно.");
                            }
                            System.out.print("Укажите ID книги для передачи пользователю: ");
                            if (scanner.hasNextInt()) {
                                idBookForRealise = scanner.nextInt();
                                scanner.nextLine();
                            } else {
                                System.out.println("ID книги указан некорректно.");
                            }
                            library.addBookForUser(idUserForAddBook, idBookForRealise);
                            break;
                        case 8:
                            int idUserForDeleteBook = -1;
                            int idBookForDeleteRealise = -1;
                            System.out.print("Укажите ID пользователя для передачи книги в библиотеку: ");
                            if (scanner.hasNextInt()) {
                                idUserForDeleteBook = scanner.nextInt();
                                scanner.nextLine();
                            } else {
                                System.out.println("ID пользователя указан некорректно.");
                            }
                            System.out.print("Укажите ID книги для возвращения в библиотеку: ");
                            if (scanner.hasNextInt()) {
                                idBookForDeleteRealise = scanner.nextInt();
                                scanner.nextLine();
                            } else {
                                System.out.println("ID книги указан некорректно.");
                            }
                            library.deleteBookForUser(idUserForDeleteBook, idBookForDeleteRealise);
                            break;
                        case 9:
                            System.out.println("Введите название книги: ");
                            String nameBook = scanner.nextLine();
                            System.out.println("Введите автора книги: ");
                            String authorBook = scanner.nextLine();
                            Book book = new Book(nameBook, authorBook);
                            library.addNewBookInLibrary(book);
                            break;
                        case 10:
                            int idBookEdit = -1;
                            System.out.print("Укажите ID книги для редактирования: ");
                            if (scanner.hasNextInt()) {
                                idBookEdit = scanner.nextInt();
                                scanner.nextLine();
                            } else {
                                System.out.println("ID книги указан некорректно.");
                            }
                            System.out.println("Введите новое название книги: ");
                            String nameBookEdit = scanner.nextLine();
                            System.out.println("Введите нового автора книги: ");
                            String authorBookEdit = scanner.nextLine();
                            Book bookEdit = new Book(nameBookEdit, authorBookEdit);
                            library.editBook(bookEdit, idBookEdit);
                            break;
                        case 11:
                            System.out.print("Укажите ID книги для удаления: ");
                            if (scanner.hasNextInt()) {
                                int idBookForDelete = scanner.nextInt();
                                scanner.nextLine();
                                library.deleteBookFromLibrary(idBookForDelete);
                            } else {
                                System.out.println("ID книги указан некорректно.");
                            }

                        default:
                            System.out.println("Укажите корректный пункт меню.");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Укажите корректный пункт меню.");
                scanner.nextLine();
            }
        }
    }
}
