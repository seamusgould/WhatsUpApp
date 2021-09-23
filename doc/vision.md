We envision a crowdsourcing app where people would share information about how full/active/vibrant different parts of campus are at 
any given moment. Could eventually be used to organize/promote events around campus. Can be extended to other schools.

Business Case:
Our software addresses customer needs that other products do not:
1. It can enable students to notify the campus community for events.
2. It allows other students to see what events are taking place on campus as well.
3. It integrates with some background information of each user to quantify the reliability of an event.

Key features summary:
• Creating a login so that credited students are the only ones who have access
• Displaying a map of the locations of events on campus.
• Allowing users to upload information on a future event.
• Allowing users to view events that are already happening on campus.
• An upvote and downvote mechanism that can be saved to identify the relibaility of a user.

```plantuml
@startuml
' human actors
actor "Cashier" as cashier
actor "Customer" as customer
actor "Manager" as manager
' system actors
actor "Accounting system" <<system>> as accountingSystem
actor "Tax calculator" <<system>> as taxCalculator
actor "Payment auth service" <<system>> as payAuthService
' list all use cases in package
package "NextGen POS"{ usecase "Process sale" as procSale }
' list relationships between actors and use cases
customer --> procSale
cashier --> procSale
manager --> procSale
processSale --> accountingSystem
processSale --> taxCalculator
processSale --> payAuthService
@enduml
```

