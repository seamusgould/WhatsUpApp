# Domain Model
```plantuml
@startuml

hide circle
hide empty methods

' classes
class User{
username
profilePicture
karma
}
class EventCollection{
}
class Event{
name
date
time
recurrence
description
upvoteDownvote
posterUsername
}
class Tag{
name
}
class Location{
name
gpsCoordinates
}
class Comment{
date
time
commenterUsername
description
upvoteDownvote
}
class MapDisplay{
}
class Statistics{
}

' associations
User "1" -- "1" EventCollection : \tViews\t\t
User "1" - "*" Event : \tPosts\t\t
EventCollection "1" -- "*" Event : \tLists\t\t
Event "1" - "1" Location : \tHas\t\t
Event "1" - "*" Tag : \tHas\t\t
Event "1" -left- "*" Comment : \tHas\t\t
Comment "1" -up- "1" User : \tIs-posted-by\t\t
Event "*" -- "1" MapDisplay : \tIs-displayed-on\t\t
Event "*" --- "1" Statistics : \tContributes-to\t\t

@enduml
```

# Posting an Event: A Sequence Diagram

```plantuml

@startuml
hide footbox
actor User as user
participant " : EventCollection" as coll
participant " : Event" as event
participant " : EventLocation" as evloc

user -> coll: create event

coll -->> event **: event = create(creator, date, time, description, location, recurrence)
event -->> evloc **: evloc = (roughLocation)

evloc -->> event: finalLocation

coll -> user: Show Event

@enduml
```

# Viewing Events: A Sequence Diagram
```plantuml
@startuml
hide footbox
actor User as user
participant " : EventCollection" as coll
participant " : Event" as event

user -> coll: view

coll -> user: display all events

user -> coll: select particular event

coll -->> event: displayEvent(Event)

coll -> user: displays particular event 

@enduml
```

#Posting an Event: A Class Diagram

```plantuml

@startuml
class User{
- username : String = "John/Jane Doe"
- profilePicture : picture
- karma : double
}

class EventRepository{
- EventList : List<Event> = |Event1 -> Event2 -> Event3 -> ...|
}


class Event{
- name : String = "Club Meeting"
- date : Date = "01/08/2022"
- time : Date = 21:23
- recurrence : Boolean = True
- description : String = 'This event is ...'
- upvoteDonwvote : double = 5
- posterUsername : User = 'John/Jane Doe'
}

class Location{
- name : String = "John/Jane Doe"
- gpsCoordinatesLat : double = 41.686798
- gpsCoordinatesLong : double = -73.895699
}

User ---> "(1..*)Creates Events\n{Event}" Event : \t\t\t\t

Event ---> "(1)Stored in\n{EventRepository}" EventRepository : \t\t\t\t

Event ---> "(1)Stored in\n{EventRepository}" Location : \t\t\t\t

User ---> "(1..*)Can View\n{Event}" EventRepository : \t\t\t\t

@enduml
```
