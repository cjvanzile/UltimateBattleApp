# UltimateBattleApp
Simulate a race between contenders using threads.

## Description
UltimateBattleApp will create several contender threads, and simulate a race between them. The first contender to complete 200 push-ups wins!

## Course Info
Name: **Clay VanZile**  
Course: **COP 3330C**  
CRN: **17193**

## Concepts
This program demonstrates using *user* threads to run multiple concurrent code segments within the same program.

## Objectives
- Create several contender objects containing competitor name, pushups per round, and max rest time per round.
- Create an array of threads with one thread per contender.
- Contenders will rest for a random time period each round.
- Contenders will drink water 50% of the time, but only one contender may drink at any given time. Other contenders must wait their turn.
- Start contender threads and wait for winner.
- First contender to complete 200 or more push-ups is the winner.
- Winner and losers are displayed at the completion of the race.

## Inputs and Outputs
### Inputs
The contender objects are hard coded in the program.
### Outputs
Once a winner has been determined, the winner and losers are displayed, along with the number of push-ups they completed.
