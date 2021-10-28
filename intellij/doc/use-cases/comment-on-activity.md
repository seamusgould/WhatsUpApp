# Comment on Activity
**Scope:** Campus activity application

**Level:** User goal

**Primary actor:** Viewer

**Stakeholders and Interests:**
- **Viewer:** Wants to communicate to other users of the app information about a particular activity.
- **Poster:** Wants other users to engage with their posted activity.

**Preconditions:**
- User is identified and authenticated.
- Activities are successfully displayed.
- At least one activity is present on the list of activities.
- An activity can be viewed in detail.

**Postconditions (or success guarantee):**
- The activity's collection of comments is updated to include the newly created comment.

**Main success scenario:**
1. Viewer opens the app.
2. System displays activities that are happening at the current time or in the near future.
3. Viewer views the list of activities.
4. Viewer chooses an activity to view in more detail.
5. The comments associated with the activity are displayed. The date and time the comment was posted, the number of upvotes and downvotes the comment has, and which user posted the comment are displayed with the comment text.
6. Viewer chooses the option to add a comment.
7. Viewer enters the text they want as their comment.
8. The newly created comment is added to the collection of comments associated with the activity.

**Extensions (or alternate flows):**  
1a. The application fails to start
1. Viewer can restart or contact the dev team
   6a. Viewer no longer wishes to leave a comment
1. The viewer can exit the comment screen to return to the detailed view of the activity.
   8a. Viewer wishes to leave more than one comment
1. Steps 5-8 can be repeated as often as desired.

**Special requirements:**
- Touch screen UI.
- List of activities and map must be readable on a phone screen (e.g. large enough text, scrollable list, high-resolution map image).

**Technology and data variations list:**  
3a. Touch screen is used to navigate.  
4a. Touch screen is used to navigate.  
5a. Touch screen is used to navigate.  
6a. Touch screen is used to navigate.  
7a. Touch screen and keyboard are used to navigate.

**Frequency of occurrence:**  
Occasional