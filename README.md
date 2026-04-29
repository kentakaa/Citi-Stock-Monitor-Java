# Citi Real-Time Stock Monitoring Dashboard 📈

A high-performance financial monitoring tool developed during the **Citi Technology Software Development Job Simulation** via Forage. This project bridges the gap between raw data ingestion and user-centric visualization.

## 🌟 Project Overview
As a simulated Software Engineer at Citi, I was tasked with creating a tool to monitor the **Dow Jones Industrial Average (^DJI)**. The application handles real-time data streams and visualizes stock fluctuations through an interactive dashboard to help risk managers make informed decisions.

## 🚀 Key Features
- **Real-Time Data Ingestion:** Simulated live feed of stock prices with 5-second update intervals.
- **Efficient Data Handling:** Implemented a `Queue` data structure to manage incoming data streams, ensuring the system remains responsive.
- **Dynamic Visualization:** A custom **JavaFX** LineChart dashboard that updates in real-time without flickering.
- **Modern Build System:** Full project lifecycle management using **Gradle 9.2**, optimized for the latest Java environments.

## 🛠️ Tech Stack
- **Language:** Java 25 (LTS) ☕
- **UI Framework:** JavaFX
- **Build Tool:** Gradle
- **Libraries:** YahooFinanceAPI (Simulation mode), Google Guava, JUnit 5

## 📸 Dashboard Preview
![Dashboard Demo]  


## ⚙️ Installation & Usage

### Prerequisites
- **JDK 25** or higher.
- **Gradle 9.x** (Included via Gradle Wrapper).

### Steps to Run
1. Clone the repository:
   ```bash

   git clone [https://github.com/kentakaa/Citi-Stock-Monitor-Java.git](https://github.com/kentakaa/Citi-Stock-Monitor-Java.git)
   cd Citi_Stock_App

2. Build the project:
     ```
     ./gradlew build
3. Run the dashboard:
   ```
   ./gradlew run --no-configuration-cache

   
