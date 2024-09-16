# Simple IDS

A simple Intrusion Detection System (IDS) implemented in Java. This tool analyzes log files for basic intrusion patterns such as multiple failed login attempts. It is designed to help you learn and demonstrate basic concepts in cybersecurity.

## Features

- Analyzes log files to detect failed login attempts.
- Reports suspicious activity based on a threshold of failed login attempts.
- Simple command-line interface for easy usage.

## Requirements

- Java Development Kit (JDK) 8 or higher.

## Installation

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/endpoint1337/Intrusion-Detection-System.git
   ```

2. **Navigate to the Project Directory:**

   ```bash
   cd Intrusion-Detection-System
   ```

## Usage

1. **Compile the Code:**

   ```bash
   javac Main.java
   ```

2. **Log File:**

   Log file (e.g., `sample.log`) with entries formatted as follows:

   ```text
   <timestamp> <IP> <action>
   ```

   Example content:

   ```text
   2024-09-16 192.168.1.1 FAILED
   2024-09-16 192.168.1.1 FAILED
   2024-09-16 192.168.1.2 SUCCESSFUL
   2024-09-16 192.168.1.1 FAILED
   2024-09-16 192.168.1.1 FAILED
   2024-09-16 192.168.1.1 FAILED
   ```

3. **Run the Application:**

   ```bash
   java Main path/to/your/logfile.log
   ```

   Replace `path/to/your/logfile.log` with the path to your log file.

## Configuration

- **FAILED_LOGIN_THRESHOLD**: The number of failed login attempts required to trigger a suspicious activity alert. Currently set to `5` in the code. You can modify this value in the `Main` class to fit your needs.

## Example Output

If the application detects suspicious activity, you will see output like:

```text
Suspicious activity detected from IP: 192.168.1.1
Failed login attempts: 5
```
