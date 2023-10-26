# kmm-crypto
Crypto App client with shared data and domain layer with kotlin multiplatform

## Architecture
![Diagram](https://github.com/ariefannur/kmm-crypto/blob/main/screenshot/Diagram%20Shared%20Module.jpg)

## Stack
Data: 
1. Remote
    - Ktor : HTTP Client
2. Local
   - SqlDelight : Sqlite (Use for caching data / offline suport)
  
Domain:
 - Wrap to UseCase

Presentation:
- Android : Jetpack Compose
- iOS : Swift UI

## Android

<img src='screenshot/Android.jpg' width='300'>



## iOS

<img src='screenshot/iOS.png' width='300'>

