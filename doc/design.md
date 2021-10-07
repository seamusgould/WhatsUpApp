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
