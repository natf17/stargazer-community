# Stargazer community
When planning a stargazing trip, wouldn't it be awesome to know where to find the good spots? Perhaps with pictures and information on visibility, darkness level, ease of access, etc.? 

This application will allow anyone to see stargazing spots published by the community. The stargazer community will consist of registered users, who will be able to keep their own private list of stargazing spots, as well as provide feedback on published spots.

## Architecture
The application uses a microservice architecture and is built with Spring Cloud. These are the infrastructure components:
- Spring Cloud Config Server
- Eureka Server (Spring Cloud Netflix)
- Spring Cloud Gateway

...and the application services:
- User service: manages registered users (home location, profile information, ...)
- Spot service: controls spots (coordinates, elevation, light pollution, ...)
- Spot metadata service: stores verified user-provided metadata for spots (name, description, amenities, accessibility, horizon visibility, terrain type, ...)
- Spot metadata draft service: stores user-provided spot information that needs to be verified
- Spot personalization service: provides user-specific spot personalizations (description, name, viewing logs) and orchestrates the user-facing spot view

## URI Routes:
- Spot personalization service:
  - Read (user-facing):
    - `/spot-view/{id}`
    - `/spot-view`
    - `/my/spots`
  - Write:
    - `/spot/{id}/personalization`
    - `/spot/{id}/personalization/{command}`

- Spot service:
  - Read:
    - `/spot/{id}`
    - `/spots`
    - `/spots/public`
    - `/spots/by-ids`
  - Write:
    - `/spot`
    - `/spot/{id}/publish`

- Spot metadata service:
  - Read:
    - `/spot-metadata/by-spot/{spotId}`
    - `/spot-metadata/by-spot`
  - Write:
    - `/spot-metadata`
    - `/spot-metadata/{command}`
