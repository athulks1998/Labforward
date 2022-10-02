

   Labnotebook Search
---------------------------------

The Application  has a  REST API which accepts a Json as Request which contains the labentry ID and the word to be searched. The response is 
a Json that returns the frequency of exact matching words as well as the list of words that are similar . 

Researchers can use this functionality to search the whole lab entry to find a keyword ignoring small typos.

A Brief design(Design.docx) has been commited with the the project specifying the request and response Structure along with the psuedocode and other releveant information regarding 
the development of this feature  

API Collection - A postman collection of the API is also added with the code 


Time Dedicated 
--------------
  Backend Task :

  1 hour  on the design and refreshing Spring framework concepts 
  30- 45 minutes on the test cases implementation considering the different test scenarios
  3 hours on Implementation  considering unexpected issues during the implementation 
  30 minutes on final test cases running and self review of the code 
    
  UI Task  : 45 mins - 1 hour  spent on Creating the   UI_Task.html


What could have been done if more time was provided- 

  I have created the dummy lab entries during the startup of the application which could have been avoided by creating  one API that could create new lab entries . 
Also if more time was given we could have considered multiple small scenarios such as  trimming the space in the start and end of the word before performing the 
search  which would be more effective . 


UI Bonus Task 
-------------
A  small mock html has been attached which searches for the word 'Medical'.
The word can be recieved as a search input in the view page of a lab notebook entry . when the search is completed exact match alert is shown which displays the Number of exact match 
. The exact matches are highlighted as green while similar words are highlighted in yellow . One Other thing I would have considered is showing similar words as buttons or tags on an 
overlay panel after the search  and on click the entry is scrolled automatically to show the user the exact position of the word .

The user can also use this to find any small typos in the lab entry 
