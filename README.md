# DPST-Vinyl-Records

[Jira2]:./QA-project-Jira-dashboard2.png
[simple]:./QA-DPST-Vinyl-Records-simp.png
[post_c]:./qa-project-post_c.png
[post_r1]:./qa-project-post_r1.png
[post_r2]:./qa-project-post_r2.png
[post_u]:./qa-project-post_u.png
[post_d]:./qa-project-post_d.png
[Azure]:./qa-project-AzureDB.png
[github1]:./qa-project-githubNetworkThurs.png
[github2]:./qa-project-GitNetworkGraph.png

## DFESW9 Project - VinylRecords


A QA project designed to allow the storing of a 7" Vinyl record collection along with locations.


Added Jira integration. 07/03/2022 SDT.

https://mototest.atlassian.net/jira/dashboards/10001

ERD diagram:

![ERD diagram][simple]


#### Did you know? ( or Why did I choose to use an int instead of a Long?)

There are about 130,000,000 songs in the world (created in 1200 years)

The average person will listen to only about 10,000 of these in their lifetime. source: https://medium.com/pragyan-blog/will-we-ever-run-out-of-new-music-526773566f7c

Spotify has a library of 82,000,000 songs (as of 2022) source: https://newsroom.spotify.com/company-info/



#### Jira dashoard:

![Jira-dash2][Jira2]




### Issues along the way:

First off, "<strong>condition</strong>" appears to be a reserved word, so the variable name was changed to observation.

I found "<b>Record</b>" was flagging as a "Class of records" - a preview feature of the Java Language! 
I just had to make sure to import com.qa.project.domain.Record into my other packages.

I got held up for a while on my create method when posting multiple records until Chris (Yiangou) pointed out that what I was posting was a list of Records, not just a Record.


#### I spent longer than I should have setting up an Azure MySQL database for this project.
I thought it would be a good idea to use some of my gained knowledge, having recently passed the Azure fundamentals AZ-900 exam as part of this bootcamp.


### Testing using Postman:

### POSTMAN url's:

<u>Create:</u>

localhost:8080/record/create		- supply a JSON object containing the record to add.

localhost:8080/record/createMulti	- supply a JSON Array containing 1 or more records.


<u>Read:</u>

localhost:8080/record/list

localhost:8080/record/list/small	- returns a JSON array of records that have a small spindle size.

localhost:8080/record/list/large	- returns a JSON array of records that have a large spindle size.

localhost:8080/record/id/<i>id</i>	- returns a JSON object of a single record 


<u>Update:</u>

localhost:8080/record/update/<i>id</i> - supply a JSON object containing the only the fields that need to be changed


<u>Delete:</u>

localhost:8080/record/delete/<i>id</i> - deletes the record with id


### Screenshots:

Create:
![postman Create][post_c]

Read:
![postman Read][post_r1]![postman Read custom][post_r2]

Update:
![postman Update][post_u]

Delete:
![postman Delete][post_d]


## GitHub integration:

Github part way through:
![Git hub part-way][github1]

Github at the end of project:
![Github at the end][github2]

&copy; 2022 Simon D. Thornes AMBCS