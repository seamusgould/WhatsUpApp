# Find Activity
**Scope:** Campus activity application  

**Level:** User goal  

**Primary actor:** Viewer  

**Stakeholders and Interests:**  
- **Viewer:** Wants to quickly find out what is happening, when the activity starts and ends, and where on campus it is happening. Does not want to see events that are not actually happening.  
- **Poster:** Wants to share information about activity with other users.  

**Preconditions:**  
- User is identified and authenticated.  

**Postconditions (or success guarantee):**  
- Activities are successfully displayed.  
- An activity can be viewed in detail.
 
**Main success scenario:**  
1. Viewer opens the app with the intention of finding activity.  
2. System displays activities that are happening at the current time or in the near future.  
3. Viewer views the list of activities.  
4. Viewer chooses an activity to view in more detail.  
5. Viewer closes the app after finding an activity.  

**Extensions (or alternate flows):**  
1a. The application fails to start
1. Viewer can restart or contact the dev team
4a. Viewer wishes to view more activities  
1. The viewer can repeat steps 3-4 as long as they would like.

4b. Viewer wishes to indicate that they like or dislike a posted activity
1. The viewer can upvote or downvote an activity when viewing it in detail.

**Special requirements:**  
- Touch screen UI.
- List of activities and map must be readable on a phone screen (e.g. large enough text, scrollable list, high-resolution map image).  
- Activity categories must be displayed when viewing activities on the map, in the list, and in detail.  

**Technology and data variations list:**  
3a. Touch screen is used to navigate.  
4a. Touch screen is used to navigate.  

**Frequency of occurrence:**  
Very frequent