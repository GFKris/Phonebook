// Kris Mcfarland
// this class implements a listNode for 
// managing a phonebook of contacts

public class PhonebookManager {
   private ListNode front;
   
   // constructs an empty list
   public PhonebookManager() {
      front = null;
   }
   
   // returns the phonebook entries 
   public String toString() {
      if (front == null) {
         return "No Entries Found";
      } else {
         String result = "\n" + front.fName + " " + front.lName + "\n" +
                         front.address + "\n" + front.city + "\n" +
                         front.phone + "\n";
         ListNode current = front.next;
         while (current != null) {
            result += "\n" + current.fName + " " + current.lName + "\n" +
                         current.address + "\n" + current.city + "\n" +
                         current.phone + "\n";
            current = current.next;
         }
         return result;
      }
   }
   
   // appends a phonebook entry the end of the phonebook list
   public void add(String fName, String lName, String address, String city, String phone) {
      if (front == null) {
         front = new ListNode(fName, lName, address, city, phone);
      } else {
         ListNode current = front;
         while (current.next != null) {
            current = current.next;
         }
         current.next = new ListNode(fName, lName, address, city, phone);
      }
   }
   
   // gets the index of phonebook node
   public int indexOf(String search) {
      int index = 0;
      ListNode current = front;
      while (current != null) {
         if(current.fName.equals(search) || current.lName.equals(search)) {
            return index;
         } else if(current.address.equals(search)) {
            return index;
         } else if(current.city.equals(search)) {
            return index;
         } else if (current.phone.equals(search)) {
            return index;
         }
         index++;
         current = current.next;
      }
      return -1;
   }
   
   // removes the index at the specified node
   public void remove(int index) {
      if (index == 0) {
         front = front.next;
      } else {
         ListNode current = nodeAt(index - 1);
         current.next = current.next.next;
      }
   }
   
   // loops through nodes
   private ListNode nodeAt(int index) {
      ListNode current = front;
      for (int i = 0; i < index; i++) {
         current = current.next;
      }
      return current;
   }
   
   // returns all the data for an node at given index
   public String get(int index) {
      String contact = nodeAt(index).fName + " " +
                       nodeAt(index).lName + "\n " +
                       nodeAt(index).address + "\n " +
                       nodeAt(index).city + "\n " +
                       nodeAt(index).phone + "\n";                         
      return contact;
   }
   
   // edit list node name
   public void editName(int index, String first, String last) {
      nodeAt(index).fName = first;
      nodeAt(index).lName = last;
   }
   
   // edit list node address
   public void editAddress(int index, String editAddress) {
      nodeAt(index).address = editAddress;
   }
   
   // edit list node city
   public void editCity(int index, String editCity) {
      nodeAt(index).city = editCity;
   }
   
   // edit list node phone
   public void editPhone(int index, String editPhone) {
      nodeAt(index).phone = editPhone;
   }
   
} // end of PhoneBookManager class