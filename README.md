The functionality actually implemented by your prototype, and its limitations/simplifying assumptions.
How to run the prototype - i.e., identifying the class containing the main() method, and any relevant command line arguments or usage instructions.
 
For the final iteration of our event planning app (referred to in the files as WhatsUpApp), we have implemented the ability to log in with a username and password, create events for everyone to view, view all the events you've posted, see a map of the campus, and comment on events posted by yourself and others. Of course, this also includes permenance of the events posted (they will not disappear once the app is closed, a new user logs in, etc.)
 
Simplifying Assumptions
-We have assumed the viewer will generally make events with titles/descriptions/etc. that make sense. They have no choice but to give a valid date and time based on the widgets we chose, but the usefulness of the app (not its technical functionality) will depend to some extent on how well its users want it to.
 
Limitations
-As none of us are graphic designers, the UI is a bit rough on the eyes.
-There is no check that users are "spamming" events by posting the same one over and over, same for comments
-We do not check if the time for the event is in the past
-If there are multiple dates for an event (if it is a monthly meeting, for example), the other dates can only be seen by clicking on the event.
 
**Running the App**
If an Android phone is connected to a device with Android Studio installed and this project open, the app should be usable on said phone. Alternatively, the Android Studio emulator can be used as well, testing was done on a virtual Pixel 4a and other devices. The performance is better on the actual phone, but the emulator will provide the same functionality.
 
 
 


