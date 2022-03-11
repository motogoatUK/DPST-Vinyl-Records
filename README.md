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
