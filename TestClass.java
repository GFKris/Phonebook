// Kris Mcfarland
// CS145 - Winter 23
// Instructor J Ramsey
// Assignment 2
// this program is a test for the phonebook class
// **note on the main menu you can type the full word or
// just the beginning letter of the word
import java.util.*;
public class TestClass {
    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        PhonebookManager Phonebook = new PhonebookManager();
        boolean quit = false;
        // menu loop for managing phonebook
        while (!quit) {
            phonebookMenu();
            System.out.print("Please enter a command:");
            String input = console.nextLine();
            input = input.toUpperCase();
            input = menuChoice(input);
            switch (input) {
                case "ADD":
                    createContact(console, Phonebook);
                    break;
                case "DELETE":
                    deleteContact(console, Phonebook);
                    break;
                case "VIEW":
                    System.out.print(Phonebook);
                    break;
                case "SEARCH":
                    int searchIndex = search(console, Phonebook);
                    System.out.print(Phonebook.get(searchIndex));
                    break;
                case "EDIT":
                    System.out.println("Use search to get the contact to update: ");
                    int editIndex = search(console, Phonebook);
                    edit(console, Phonebook, editIndex);
                    System.out.println("Contact Updated");
                    break;
                case "QUIT":
                    quit = true;
                    break;
                default:
                    System.out.println("Please choose a valid option \n");
            }
        }
    } // end of main
    // creates a new contact - **Fullname must be supplied**
    public static void createContact(Scanner console, PhonebookManager Phonebook) {
        System.out.print("Enter first and last name:");
        String[] fullName = console.nextLine().split(" ");
        System.out.print("Enter address:");
        String address = console.nextLine();
        System.out.print("Enter city:");
        String city = console.nextLine();
        System.out.print("Enter phone number:");
        String phone = console.nextLine();
        Phonebook.add(fullName[0], fullName[1], address, city, phone);
    }

    // deletes a contact. uses the search method to find the contact to delete
    public static void deleteContact(Scanner console, PhonebookManager Phonebook) {
        int index = search(console, Phonebook);
        System.out.println(Phonebook.get(index));
        System.out.print("Delete? (Y/N): ");
        String delChoice = console.nextLine();
        if (delChoice.equals("Y") || delChoice.equals("y")) {
            Phonebook.remove(index);
            System.out.println("Contact Deleted");
        } else if (delChoice.equals("N") || delChoice.equals("n")) {
            System.out.println("Contact Saved");
        } else {
            System.out.println("Invalid reponse");
        }
    }
    // main menu
    public static void phonebookMenu() {
        System.out.print("\n PHONEBOOK MENU \n" +
            "A - Add Contact\n" +
            "D - Delete \n" +
            "V - View Contacts \n" +
            "S - Search \n" +
            "E - Edit\n" +
            "Q - Quit \n\n");
    }
    // menu choice option - the user can type in the first letter of
    // the option or just the first letter. Extra credit??
    public static String menuChoice(String input) {
        switch (input) {
            case "A":
                input = "ADD";
                break;
            case "D":
                input = "DELETE";
                break;
            case "V":
                input = "VIEW";
                break;
            case "S":
                input = "SEARCH";
                break;
            case "E":
                input = "EDIT";
                break;
            case "Q":
                input = "QUIT";
                break;
            default:
                input = input;
        }
        return input;
    }
    // search contacts method
    public static int search(Scanner console, PhonebookManager Phonebook) {
        System.out.print("Search Options: \n" +
            "N - Search by Name \n" +
            "A - Search by Address \n" +
            "P - Search by Phone \n" +
            "C - Search by City \n\n");
        System.out.print("Type Search Option: ");
        String searchType = console.nextLine();
        searchType = searchType.toUpperCase();
        int index = 0;
        if (searchType.equals("N")) {
            System.out.print("type the name of the contact: ");
        } else if (searchType.equals("A")) {
            System.out.print("Type the address: ");
        } else if (searchType.equals("P")) {
            System.out.print("Type the phone number: ");
        } else if (searchType.equals("C")) {
            System.out.print("Type the city: ");
        }
        if (searchType.equals("N")) {
            String[] fullName = console.nextLine().split(" ");
            return index = Phonebook.indexOf(fullName[0]);
        }
        String searchStr = console.nextLine();
        index = Phonebook.indexOf(searchStr);
        return index;
    }
    // edit method - edit based on menu choice
    public static void edit(Scanner console, PhonebookManager Phonebook, int index) {
        System.out.print("Edit Options: \n" +
            "N - Edit Name \n" +
            "A - Edit Address \n" +
            "P - Edit Phone \n" +
            "C - Edit City \n\n");
        System.out.print("Type Edit Option: ");
        String editType = console.nextLine();
        editType = editType.toUpperCase();
        if (editType.equals("N")) {
            System.out.print("type the new name of the contact: ");
            String[] fullName = console.nextLine().split(" ");
            index = Phonebook.indexOf(fullName[0]);
            Phonebook.editName(index, fullName[0], fullName[1]);
        } else if (editType.equals("A")) {
            System.out.print("Type the new address: ");
            String newAddress = console.nextLine();
            Phonebook.editAddress(index, newAddress);
        } else if (editType.equals("P")) {
            System.out.print("Type the new phone number: ");
            String newPhone = console.nextLine();
            Phonebook.editPhone(index, newPhone);
        } else if (editType.equals("C")) {
            System.out.print("Type the new city: ");
            String newCity = console.nextLine();
            Phonebook.editCity(index, newCity);
        }
    }
} // end of TestClass