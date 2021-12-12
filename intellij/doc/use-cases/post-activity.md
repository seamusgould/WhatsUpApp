# Post Activity
**Scope:** Campus activity application

**Level:** User goal

**Primary actor:** Poster

**Stakeholders and Interests:**
- **Poster:** Wants to share information about activity with other users and encourage people to attend/participate in the activity.
- **Viewer:** Wants to quickly find out what is happening, when the activity starts and ends, and where on campus it is happening. Does not want to see events that are not actually happening.

**Preconditions:**
- User is identified and authenticated.

**Postconditions (or success guarantee):**
- An activity post is successfully created.
- The activity post’s name, time, description, and location match the user input.  
- The new activity is included on the list of activities.

**Main success scenario:**
1. Poster opens the app with the intention of posting activity.
2. System displays activities that are happening at the current time or in the near future.
3. Poster chooses the option to post activity.
4. Poster provides the app with the name of the activity, date, time, location, and whether the activity is recurring (e.g. weekly, monthly).
5. The newly created activity is added to the existing list of activities.

**Extensions (or alternate flows):**  
4a. Poster changes their mind about posting an activity
1. The poster can leave the post activity screen to cancel the activity creation.

**Special requirements:**
- Touch screen UI.

**Technology and data variations list:**  
3a. Touch screen is used to navigate.  
4a. Touch screen and device keyboard are used to navigate.

**Frequency of occurrence:**  
Very frequent
