# Smart Grocery Application

Smart Grocery is a comprehensive application designed to manage your shopping lists efficiently. It allows users to add, view, and manage products seamlessly.

## Prerequisites
- Java 11 or higher
- Maven 3.6.0 or higher

## Installation
1. Clone the repository:
   ```bash
   git clone https://your-repo-url.git
   cd SmartGrocery
   ```
2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

## Running the Application

### Backend
1. Navigate to the project directory:
   ```bash
   cd target
   ```
2. Run the application:
   ```bash
   java -jar smartgrocery-0.0.1-SNAPSHOT.jar
   ```
   Ensure that the backend is running before accessing the frontend.

### Backend
1. Navigate to the project directory:
   ```bash
   cd target
   ```
2. Run the application:
   ```bash
   java -jar smartgrocery-0.0.1-SNAPSHOT.jar
   ```

### Frontend
1. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Run the frontend application:
   ```bash
   npm start
   ```
   Make sure the backend is running to connect to the API.
1. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Run the frontend application:
   ```bash
   npm start
   ```

### Additional Setup
- Ensure that your database is running and configured properly.
- Update application properties to match your database configuration.

## API Endpoints
- **Add Product**: `POST /api/shopping-list/add`
- **Get Shopping List**: `GET /api/shopping-list`

## License
This project is licensed under the MIT License.
