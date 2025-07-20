# 🖥️ Custom PC Ordering System (Java Backend)

A solo-developed Java backend system for configuring and ordering custom-built PCs. This project handles part selection, pricing, customer data, receipt generation, and saves orders to persistent storage using file-based mock logic — designed with extensibility toward Oracle DB and Microservice deployment in mind.

---

## 🔧 Features

- 🧩 Select PC components using part IDs
- 💸 Auto-calculate subtotal, VAT (5%), tax (15%), and grand total
- 👤 Attach and manage customer profile data
- 📄 Generate receipts and order files in a `/ConfirmedOrders` folder
- ✅ Over 90% JUnit test coverage
- 🗂️ Mock database powered by `MockComponentList.txt`
- 🧪 Unit-tested order validation and error handling
- 🔄 Designed for future integration with Oracle DB and Docker

## ⚙️ Technologies Used

- Java 17+
- Micronaut annotations (`@Serdeable`)
- JUnit 5 (Unit testing)
- File I/O for storage simulation
- Interfaces (to enable future Oracle DB swap-in)

---

## 📦 Configuration & Deployment Notes

### 📁 `resources/MockComponentList.txt`

- Format:  
ID, Name, Category, Price
1, Ryzen 9 7950X3D, CPU, 450
2, MSI B650 Pro, Motherboard, 190
- Loaded using `ClassLoader` in `ComponentDataManagment`

---

### ⚙️ Microservice Deployment Strategy (Planned)

- Services follow interface-based design (e.g. `ComponentDataBlueprint`)
- Easily swappable with Oracle DB or REST API services in the future
- Suitable for containerization via **Docker**:
