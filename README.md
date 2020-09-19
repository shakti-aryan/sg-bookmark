# sg-bookmark
SG Hackathon

## About
This application provides solution for maintaining bookmarks. Get the shorten handy url for your important urls, club many items together and reach out to those whenver needed with a simple small url.

Give it a short by Navigating to

    http://sg-bookmark.appspot.com/swagger-ui.html

### Architecture

    (https://github.com/shakti-aryan/sg-bookmark/blob/master/arch/arch.png)

#### Request Flow

    (https://github.com/shakti-aryan/sg-bookmark/blob/master/arch/reqFlow.png)

#### Shortning Flow
    (https://github.com/shakti-aryan/sg-bookmark/blob/master/arch/shortningFlow.png)

#### Entity Relationship
    (https://github.com/shakti-aryan/sg-bookmark/blob/master/arch/DB Schema.jpg)


### Tech Stack
 * Spring Boot
 * Spring Security
 * Postgres
 * Google Cloud Platform
 * Google Compute Engine (to host DB)
 * Google Cloud Build to configure CICD
 * Slf logger

    This application is hosted on Google Cloud Service, with consumption of several Google provided services

#### WorkFlow Mindmap

    (https://atlas.mindmup.com/aryanshakti/free_mind_map/index.html)

### How To Run

##### Cloning the repository

    git clone https://github.com/shakti-aryan/sg-bookmark.git
    cd sg-bookmark
##### Install the Dependency

    mvn clean install

##### Running the application
    mvn appengine:run

* This application uses Google app engine dependency to run, user has to configure the google cloud account details asked while executing above command

##### Running as Spring Boot App
**To avoid Google Dependency**
    Comment out the **Exclusion of Tomcat dependency** mentioned in POM, and Run the application as normal Spring Boot application. :)

##### Accessing the App
    (http://localhost:8080/swagger-ui.html)

##### Deploy the App
    mvn appengine:deploy

    **CICD**
    Continuous Integration has been configured with master branch with Google Cloud Build Trigger pipeline.
    To Track (https://console.cloud.google.com/cloud-build/builds?project=sg-bookmark)

##### Project Status & Monitoring overview

    (https://console.cloud.google.com/home/dashboard?project=sg-bookmark)
