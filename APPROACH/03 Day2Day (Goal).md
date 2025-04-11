#### **Day 2: Database Design + Hibernate Config**

* Design your database schema:
  * `vehicle` (id, make, model, year)
  * `fuel_data` (id, vehicle_id, liters_used, distance_km, timestamp)
  * `engine_data` (id, vehicle_id, rpm, temperature, timestamp)
* Create DB and tables in PostgreSQL
* Create:
  * `hibernate.cfg.xml` (with DB config)
  * `HibernateUtil.java` (utility to get session factory)

---

#### **Day 3: Entity + DAO Layer**

* In `model/`, create:
  * `Vehicle.java`
  * `FuelData.java`
  * `EngineData.java`
* In `dao/`, create:
  * `VehicleDAO.java` with methods: `saveVehicle()`, `getAllVehicles()`
  * `FuelDataDAO.java`: `saveFuelData()`, `getFuelDataByVehicleId()`
  * `EngineDataDAO.java`: similar methods for engine stats

---

#### **Day 4: Basic Servlet Integration**

* Create a Servlet: `AddVehicleServlet.java`
  * Read form data, call `VehicleDAO.save()`, redirect to `dashboard.jsp`
* Map servlets in `web.xml`
* Test full flow: form input → servlet → DB save

---

### 🔁 End of Week 1: You have a working app that saves data!

---

### ✅ **WEEK 2: Dashboard, Visualization, and Advanced Data**

---

#### **Day 5: Dashboard Display**

* Create `DashboardServlet.java`:
  * Fetch all vehicles and stats
  * Pass to `dashboard.jsp` using `request.setAttribute()`

#### **Day 6: Create FuelData + EngineData Input & Display**

* Create JSP forms to submit fuel and engine data
* Create:
  * `AddFuelDataServlet`
  * `AddEngineDataServlet`
* Handle POST request, save data via DAO

#### **Day 7: Show Data in Tables**

* On `dashboard.jsp`, show:
  * List of vehicles
  * Fuel efficiency per vehicle
  * Avg engine RPM/temp
  * Use JSTL or scriptlets if needed

---

#### **Day 8: Charts (Visualization Layer)**

* Add Chart.js via `<script src="">`
* Use `<canvas>` elements for:
  * Line chart: Fuel efficiency over time
  * Bar chart: RPM comparison
* Create two more servlets:
  * `FuelDataChartServlet`
  * `EngineDataChartServlet`
  * These return JSON data from DAO

---

#### **Day 9: Polish + Validations**

* Add input validations (empty fields, invalid numbers)
* Add styling to forms (basic CSS)
* Organize layout of dashboard
* Test full data flow: insert → view → chart

---

### 🧪 **WEEK 3: Testing, Cleanup, Submission**

---

#### **Day 10: Manual Testing + Fixes**

* Test CRUD for all entities
* Test chart rendering
* Test servlet behavior on empty/invalid data

---

#### **Day 11: UI/UX Improvements**

* Add dropdowns for vehicle selection
* Add timestamps to entries
* Add buttons for navigation (back, refresh, add more)

---

#### **Day 12: Packaging**

* Write `README.md`:
  * Project description
  * How to run
  * Technologies used
* Package `.war` using Maven
* Deploy on Tomcat
* Final review

---

#### **Day 13–14: Buffer Time**

* For unplanned bugs, improvements, or presentation prep
* Record demo video if needed

---
