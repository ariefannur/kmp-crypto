# kmp-crypto
Crypto App client with shared data and domain layer with kotlin multiplatform

## Architecture
![Diagram](https://github.com/ariefannur/kmm-crypto/blob/main/screenshot/Diagram%20Shared%20Module.jpg)

## Stack
Data: 
1. Remote
    - Ktor : HTTP Client (API https://coinmarketcap.com/api/documentation/v1/)
2. Local
   - SqlDelight : Sqlite (Use for caching data / offline suport)
3. Dependency Injection
   - Koin
   
  
Domain:
 - Wrap to UseCase

Presentation: Home
- Android : Jetpack Compose 
- iOS : Swift UI

## Android

<img src='screenshot/Android.jpg' width='300'>



## iOS

<img src='screenshot/iOS.png' width='300'>

### Compose Multiplatform 

Exploring compose multiplatform build shared presentation / view both android and iOS 



