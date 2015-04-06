#Offline Friends
Zichen Jiang
1320889
CS 2XB3 - L02

##Abstract
This project will be a web/`Android` application that use data from Facebook to implement the search function on the users' list of friends. The project will implement `Merge Sort`, `BST`, `DFS`/`BFS`, with practice on `Facebook API`. The program will not need constant internet connection to function. It will need internet once for user to log into Facebook, and once in a while to update the user's friend list.

##Objectives
The purpose of this project is a practice to simulate the search function in Facebook. The project will be a web-application in a form of a mobile application, so that it only needs to be written once to be able to run on all platforms (Or an `Android` application only depends on the difficulties). The program will need users to sign in to their Facebook account and require the permission to access users' friend list, or taggable/invitable friends according to `Facebook API`. The program will search within the users' list of friends according to their input, and return a list of results. The user may click on the results that will launch the Facebook app and open the resulting person's profile page.

My motivation of this program is that I want to know and practice how Facebook implements its search function. And who does not like Friends? It is important to solve this problem because it is an exciting way to practice what I have learnt in class and make a real-life solution that many people use every day in their life.

##I/O
The source of the database will be from Facebook.
The input will be from the users.
The output will be a list of friends whose name partially matches the input.

##Algorithmic Principle
- The program will use the `Graph API` from Facebook to retrieve a complete list of your friends. 
- It will then use `merge sort` to sort the list in alphabetical order if it isn't already.
- After that, it will construct a `BST` out of the list.
- Then, with the search box in the program, it will match your input with your friends' name with `BFS` or `DFS` and give results in alphabetical order.
- You can click on the results to go to their Facebook profile page.

##Algorithmic Challenges
- `Merge sort` will be used to sort the friend list retrieved from Facebook.
- `BST` will be constructed using the sorted list.
	- Always use the Middle of the array as the root, and do so to left half and right half recursively
- `DFS` or `BFS` will be used when searching for friends.
- To be able to access taggable/invitable friends, the application will need to be [reviewed by Facebook](https://developers.facebook.com/docs/apps/review).

##Project Timetable
| Milestone | Deliverable | Estimated time |  
| - | - | - |  
| 0 | Figure out and set up the development environment for a Java/`Android` application with `Facebook API` | 7 ~ 10 days |  
| 1 | In the meanwhile, pass the verification from Facebook to be able to get a complete list of friends when the user gives permission. If permission not given by Facebook, will use a library of people's name instead | 3-7 business days according to Facebook |  
| 2 | Implement the `Facebook API` | 2 ~ 3 days |  
| 3 | `Merge sort` and construct `BST` using data from Facebook | 2 ~ 3 days |  
| 4 | Implement `BFS` and/or `DFS` on the data | 2 ~ 3 days |  
| 5 | Set up the GUI of the program | 3 ~ 5 days |  
| | **Total** | **16 ~ 24 days** |


##References
[Facebook Graph API](https://developers.facebook.com/docs/graph-api)

Available Facebook JAVA APIs/SDKs:
- [Facebook SDK for Android](https://developers.facebook.com/docs/android)
- [Java (Spring)](http://www.springsource.org/spring-social/)
- [Facebook4J](http://facebook4j.org)
- [RestFB](http://restfb.com/)
- [Kinvey](http://www.kinvey.com/facebook-open-graph-for-mobile-apps)




---
This document is proudly written in Markdown.