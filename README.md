# _Rose City Flower_

#### _Web Application for reviewing marijuana in the Portland area, 03-28-2017_

#### By _**Ryan Jones**_

## Description
_Rose City Flower, is a marijuana review site that allows users to review marijuana sold around the Portland area._


## User Stories
* _As a user, I can see a list of strains_
* _As a user, I can see individual details about specific strains_
* _As a user, I can write a review about a strain_
* _As a user, I can see other peoples reviews of specific strains_


## Specifications

| Behavior                   | Input Example     | Output Example    |
| -------------------------- | -----------------:| -----------------:|
| User adds a strain (Boss OG) | Save method is called | Strain instance is saved in the database |
| User writes a review | Save method is called | Review is saved in database |
| User clicks on a classification (Sativa, Hybrid, Indica) | All method is called | List of strains belonging to that classification is returned |
| User clicks individual strain | Find method is called | Specific strain is returned |



## Setup/Installation Requirements

* _Clone the repository_
* _Run the command 'gradle run'_
* _Open browser and go to localhost:4567_


### License

Copyright (c) 2017 **_Ryan Jones_**

This software is licensed under the MIT license.
