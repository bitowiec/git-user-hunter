# Git User Hunter

## Description
This project is a RESTful service that retrieves user information from the GitHub API and returns the data in a specific format. It also calculates a value based on the retrieved data and stores the number of API calls made for each user in a database.

## API Endpoint
GET /users/{login}

## User Data Structure
The API returns the following information for each user:
- `id`: User's identifier.
- `login`: User's login.
- `name`: User's name.
- `type`: User's type.
- `avatarUrl`: URL to the user's avatar.
- `createdAt`: Date of account creation.
- `calculations`: Calculated value based on the formula: 6 / followers * (2 + public_repos).

## Technologies Used
- Java
- Gradle
- Database (H2)
- GitHub API

## Installation and Setup
1. Clone the repository: `git clone https://github.com/bitowiec/git-user-hunter.git`
2. Navigate to the project directory: `cd git-user-hunter`
3. Build the project: `gradle build`
4. Run the application: `java -jar ./build/libs/git-user-hunter-0.0.1-SNAPSHOT.jar`

## Database Structure
The database should have the following columns:
- `LOGIN`: User's login.
- `REQUEST_COUNT`: Number of API calls made for each user.

## Contribution
Feel free to contribute to this project by submitting a pull request.

## License
This project is licensed under the [MIT License](LICENSE).
