Explanantions:

- All data including curse words, comments, castomers, etc are stored in H2 database. Database is populated on startup time from SQL scrpts (...\src\main\resources\data-h2.sql, ...\src\main\resources\schema-h2.sql)

- Validation of input form is done using Hibernate validation, check anotations in ...\src\main\java\de\hybris\platform\customerreview\modelui\CommentForm.java

- There are two custom annotations. One for curse words, and another one cross-field validation, to make sure that ratingFrom is less than ratingTo. All other annotations (for rating be greater that 0 ...) are standard.

- Report for product total numbers of customer reviews whose ratings are within a given range (inclusive) is done using HQL query. see Class: ...\src\main\java\de\hybris\platform\customerreview\dao\impl\DefaultCustomerReviewDao.java; The metog: public List<ReviewCountReport> getReviewCountReport(Integer ratingFrom, Integer ratingTo)

------

NOTE:
You can import project to the Eclipse it's a maven project do File->Import->Existing Maven Project ->folow the instructions

Alternatively, you can build the project from SHELL. You will need Maven and Java 8 to be installed. Do "mvn clean install" in folder with  pom.xml file (.../src)

------
How to run:

0. Make sure you have Java 8 installed. and project is built (using IDE or Maven)
1. Unzip given file (skip if you clone the repo)
2. Run SHELL 
3. Change directory to the folder ...\target
4. run the following:
    java -jar customerreview-0.0.1-SNAPSHOT.jar
5. wait for a min till you see "Started HomeDepotTestApplication in DD.DDD seconds"
6. Open browser and go to localhost:8080
    You should see the simple UI with few fields
    
------

Check the following URLs:

http://localhost:8080 : to add comment/user (to check comment validation)

http://localhost:8080/hd/words : to check list of words prohibited in comment

http://localhost:8080/hd/comment : to see comments

http://localhost:8080/hd/customer : to see customers and their comments

http://localhost:8080/h2-console : to see DB console, 
                                NOTE: USE the following JDBS URL: "jdbc:h2:mem:TEST;DB_CLOSE_DELAY=-1;MODE=Oracle"
                                password is empty

http://localhost:8080/hd/count?from=1&to=6 : to get the report of product’s total number of customer reviews whose ratings are within a given range (inclusive). 'from' for ratingFrom, 'to' is for ratingTo

------

