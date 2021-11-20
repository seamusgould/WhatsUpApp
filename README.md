In this iteration we've implemented the "Post Activity" and "Find Activity" use cases in a multi-screen Android app. 
After opening the app, the Home page is displayed. This page has a “Post” button that users can click to create a new
event. A navigation bar at the bottom of the screen will be used to navigate to different pages of the app, like a page
with a map.  

Simplifying Assumptions  
- We ignored data persistence and the communication to a backend server.  
- Ignore issues related to authentication and logging in. 
- The user associated with every event created is a constant string.

Limitations  
- In this prototype, the list of events is displayed in a TextView box. The RecyclerView container will be implemented
during iteration 3 so a scrollable list of events will be displayed on the Home page of the app.  
- In this Android prototype, the viewer cannot select an event to view in detail, which is one component of the
find-activity use case. That part of the use case will be implemented in iteration 3.

**Running the Prototype**  
1. Run the app on an emulator
2. Click the “Post” button on the Home page
3. Follow the prompts and provide information about your event (name, description, time, location, etc.)
4. See that the event you created is displayed at the top of the screen
5. Once the event has been created, you can repeat step 3 to add to the list of events and see more displayed
