public class ListNode {
    public String fName;
    public String lName;
    public String address;
    public String city;
    public String phone;
    public ListNode next;

    // constructs empty contact
    public ListNode() {
    this("","","","","", null);
    }

    // constructs a contact when no phone number is given
    public ListNode(String fName, String lName, String address, String city, String
    phone) {
    this(fName, lName, address, city, phone, null);
    }

    // constructs a contact when only a name is given
    public ListNode(String fName, String lName) {
    this(fName, lName,null,null,null, null);
    }

    // constructs a contact when all information is provided
    public ListNode(String fName, String lName, String address, String city, String
    phone, ListNode next ) {
    this.fName = fName;
    this.lName = lName;
    this.address = address;
    this.city = city;
    this.phone = phone;
    this.next = next;
    }

} // end of class ListNode
