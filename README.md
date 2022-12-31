# NBPConverter

## Description

NBPConverter is an application that convert price from  USD to PLN based on the NPB API(http://api.nbp.pl) for a given day, save it to an XML file and a database, and then display the data from the saved database in the appropriate format.

## WEBSITE
NBPConverter (http://46.41.141.104/)

## Install and Run
1. Create xml file "products.xml" at nbp_converter\src\main\resources\xml\products.xml
```
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<faktura>
</faktura>
```
2. Add execute permission for mvnw file
```
chmod +x mvnw 
```
3. Run
  ```
  ./mvnw clean spring-boot:run
  ```
4. The App is now running at port 8081
