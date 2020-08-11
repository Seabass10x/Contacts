package contacts;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static class Contact {

        private String name;
        private String surname;
        private String phoneNumber;

        public Contact() {
            this.name = "";
            this.surname = "";
            this.phoneNumber = "";
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setName(String name) {
            this.name = name;
        }
        public void setSurname(String surname) {
            this.surname = surname;
        }

        public void setPhoneNumber(String phoneNumber) {
            if (isValidPhoneNumber(phoneNumber)) {
                this.phoneNumber = phoneNumber;
            } else {
                this.phoneNumber = "";
                System.out.println("Wrong number format!");
            }
        }

        private boolean isValidPhoneNumber(String phoneNumber) {
            return phoneNumber.matches("\\+?((\\([0-9a-zA-Z]+\\))([ -][0-9a-zA-Z]{2,})*|" +
                    "([0-9a-zA-Z]+[ -]\\([0-9a-zA-Z]{2,}\\))([ -][0-9a-zA-Z]{2,})*|" +
                    "[0-9a-zA-Z]+([ -][0-9a-zA-Z]{2,})*)");
        }
    }

    public static class PhoneBook {

        private final ArrayList<Contact> contacts;

        public PhoneBook() {
            this.contacts = new ArrayList<>();
        }

        public void addContact(Contact contact) {
            this.contacts.add(contact);
            System.out.println("The record added.");
        }

        public void removeContact(int index) {
            this.contacts.remove(index);
            System.out.println("The record removed!");
        }

        public void editContact(int index, String field, String value) {
            switch (field) {
                case "name":
                    contacts.get(index).setName(value);
                    break;
                case "surname":
                    contacts.get(index).setSurname(value);
                    break;
                case "number":
                    contacts.get(index).setPhoneNumber(value);
                    break;
            }
        }

        public int countContacts() {
            return contacts.size();
        }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < countContacts(); i++) {
                str.append(i + 1).append(". ").append(contacts.get(i).getName()).append(" ").append(contacts.get(i)
                        .getSurname()).append(", ");
                if (contacts.get(i).getPhoneNumber().equals("")) {
                    str.append("[no number]").append("\n");
                } else {
                    str.append(contacts.get(i).getPhoneNumber()).append("\n");
                }
            }
            return str.toString();
        }
    }

    public enum MenuState {

        MAIN("main"),
        ADD("add"),
        REMOVE("remove"),
        EDIT("edit"),
        COUNT("count"),
        LIST("list"),
        EXIT("exit");

        String action;

        MenuState(String action) {
            this.action = action;
        }

        public static MenuState findByAction(String action) {
            for (MenuState value : values()) {
                if (action.equals(value.action)) {
                    return value;
                }
            }
            return MAIN;
        }
    }

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        MenuState menuState = MenuState.MAIN;
        while (menuState != MenuState.EXIT) {
            switch (menuState) {
                case MAIN:
                    System.out.print("Enter action (add, remove, edit, count, list, exit): ");
                    menuState = MenuState.findByAction(scanner.next());
                    break;
                case ADD:
                    Contact contact = new Contact();

                    System.out.print("Enter the name: ");
                    contact.setName(scanner.next());
                    System.out.print("Enter the surname: ");
                    contact.setSurname(scanner.next());
                    System.out.print("Enter the number: ");
                    scanner.nextLine();
                    contact.setPhoneNumber(scanner.nextLine());

                    phoneBook.addContact(contact);

                    menuState = MenuState.MAIN;
                    break;
                case REMOVE:
                    if (phoneBook.countContacts() == 0) {
                        System.out.println("No records to remove!");
                    } else {
                        System.out.print(phoneBook);
                        System.out.print("Select a record: ");
                        phoneBook.removeContact(scanner.nextInt() - 1);
                    }
                    menuState = MenuState.MAIN;
                    break;
                case EDIT:
                    if (phoneBook.countContacts() == 0) {
                        System.out.println("No records to edit!");
                    } else {
                        System.out.print(phoneBook);
                        System.out.print("Select a record: ");
                        int index = scanner.nextInt() - 1;
                        System.out.print("Select a field (name, surname, number): ");
                        String field = scanner.next();
                        System.out.print("Enter " + field + ": ");
                        scanner.nextLine();
                        String value = scanner.nextLine();
                        phoneBook.editContact(index, field, value);
                    }
                    menuState = MenuState.MAIN;
                    break;
                case COUNT:
                    System.out.println("The Phone Book has " + phoneBook.countContacts() + " records.");
                    menuState = MenuState.MAIN;
                    break;
                case LIST:
                    System.out.print(phoneBook);
                    menuState = MenuState.MAIN;
                    break;
            }
        }

    }


    public static void main(String[] args) {

        mainMenu();

    }
}
