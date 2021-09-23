We envision a crowdsourcing app where people would share information about how full/active/vibrant different parts of campus are at 
any given moment. Could eventually be used to organize/promote events around campus. Can be extended to other schools.

Business Case:
Our software addresses customer needs that other products do not:
1. It can enable students to notify the campus community for events.
2. It allows other students to see what events are taking place on campus as well.
3. Saves information on each activity and updates based on user input
4. Allows users to upvote and downvote events based on their credibility.
5. It integrates with some background information of each user to quantify the reliability of an event.

Key features summary:
• Creating a login so that credited students are the only ones who have access<br />
• Displaying a map of the locations of events on campus.<br />
• Allowing users to upload information on a future event.<br />
• Allowing users to view events that are already happening on campus.<br />
• An upvote and downvote mechanism that can be saved to identify the relibaility of a user.<br />
• One constraint that we have is that we want the time of the app to be as fast as possible, tht is,
 make it work in less than three seconds to upload and view an event.<br />
• Making a database that can keep track of users and verify their credibility.<br />

```plantuml

@startuml

left to right direction

skinparam packageStyle rectangle

actor Planner
actor Student

rectangle EventApp {
    Student ---> (Database)
    Planner ---> (Database)
    Planner ---> (Post Event to Database)
'    actor "Accounting system" <<system>> as accountingSystem
}

@enduml

```

