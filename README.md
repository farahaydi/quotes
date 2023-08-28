# Lab 08
in this lab I'm start daeling with **Gson** and reading a Json File I'll provide you to steps throw my project:

> Implement an External Library Called Gson
- quotes -> app -> bulid.gradle => inside it in dependencies we should put the implementation for our library
- this library help us to convert from Java object to Json and vise versa.

> Store The Json File In Our Resources 


> Create Class Called RecentQuotes [RecentQuotes](app/src/main/java/quotes/RecentQuotes.java)
- we create this class to convert Json Quote and Author to object for this class.
- we create to 2 method : 1- getText 2- getAuthor

> Read Json File In App.java [App](app/src/main/java/quotes/App.java)
- I'm using **BufferedReader** to read the Json file from resources 
- I take object from Gson 
- I take an array object from RecentQuotes class and inside this obj i store gson.fromJson(readQuotes, RecentQuotes[].class);
- this method take a Json file I want to read and class i want to convert Json file to it's object.
- I use a class Random to take a quotes randomly 
- in Random class I generete a randome int number as index and return the Quote and Author in this Index.

> Make A Test [Testing](app/src/test/java/quotes/AppTest.java)
- in test I make a one test called **testQuotes** this test use InputStream to read file 
- I use assertTrue and assertFalse to test my work
-  You can use this command **./gradlew** test to test my work