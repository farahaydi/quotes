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

//----------------------------------------------------------------------------------------------------------------------
# Lab 09
in this lab I'm start working with **Getting HTTP data in Java with HttpURLConnection** as this :
> I Create a function for read a data from Api called **readFromApi**
> start with set up the URL using URL class
> open a connection between your java app and url=> Using HttpURLConnection
> use openConnection() method
>  I'm use a InputStreamReader it's read a data as a Stream => mean block of data 
> I'm use a bufferReader to read this stream as Chunk or piece
> Store each line from bufferReader in quoteData String.
> use Gson to convert json data into java object.
> class **MainQuote** -> this class contain 2 Attribute I use this Class to store data coming from API.
> I take an Object from this class call mainQuote and use method **from Json** to convert Json data(fromApi)into object type MainQuote.
> **RecentQuote Class we use it on lab 8 to store a static Json file into it**
> I'm creating an array from type RecentQuotes => to store object from type RecentQuotes inside this array.
> I'm Reading the Json File(this file contain many Quotes) using BufferReader and store it in existingReader.
> I take an Object from this class call RecentQuotes and use method **from Json** to convert Json data(from Exsisting File)into object type RecentQuotes.
> in catch initializes existingQuotes as an empty array of RecentQuotes
//****************************************************************************************
> I'm creating 2 String variable to store Quote and Author that we take from API.
> call the RecentQuotes constructor and just pass to this constructor Quote and Author (beacause the other data is different between api data and RecentQuot class), i'm Sending the other data as empty.
> Create Array List From Type RecentQuotes and send the exsisting json file to it(to save previous the data after I run the project)
> add a object we take from RecentQuotes that i pass a 2 String variable in constructor to the arrayList
> write a new file that contain existingQuotes and new Quotes we take from Api
> convert the updatedQuotesList (which is a list of RecentQuotes objects) into a JSON representation and then write that JSON data to a file specified by the writeToFile FileWriter
> in catch if there is any Error Happen it will print "An error occurred while trying to fetch data from the API."
and it's will print the error then will call a readFile(); that print a Quote and Author from File Already exsisting (as we create on lab8)
