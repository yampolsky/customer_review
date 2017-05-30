How to run:

0. Make sure you have Java 8 installed and system environment PATH variable is set to $JAVA_HOME/bin
   run 'java -version' in the shell, to check the version of Java
1. Unzip given file
2. Run shell (cmd, or Unix shell)
3. Navigate to the folder <Unzip location>\HomeDepotTest\target
4. run the following:
    java -jar customerreview-0.0.1-SNAPSHOT.jar
5. wait for a min till you see "Started HomeDepotTestApplication in DD.DDD seconds"
6. Open browser and go to localhost:8080
    You should see the simple UI with few fields
    
------

How to see results URLs:

http://localhost:8080 : to add comment/user (check validation)
http://localhost:8080/hd/words : to see list of words prohibited in comment
http://localhost:8080/hd/comment : to see comments
http://localhost:8080/hd/customer : to see customers and their comments
http://localhost:8080/h2-console : to see DB console, 
                                NOTE: USE the following JDBS URL: "jdbc:h2:mem:TEST;DB_CLOSE_DELAY=-1;MODE=Oracle"
                                password is empty

http://localhost:8080/hd/count?from=1&to=6 : to get the report of product’s total number of customer reviews whose ratings are within a given range (inclusive).

------

Explanantions:

- All data including curse words, comments, castomers, etc are stored in H2 database. Database is populated on startup time from SQL scrpts (...HomeDepotTest\src\main\resources\data-h2.sql, ...HomeDepotTest\src\main\resources\schema-h2.sql)

- Validation of input form is done using Hibernate validation, check anotations in ...HomeDepotTest\src\main\java\de\hybris\platform\customerreview\modelui\CommentForm.java

- There is one custom annotation for curse words, other annotations are standard.

- Report for product total numbers... is done using HQL query. see HomeDepotTest\src\main\java\de\hybris\platform\customerreview\dao\impl\DefaultCustomerReviewDao.java; public List<ReviewCountReport> getReviewCountReport(Integer ratingFrom, Integer ratingTo)

------

NOTE:
You can import project to the Eclipse its maven project File->Import->Existing Maven Project 