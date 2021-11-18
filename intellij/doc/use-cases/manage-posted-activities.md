# Manage Posted Activities
**Scope:** Campus activity application

**Level:** User goal

**Primary actor:** Poster

**Stakeholders and Interests:**
- **Poster:** Wants to ensure that information about their event is up to date, wants to remove events that have been cancelled.

**Preconditions:**
- User is identified and authenticated.

**Postconditions (or success guarantee):**
- Information about an event is successfully changed or deleted from the list of events.

**Main success scenario:**
1. User opens the app.
2. System displays the list of activities.
3. User can select an event they posted from the list of activities.
4. User can edit the attributes of the event (e.g. changing location from Quad to Library Lawn).
5. System displays the updated event on the list of activities.

**Extensions (or alternate flows):**  
1a. The application fails to start
1. Viewer can restart or contact the dev team
   3a. There are no events on the list of activities that have been posted by this user
1. The user cannot make changes to activities that they did not post. The option to modify or delete any of the activities will not be shown.
   4a. Viewer wishes to delete the event
1. User chooses to delete the event.
2. The event is removed from the list of events.

**Special requirements:**
- Touch screen UI.

**Technology and data variations list:**  
None

**Frequency of occurrence:**  
Occasional
