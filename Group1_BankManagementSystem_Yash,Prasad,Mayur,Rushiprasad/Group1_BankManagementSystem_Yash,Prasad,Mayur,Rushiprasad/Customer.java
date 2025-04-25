package yash;

public class Customer {
    private int customerID;
    private String name, address, contact;

    public Customer(int customerID, String name, String address, String contact) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public int getCustomerID() { return customerID; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getContact() { return contact; }

    @Override
    public String toString() {
        return "Customer ID: " + customerID + ", Name: " + name;
    }
}
