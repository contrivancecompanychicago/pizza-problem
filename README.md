
#Pizza Problem : Concurrent Programming

This is a solution done for a problem given in CS 4532 Concurrent Programming module

A group of students are studying for CS 4532 exam. The students can study only while eating pizza. Each student executes the following loop:
while (true) {
	pick up a slice of pizza;
	study while eating the pizza
}

If a student finds that the pizza is gone, the student goes to sleep until another pizza arrives. The first student to discover that the group is out of pizza calls Kamal’s Pizza to order another pizza before going to sleep. Each pizza has s slices. Once Kamal delivers pizza, he wake up all the students in the group. Then the students pick up a slice of pizza and go back to studying, and the process continues.

##Run the program
  'javac Main.java'
  'java Main'