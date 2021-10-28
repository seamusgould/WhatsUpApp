# Upvote/Downvote Activity
**Scope:** Campus activity application

**Level:** User goal

**Primary actor:** Viewer

**Stakeholders and Interests:**
- **Viewer:** Wants to communicate to other users of the app whether or not they like a posted activity.
- **Poster:** Wants other users to engage with their posted activity.

**Preconditions:**
- User is identified and authenticated.
- At least one activity is present on the list of activities.

**Postconditions (or success guarantee):**
- Activities are successfully displayed.
- An activity can be viewed in detail.
- The viewer can choose to upvote or downvote the activity.
- The activity's number of upvotes and downvotes is updated based on the viewer's action.

**Main success scenario:**
1. Viewer opens the app.
2. System displays activities that are happening at the current time or in the near future.
3. Viewer views the list of activities.
4. Viewer chooses an activity to view in more detail.
5. Viewer chooses the upvote option or downvote option for the activity displayed in detail.

**Extensions (or alternate flows):**  
1a. The application fails to start
1. Viewer can restart or contact the dev team  

4a. Viewer wishes to upvote or downvote more than one activity
3. Steps 2-5 can be repeated as long as the viewer would like.

**Special requirements:**
- Touch screen UI.
- List of activities and map must be readable on a phone screen (e.g. large enough text, scrollable list, high-resolution map image).

**Technology and data variations list:**  
3a. Touch screen is used to navigate.  
4a. Touch screen is used to navigate.  
5a. Touch screen is used to navigate.

**Frequency of occurrence:**  
Frequent
