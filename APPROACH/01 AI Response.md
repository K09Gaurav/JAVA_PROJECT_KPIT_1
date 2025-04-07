## 🚗 Automotive Data Analytics Platform — Project Approach

---

### 🔧 Tech Stack

- **Backend:** Java (Modern Java), Hibernate ORM
- **Database:** PostgreSQL
- **Frontend:** HTML, CSS, JavaScript (for charts)
- **IDE:** VS Code or IntelliJ
- **Build Tool:** Maven (recommended)
- Apache Tomcat (for deploying the web app)

## 🚀 Full Project Development Guide

> **Goal:** Web-based dashboard system to analyze vehicle data (fuel consumption, engine behavior, environmental impact)
> **Tech:** Java (Servlets, JSP), Hibernate, PostgreSQL, HTML/CSS/JS, Apache Tomcat

```apache
vehicle-analyzer/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/vehicleanalyzer/
│       │       ├── model/
│       │       ├── dao/
│       │       ├── util/
│       │       └── servlet/
│       └── webapp/
│           ├── WEB-INF/
│           │   └── web.xml
│           ├── index.jsp
│           ├── dashboard.jsp
│           └── static/
│               ├── css/
│               └── js/
├── pom.xml
└── README.md
```

## 2. 📘 MODULE-BY-MODULE BREAKDOWN

---

### 🧱 `model/` → Entity Classes (Hibernate ORM)

#### Purpose:

Represent database tables as Java classes with attributes, relationships, and basic data structure.

#### Files to create:

##### `Vehicle.java`

- Represents a vehicle.
- **Attributes**: `id`, `make`, `model`, `year`
- **Methods**: Getters, setters, toString()

##### `FuelData.java`

- Represents a fuel entry.
- **Attributes**: `id`, `vehicleId`, `litersUsed`, `distanceKm`, `timestamp`
- **Methods**: Getters, setters, toString()

##### `EngineData.java`

- Represents engine behavior data.
- **Attributes**: `id`, `vehicleId`, `rpm`, `temperature`, `timestamp`
- **Methods**: Getters, setters, toString()

---

### 🔌 `dao/` → Data Access Objects

#### Purpose:

These classes handle **database operations** using Hibernate. Each DAO corresponds to a model/entity.

#### Files to create:

##### `VehicleDAO.java`

- Manages vehicle-related DB operations.
- **Methods**:
  - `saveVehicle(Vehicle v)` – Save a new vehicle.
  - `getAllVehicles()` – Fetch all vehicles.
  - `getVehicleById(int id)` – Fetch one vehicle.
  - `deleteVehicle(int id)` – Delete by ID.

##### `FuelDataDAO.java`

- Manages fuel data.
- **Methods**:
  - `saveFuelData(FuelData f)`
  - `getFuelDataByVehicleId(int id)`
  - `getFuelEfficiencyStats(int vehicleId)` – Calculate km/l.

##### `EngineDataDAO.java`

- Manages engine data.
- **Methods**
  - `saveEngineData(EngineData e)`
  - `getEngineStats(int vehicleId)` – Fetch average RPM/temp.

---

### ⚙️ `util/` → Utility Classes

#### Purpose

Support Hibernate and app config. Helps maintain reusable logic.

#### Files to create

##### `HibernateUtil.java`

- Provides Hibernate `SessionFactory`.
- **Methods**:
  - `getSessionFactory()` – Singleton pattern to return configured session factory.
  - `shutdown()` – Closes factory when app ends.

---

### 🌐 `servlet/` → Java Servlets (Controller Logic)

#### Purpose:

These handle **HTTP requests**, interact with DAOs, and route data to JSP pages or JSON responses.

#### Files to create:

##### `AddVehicleServlet.java`

- Handles form submission for new vehicles.
- **Methods**: `doPost()` → Reads form data, calls `VehicleDAO`, redirects to dashboard.

##### `VehicleDashboardServlet.java`

- Loads dashboard with vehicle data.
- **Methods**: `doGet()` → Fetch data using DAO, sets request attributes, forwards to `dashboard.jsp`.

##### `FuelDataServlet.java`

- Returns fuel data in JSON.
- **Methods**: `doGet()` → Responds with list of fuel entries or stats.

##### `EngineDataServlet.java`

- Similar to above, but for engine data.

---

### 🧾 `web.xml` → Deployment Descriptor

#### Purpose:

Maps servlets to URLs and defines welcome page, servlet init params, etc.

#### What it should contain:

- `<servlet>` and `<servlet-mapping>` for each servlet
- Welcome file: `index.jsp`
- Optional: error pages

---

### 🌍 JSP Pages → Views

#### Purpose:

Frontend interface to display data and collect input.

#### Files to create:

##### `index.jsp`

- Homepage or form to input new vehicle and data.
- Contains links or buttons to go to dashboard.

##### `dashboard.jsp`

- Main dashboard view.
- **Includes**:
  - Vehicle selector dropdown
  - Embedded charts (Canvas or SVG elements)
  - Tables for raw data

---

### 🖼️ Static Files → JS, CSS

Inside `webapp/static/`:

##### `main.css`

- Styles for dashboard layout, buttons, forms.

##### `charts.js`

- JS to fetch `/FuelDataServlet`, `/EngineDataServlet` and render data using **Chart.js** or similar.

##### `utils.js`

- Helper functions for AJAX, date formatting, etc.

---

### 📦 `pom.xml` → Maven Config

#### Purpose:

Manage dependencies like Hibernate, PostgreSQL JDBC, Servlet API, JSON library.

#### Dependencies to include:

- Hibernate core
- PostgreSQL JDBC driver
- Servlet API (provided scope)
- JSON lib (like Gson or Jackson)

## 3. 🧩 LOGICAL FLOW OF THE APP

### A. **User opens index.jsp**

- Sees form to input vehicle and data

### B. **Form submitted to AddVehicleServlet**

- Servlet calls DAO, saves data

### C. **User goes to dashboard.jsp (via VehicleDashboardServlet)**

- Servlet fetches vehicles + stats, passes data to JSP

### D. **Dashboard.jsp loads JS (charts.js)**

- JS fetches fuel/engine stats via `FuelDataServlet`, `EngineDataServlet`
- Data visualized in charts

## 4. 🔄 BONUS: Analytics to Include

| Metric                            | Source     | Where to Display        |
| --------------------------------- | ---------- | ----------------------- |
| Fuel Efficiency (km/l)            | FuelData   | Line chart on dashboard |
| Avg. Engine Temp                  | EngineData | Gauge or bar chart      |
| RPM Trend                         | EngineData | Line chart              |
| Emission Estimate (based on fuel) | FuelData   | Pie chart or stat card  |
