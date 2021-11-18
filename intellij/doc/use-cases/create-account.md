# Create an Account
**Scope:** Campus activity application

**Level:** User goal

**Primary actor:** User

**Stakeholders and Interests:**
- **User:** Wants to have access to a list of campus activities for either viewing activities or posting activities.

**Preconditions:**
- App successfully opens to create account/login screen.

**Postconditions (or success guarantee):**
- A new account has been created with the user's information.
- The user can log in to the app using their account information.

**Main success scenario:**
1. Viewer opens the app.
2. The user selects the option to create an account.
3. The user provides their email address.
4. The provided email address is verified to be a ".edu" address.
5. The user's identity is confirmed using the email.
6. The user creates a username.
7. The user creates a password.
8. A new account is created using the information provided by the user.

**Extensions (or alternate flows):**  
1a. The application fails to start
1. Viewer can restart or contact the dev team
   4a. Email address provided is not a ".edu" address
1. The user is asked to enter a valid ".edu" email address in order to create an account.
   5a. The email is not confirmed
1. The confirmation email can be resent, or the user could try creating an account again.

**Special requirements:**
- Touch screen UI.

**Technology and data variations list:**  
None

**Frequency of occurrence:**  
Occasional (once per user)
