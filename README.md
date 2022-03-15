# DPST-Vinyl-Records
## DFESW9 Project - VinylRecords


A QA project designed to allow the storing of a 7" Vinyl record collection along with locations.


Added Jira integration. 07/03/2022 SDT.

Simplified ERD diagram 08/03/2022

![ERD diagram][simple]

[simple]:./QA-DPST-Vinyl-Records-simp.png

#### Did you know?
There are about 130,000,000 songs in the world (created in 1200 years)

The average person will listen to only about 10,000 of these in their lifetime. source: https://medium.com/pragyan-blog/will-we-ever-run-out-of-new-music-526773566f7c

Spotify has a library of 82,000,000 songs (as of 2022) source: https://newsroom.spotify.com/company-info/



#### Jira dashoard:
![Jira-dash2][Jira2]

[Jira2]:./QA-project-Jira-dashboard2.png


###Issues along the way:

first off condition appears to be a reserved word, so the variable was changed to observation.

I found "Record" was flagging as a "Class of records" - a preview feature of the Java Language! 
I just had to make sure to import com.qa.project.domain.Record into my other packages.

I got held up on create when posting multiple objects until Chris pointed out that what I was posting was a list of Records, not just a Record.

### Testing using Postman:

<insert screenshots here>

# I spent longer than I should have setting up an Azure MySQL database for this project.
I thought it would be a good idea to use some of my gained knowledge, having recently passed the Azure fundamentals AZ-900 exam as part of this bootcamp.


### POSTMAN url's:

Create:
localhost:8080/record/create		- supply a JSON object containing the record to add.
localhost:8080/record/createMulti	- supply a JSON Array containing 1 or more records.


Read:
localhost:8080/record/list
localhost:8080/record/list/small	- returns a JSON array of records that have a small spindle size.
localhost:8080/record/list/large	- returns a JSON array of records that have a large spindle size.
localhost:8080/record/id/<i>id</i>	- returns a JSON object of a single record 


Update:
localhost:8080/record/update/<i>id</i> - supply a JSON object containing the only the fields that need to be changed


Delete:
localhost:8080/record/delete/<i>id</i> - deletes the record with id

