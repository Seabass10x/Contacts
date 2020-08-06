package contacts;

import java.util.Scanner;

public class Main {

    static class Contact {

        String name;
        String surname;
        String phoneNumber;

        public Contact(String name, String surname, String phoneNumber) {
            this.name = name;
            this.surname = surname;
            this.phoneNumber = phoneNumber;
            System.out.println("A record created!");
        }
    }

    static class PhoneBook {

        Contact contact;

        public PhoneBook(Contact contact) {
            this.contact = contact;
            System.out.println("A Phone Book with a single record created!");
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the person:");
        String name = scanner.nextLine();
        System.out.println("Enter the surname of the person:");
        String surname = scanner.nextLine();
        System.out.println("Enter the number:");
        String phoneNumber = scanner.nextLine();

        Contact contact = new Contact(name, surname, phoneNumber);
        PhoneBook phoneBook = new PhoneBook(contact);


    }
}
