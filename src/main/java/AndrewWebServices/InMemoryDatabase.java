package AndrewWebServices;

import java.util.HashMap;
import java.util.Map;

/*
 * InMemoryDatabase is a fake for the AndrewWS database which is used to improve test efficiency.
 * Remember, fakes are fully functional classes with simplified implementation.
 * What is the simplest core functionality that we need for a functional database?
 * 
 * Hint: there are two methods you need to implement
 */
public class InMemoryDatabase extends Database {
    // Implement your fake database here
    private final Map<String,Integer> accounts = new HashMap<>();

    public InMemoryDatabase(){
        accounts.put("Scotty", 17214);
    }

    @Override
    public int getPassword(String name){
        return accounts.getOrDefault(name, 0);
    }
}