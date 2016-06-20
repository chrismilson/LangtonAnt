JC=javac
OUTPUT=./out
JFLAGS=-d $(OUTPUT)
SOURCEFILES=LangtonAnt.java Board.java
OUTFILES=LangtonAnt

all: compile run

compile:
	mkdir -p $(OUTPUT)
	$(JC) $(JFLAGS) $(SOURCEFILES)

run: compile
	java -cp $(OUTPUT) $(OUTFILES)

test: run clean

clean:
	rm -rf $(OUTPUT)
