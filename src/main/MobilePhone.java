package main;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> myContacts;
    private String myNumber;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts=new ArrayList<>();
    }
    public boolean addNewContact(Contact contact){
       if(contact==null || contact.getName()== null || contact.getPhoneNumber()==null ){
       return false;
       }
       if(findContact(contact.getName())>=0){
           return false;
       }
       this.myContacts.add(contact);
       return true;
    }
    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }
    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
    public boolean updateContact(Contact oldContact, Contact newContact){
        int oldContactIndex = findContact(oldContact);
        if(oldContactIndex<0){
            return false;
        }
        this.myContacts.set(oldContactIndex, newContact);
        return true;
    }

    public boolean removeContact(Contact contact){
        if (findContact(contact.getName()) < 0) {
            return false;
        }
        this.myContacts.remove(contact);
        return true;
    }
    public Contact queryContact(String contactName){
        int index = findContact(contactName);
        if (index >= 0) {
            return this.myContacts.get(index);
        }
        return null;
    }
    public void printContacts() {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            System.out.println((i + 1) + "->" + contact.getName() + "->" + contact.getPhoneNumber());
        }
    }
}
