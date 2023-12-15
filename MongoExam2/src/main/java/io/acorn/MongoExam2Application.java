package io.acorn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 간단하게 테스트 할 때 CommandLineRunner 주입받기
 */
@SpringBootApplication
@EnableMongoRepositories
public class MongoExam2Application implements CommandLineRunner{
	@Autowired
	ItemRepository groceryItemRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(MongoExam2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("------CREATE GROCERY ITEMS-----\n");
		createGroceryItems();
		
		System.out.println("------SHOW ALL GROCERY ITEMS-----\n");
		showAllGroceryItems();
		
		System.out.println("------SHOW ByName GROCERY ITEMS-----\n");
		getGroceryItemByName("Dried Whole Red Chilli");
		
		System.out.println("------SHOW CATEGORY GROCERY ITEMS-----\n");
		getItemsByCategory("snacks");
	}
	
	//CREATE
    void createGroceryItems() {
        System.out.println("Data creation started...");
        groceryItemRepo.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
        groceryItemRepo.save(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
        groceryItemRepo.save(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
        groceryItemRepo.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
        groceryItemRepo.save(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
        System.out.println("Data creation complete...");
    }
    
    // READ
    // 1. Show all the data
    public void showAllGroceryItems() {
        groceryItemRepo.findAll().forEach(item -> System.out.println(getItemDetails(item)));
    }
    
    // Print details in readable form
    public String getItemDetails(GroceryItem item) {
        System.out.println(
	    "Item Name: " + item.getName() + 
	    ", \nQuantity: " + item.getQuantity() +
	    ", \nItem Category: " + item.getCategory()
	    );
	     
	    return "";
     }
    
    // 2. Get item by name
    public void getGroceryItemByName(String name) {
        System.out.println("Getting item by name: " + name);
        GroceryItem item = groceryItemRepo.findItemByName(name);
        System.out.println(getItemDetails(item));
    }  
    
    // 3. Get name and quantity of a all items of a particular category
    public void getItemsByCategory(String category) {
        System.out.println("Getting items for the category " + category);
        List<GroceryItem> list = groceryItemRepo.findAll(category);
        
        list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity()));
    }
     
    // 4. Get count of documents in the collection
    public void findCountOfGroceryItems() {
        long count = groceryItemRepo.count();
        System.out.println("Number of documents in the collection: " + count);
    }
}
