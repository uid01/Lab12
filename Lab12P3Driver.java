/*
 * Purpose: Data Structure and Algorithms Lab 12 Problem 2
 * Status:  Complete and thoroughly tested 
 * Last update: 04/21/23
 * Submitted:  04/21/23
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Jason Fuscellaro
 * @version: 2023.04.21
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Lab12P3Driver {
    private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

public static void main(String[] args)throws IOException{
        HashTable ht = new HashTable();
        int choice = -1;
        while (choice != 0) {
            System.out.println("Select an option:");
            System.out.println("0.        Exit");
            System.out.println("1.        Insert a [key, associated value] pair in the table.");
            System.out.println("2.        Delete a pair from the table.");
            System.out.println("3.        Retrieve and display the value associated with a key in the table.");
            System.out.println("4.        Display the hashCode of a key.");
            System.out.println("5.        Display the content of the table.");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(stdin.readLine());

            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                insert(ht);
                    break;
                case 2:
                delete(ht);
                    break;
                case 3:
                search(ht);
                    break;
                case 4:
                    hashcode(ht);
                    break;
                case 5:
                {
                    System.out.println(ht.toString());
                }
                break;
            }
        }
    }

    private static void search(HashTable ht) throws IOException{
        System.out.print("Enter the key of the item to search for: ");
        String key = stdin.readLine();
        System.out.println(key);
        Object item = ht.tableRetrieve(key);
        if (item == null) 
        {
            System.out.println("Item with key '" + key + "' not found in ht.");
        } 
        else 
        {
            System.out.println("Item with key '" + key + "' found in ht:\n" + item.toString());
        }
        
        }
    

    private static void insert(HashTable ht) throws IOException {
        System.out.print("Enter the key of the item to insert: ");
        String key = stdin.readLine();
        System.out.println(key);

        System.out.print("Enter the value: ");
        String assocstring = stdin.readLine();
        System.out.println(assocstring);
        Object existingItem = ht.tableRetrieve(key);
        if (existingItem != null) 
        {
            System.out.println("Item with key '" + key + "' already exists in ht and cannot be inserted again.");
        } 
        else 
        {
            ht.tableInsert(key, assocstring);
            System.out.println("Item " + assocstring + " inserted into ht with key " + key);
        }
    }

    private static void delete(HashTable ht)throws IOException {
        System.out.print("Enter the key of the item to delete: ");
        String key = stdin.readLine();
        System.out.println(key);
        Object existingItem = ht.tableRetrieve(key);
        if(existingItem != null)
        {
            System.out.println("Item " + "'" + key + "'" + " deleted.");
            ht.tableDelete(key);
        }
        else
        {
            System.out.println("Item does not exist, cannot delete a non-existent item!");
        }
    }
    private static void hashcode(HashTable ht) throws IOException{
        System.out.print("Enter the key you would like the hashcode for: ");
        String key = stdin.readLine();
        System.out.println(key);
        System.out.println("Hashcode : " + ht.hashCode(key));
        }

  
}

