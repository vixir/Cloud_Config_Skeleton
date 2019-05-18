# Cloud Config Skeleton
Spring Cloud Config Server with Git

__Spring Cloud Config__ : Spring cloud config is a git or file backed configuration server. It serves as configuration server for java Spring app or any other app that can consume it over HTTP

Config Repo : https://github.com/vixir/spring-cloud-config-skeleton

Pass URI in config server from application.yml to be consumed by spring boot app.
For example :
```yaml
spring:
  cloud:
    config:
      server:
        git:
          uri: https://github.com/vixir/spring-cloud-config-skeleton
          search-paths:
            - 'tollRates*'
```

Config repo contains TollRates Details. 
Contains two folders one for Wakanda config and one for Titan config and also default a default application properties.
```markdown
- tollRatesTitan
    - tollRatesT-dev.properties
    - tollRatesT-qa.properties
    - tollRatesT.properties
- tollRatesWakanda
    - tollRatesW-dev.properties
    - tollRatesW.properties
- application.properties
```

Start the Config Server :
Run the application main class CloudConfigSkeletonApplication.

Testing the properties :
These urls are just gor testing the config server. Actual application will consume these configs in a different way.
Can test using any REST API testing tool like postman or just use your browser.

- http://localhost:8889/tollRates/development
This will use default application.properties since the we have not specified any properties for "development" profile.
```json
    [   "propertySources": [
        {
            "name": "https://github.com/vixir/spring-cloud-config-skeleton/application.properties",
            "source": {
                "rate": "1.55",
                "tollstart": "05:00",
                "tollstop": "22:00",
                "lanecount": "0"
            }
        }
    ]
```
- http://localhost:8889/tollRatesT/dev

Since we have a dev profile setup. It will pick up properties from application.properties, tollRatesT.properties and tollRatesT-dev.properties.
```json
"propertySources": [
        {
            "name": "https://github.com/vixir/spring-cloud-config-skeleton/tollRatesTitan/tollRatesT-dev.properties",
            "source": {
                "tollstart": "05:00",
                "tollstop": "22:00",
                "lanecount": "3",
                "environment": "development"
            }
        },
        {
            "name": "https://github.com/vixir/spring-cloud-config-skeleton/tollRatesTitan/tollRatesT.properties",
            "source": {
                "rate": "1.91",
                "tollstart": "05:00",
                "tollstop": "22:00",
                "lanecount": "0"
            }
        },
        {
            "name": "https://github.com/vixir/spring-cloud-config-skeleton/application.properties",
            "source": {
                "rate": "1.55",
                "tollstart": "05:00",
                "tollstop": "22:00",
                "lanecount": "0"
            }
        }
    ]
```



 