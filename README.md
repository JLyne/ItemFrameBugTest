# ItemFrameBugTest

Minimal reproduction of a 1.18.2 Paper(?) issue causing item frames to appear in the wrong place on the client.

This test case creates a dirt floor and an obsidian pillar at 0, 4 ,0, then spawns item frames on each side of the pillar one block above the ground before setting them to face upwards.

The result should be something like this:
![image](https://user-images.githubusercontent.com/4615316/160029098-1ff1d288-8386-44e1-a383-9769cbd73c0a.png)


However on 1.18.2 Paper build 267 the initial result is this:
![image](https://user-images.githubusercontent.com/4615316/160029112-5668b0be-e9ef-475d-9b04-c5bca600ea40.png)


Reconnecting to the server, or flying away and back again to reload the chunks will resolve the issue.
