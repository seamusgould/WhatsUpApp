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
description
upvoteDownvote
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
Event "*" --- "1" Statistics : \tContributes-to\t\t

@enduml
```

# Posting an Event: A Sequence Diagram

```plantuml

@startuml
hide footbox
actor User as user
participant " : Controller" as cont
participant " : EventCollection" as coll
participant " : Event" as event
participant " : Location" as evloc

user -> cont: create event (name, date, time, description, location, recurrence)
cont -> event: event = create(name, date, time, description, location, recurrence)
coll -->> event **: event = create(name, date, time, reecurrence, description, poster, roughLocation).;
event -->> evloc **: evloc = (roughLocation)

evloc -->> event: finalLocation

cont -> coll: addEvent(e)

@enduml
```

# Viewing Events: A Sequence Diagram
```plantuml
@startuml
hide footbox
actor User as user
participant " : Controller" as cont
participant " : EventCollection" as coll
participant " : Event" as event

user -> cont: view events

cont -> coll: display events

user -> cont: select particular event

cont -> event: displayEvent(Event)

event -> cont: displays particular event 

@enduml
```

# Class Diagram

```plantuml

@startuml
class User{
- username : String = "John/Jane Doe"
- profilePicture : picture
- karma : double
}

class EventCollection{
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

Event ---> "(1)Stored in\n{EventCollection}" EventCollection : \t\t\t\t

Event ---> "(1)Stored in\n{EventCollection}" Location : \t\t\t\t

User ---> "(1..*)Can View\n{Event}" EventCollection : \t\t\t\t

@enduml
```
