## Display Shows for a given city, movie and date

#### Use Postman to test 

`http://localhost:8080/shows?movie=<movie>&date=<date>&city=<city>`  
`<movie> = Avatar, Top gun`  
`<date> = From tomorrow to next 7 days (dd-MM-yyyy)`  
`<city> = Hyderabad, Delhi`  

## Book Tickets for a given user & selected show and seats  
`http://localhost:8080/booking`  

Params:  
`user = 1 (Only user with id 1,2 are pre-loaded for testing)`  
`showDetails = 1 (showDetails value is preloaded upto 50 approx.)`    
`seatNumber = J10 (Enter any string value)`  
 
 
