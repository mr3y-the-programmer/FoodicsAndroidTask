# FoodicsAndroidTask
Android app that enables users to browse categories, view products, search for a specific product by name, and add products to order. 

Additionally, app's layouts adapt to different screen sizes to ensure UI remains responsive for users on various devices.

## Screenshots
<p align="center">
  <img src="https://github.com/user-attachments/assets/b51e808b-5b0e-4997-a151-3ef287f0d0c5" width="33%" />
  <img src="https://github.com/user-attachments/assets/be668bc2-b390-42dd-9732-ad6925817092" width="33%" />
  <img src="https://github.com/user-attachments/assets/a8a9c855-5387-488d-a3c9-b9adb86d954d" width="33%" />
  <img src="https://github.com/user-attachments/assets/3a107dd4-2352-4048-8e5d-712a47890d6c" width="20%" />
  <img src="https://github.com/user-attachments/assets/0c9ef11d-77da-4504-a8cc-a1bee89168b7" width="20%" />
</p>

## APK for testing
You can find the apk file under apk/ path in this repository.

## Some Notes
- Code is unit tested to ensure any changes/additions don't break current behavior.
- There is no domain layer/UseCases in this simple app because it is more straightforward to call the Repository methods directly instead of Overengineering architecture and adding unnecessary layers.
- Currently, Filtering products based on entered search query is done on the client side locally. Ideally, this should be part of API call request query parameters but it is done locally because we're using a mock API here.

## Tech Stack
- Ktor. (for API calls)
- Room. (for storing fetched data locally)
- Koin. (for Dependency injection)
- [Beeceptor](https://beeceptor.com/) Free tier. (for providing HTTP endpoints to call for mock API. Free tier is subject to daily quota limits)
- Jetpack Compose & Material 3.
- MVI architecture.
