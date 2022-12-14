package People;

/**
 * Super class for all the users of the restaurant.
 */
public class Person {
    private String name;
    private String phone;
    private String id;
    private String password;

    /**
     * Constructor with a specific name.
     * @param name
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * Constructor with a specific name and phone number.
     * @param name
     */
    public Person(String name, String phone) {
        this(name);

        this.phone = phone;
    }

    /**
     * Getter for a Person id
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * setter for a Persons id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * getter a Persons password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter for a Persons password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for name data field.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for phone data field.
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets a new name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets a new phone
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
