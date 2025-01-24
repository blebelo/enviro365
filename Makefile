# Default target
.PHONY: all
all: clean install test run

# Clean target
.PHONY: clean
clean:
	@mvn clean

# Install target
.PHONY: install
install:
	@mvn install

# Run tests
.PHONY: test
test:
	@mvn test

# Run Spring Boot application
.PHONY: run
run:
	@mvn spring-boot:run
