# Iteration 3 Plan
### Use Cases: Upvote/Downvote Activity, Comment on Activity, Create Account, Manage Account, Manage Posted Activities
*A page in the Android app that displays the details of an activity and allows users to upvote or downvote the activity. After an activity is upvoted or downvoted, the activity's upvote/downvote score and the activity poster's karma are updated to reflect the action. The list of comments will also be updated if the user adds a comment. Another goal of iteration 3 is to handle use cases related to user identification and authentication, including creating and managing an account.*

### Justification of Choice
Events need to be displayed in a RecyclerView container on the Home page so users can easily see all events after opening the app. It is critical to be able to select one activity from the list to view that activity in detail. Adding upvote/downvote and comment functionality will make the app more interactive.

### Iteration 3.0

*Features Needed*:
- The list of activities displayed in a RecyclerView container on the Home page of the app
- Ability to select a single activity from the RecyclerView container
- Display a single activity in detail - display name, date, time, location, description of the event, username of poster, upvote/downvote score, and comments
- Ability to upvote or downvote an activity when viewing it in detail
- Ability to add a comment when viewing an activity in detail
