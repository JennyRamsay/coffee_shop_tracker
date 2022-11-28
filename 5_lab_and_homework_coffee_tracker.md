# Lab + Homework

Given the basic code for classes and JpaRepositories for a Coffee tracker, your task for this lab is to complete the custom queries and connected them to appropriate RESTful endpoints.

## Making sure the database is clean and ready to use

Open Postico go to the database coffees (If it exists).
If it does exist then right click on it and say delete to remove it so that you are starting from a fresh start point.
Open a terminal and type in ```createdb coffees``` to create a fresh Database.
Note that this is only needed for the purposes of lessons ordinarily you would use the same Database and not delete it every time.

NB: If you had to change the username by which you connect to the database in the previous lessons you will need to change it again in the application.properties under the main->resources folder.

**Coffee**

- `name` - the name of that individual coffee often uses the name of the coffee shop. 
- `coffeeShop` - the Coffee Shop object that it's related to
- `strength` - the strength of the coffee( 1- weak -> 12- Strongest )
- `age` - The number of months since the coffee was initially harvested.

**Coffee Shop**

- `name` - The name of the coffee shop.
- `region` - The region where the coffee they stock is from. These are one of either {**Jamaica**, **Brazil**, **Colombia**, **Costa Rica**, **Ethiopia**, **Honduras**, **Indonesia**, **Hawaii**, **Kenya** }
- `coffees` - the list of related coffees tracked against that Coffee Shop

## Task

**Custom Queries + REST** Write each of the following queries and connect them to an appropriate controller:

### MVP
  * Get all the coffees harvested with a particular strength
  * Get all the coffee shops stocking coffee for a particular region.
  * Get all the coffee from a particular coffee shop that's a specific age.
  
###  Extensions
  * Get all the coffee from a particular region. 
  * Get coffee shops that have coffee that where harvested 6 years ago.



## Tips
* To stop your custom routes recursively referencing each other's properties, you will need a `@JsonIgnoreProperties("some_property_you_need_to_ignore")` annotation on related properties.


