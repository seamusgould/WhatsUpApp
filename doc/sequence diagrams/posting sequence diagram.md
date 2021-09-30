#Posting an Event: A Sequence Diagram

```plantuml

@startuml
hide footbox
actor User as user
participant " : Event" as event
participant " : EventLocation" as evloc

user -->> event **: event = create(creator, date, time, description, location recurrence)
event -->> evloc **: evloc = (roughLocation)


