MAIN =  "src/main/java/com/enviro/assessment/grad001/bennylebelo/Main.java"

default: compile run

compile:
	@mvn compile

run:
	@java $(MAIN)


.PHONY: default compile run
