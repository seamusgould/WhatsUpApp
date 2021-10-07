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