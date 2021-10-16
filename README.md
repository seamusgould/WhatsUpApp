The functionality actually implemented by your prototype, and its limitations/simplifying assumptions.
How to run the prototype - i.e., identifying the class containing the main() method, and any relevant command line arguments or usage instructions.

In this iteration we've implemented the "view" and "post" use cases. By default, users view the event collection or the list containing all of the events. At any moment, Users can decide to post by typing "post". 

Simplifying Assumptions 
- The user-interface is the Main.java file with text-based user-interface.
- We ignored data persistence and the communication to a backend server. 
- Ignore issues related to authentication and logging in. Logging in is equivalent to entering your name on the text-based user-interface. 

Limitations
- In this prototype, the viewer cannot select an event to view in detail, which is one component of the find-activity
use case. That slice of the find-activity use case will be implemented in iteration 2.

**Running the Prototype**
1. Go to Main.java 
2. Run the program 
3. Follow the prompt and enter your name
4. Enter "post" when prompted to create a new event
5. Follow the prompts and provide information about your event (name, description, time, location, etc.)
6. Once the event has been created, you can repeat steps 4-5 to add to the list of events

