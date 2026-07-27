# Inventory Management and Billing — Vinyl & CD Shop

A Java Swing desktop application for managing inventory and billing at a vinyl record and CD shop.

## Features

- User login and signup
- Add stock across product types: Music (CD/vinyl), Movies, and Games
- Inventory management — add, remove, search, and view items
- Invoice generation and lookup
- Persistent storage via text files

## Project Structure

- `src/` — Java source files (Swing GUI windows, domain model, inventory & invoice logic)
- `.classpath`, `.project` — Eclipse project configuration
- `Assignment.pdf`, `Objects.pdf`, `cse215Lab report.pdf` — assignment brief and report
- `Inventory.txt`, `Invoice.txt` — sample data files

## Build & Run

Open the folder as a project in Eclipse and run `GUItest.java`, or from the command line:

```bash
javac -d bin src/*.java
java -cp bin GUItest
```
