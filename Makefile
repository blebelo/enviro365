# Makefile

# Default target
.PHONY: all
all: clean install run

# Clean target
.PHONY: clean
clean:
	mvn clean

# Install target
.PHONY: install
install:
	mvn install

# Run Spring Boot application
.PHONY: run
run:
	mvn spring-boot:run
