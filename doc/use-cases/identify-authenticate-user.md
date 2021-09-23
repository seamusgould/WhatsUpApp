# Identify/Authenticate User
**Scope:** Campus activity application

**Level:** Subfunction

**Primary actor:** System

**Stakeholders and Interests:**
- **User:** Wants to log in to the app to find or post activity.  
- **System:** Wants to authenticate identity of each user, which reduces risk of trolling.  

**Preconditions:**
- User has created an account on the app.

**Postconditions (or success guarantee):**
- System successfully validates the identity of the user using credentials provided.  

**Main success scenario:**
1. System confirms that the username entered matches a username of an account that has been created.
2. System confirms that the password entered matches the password associated with the username.  

**Extensions (or alternate flows):**  
1a. The username does not match a username in the system
1. The user is notified that the username is incorrect, and that they should create an account if they do not have one.

2a. The password does not match the password associated with the user’s account  
1. The user is notified that the password is incorrect.  
2. The user can attempt to enter their password again or request a password reset.  

**Special requirements:**
- Touch screen UI.

**Technology and data variations list:**  
1a. Touch screen and device keyboard are used to navigate.  
2a. Touch screen and device keyboard are used to navigate.

**Frequency of occurrence:**  
Very frequent