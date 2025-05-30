# BowlingWithFrames

**BowlingWithFrames** demonstrates several key aspects of software development, including the separation of the domain model from the user interface. It also incorporates Behavior-Driven Development (BDD) scenarios to validate both overall and specific application behaviors. These scenarios ensure the application behaves as expected.

The rules for scoring in bowling are relatively straightforward (see this [https://landofbowling.com/what-is-scoring-like-in-bowling-how-do-you-calculate-score/]()). However, the tenth frame behaves differently from the first nine, and there are multiple valid ways to implement it. Deciding how to handle such variations is a common challenge in software design.  

### A Coding Kata

**BowlingWithFrames** serves as an effective coding kata. The following scenario illustrates the expected behavior of a full game. The `Then` clause shows the output in a textual format. This scenario can be used as an acceptance test and is written using Gherkin syntax for Gherkin Executor for Java .[https://github.com/atdd-bdd/GherkinExecutorForJava]() .  They could form the basis for an XUnit test.



```
Scenario: Full Game Display and Input
#Note:  one more roll remaining to end the game 
Given rolls are                                  # ListOfListOfObject Integer 
|  5 | 5  | 4  | 5  |  8 | 2  | 10  | 0 | 10 | 10 | 6 | 2| 10 | 4 | 6| 10 | 10 |
When scored 
Then display is   
"""
|5/ |45 |8/ |X  |-/ |X  |62 |X  |4/ |XX |
| 14| 23| 43| 63| 83|101|109|129|149|   |
"""

```

This model can be used as the backend for a web service or a graphical user interface.  For that purpose, the game model should provide the following:

1. **Game Completion Status** – Indicates whether the game has ended.
2. **Input Control State** – Provides information about the current frame, roll, and remaining pins, which can be used for input constraints.

```
Then game complete is                            # ListOfListOfObject Boolean 
| false| 

Then input control is                            # ListOfObject InputControlValues 
| Frame  | Roll  | Remaining  |
| 10     | 3     | 10         |

```

 
