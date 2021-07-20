# news project
news project is an Android Application.

## Domain Model

```
@startuml

package externals* #ffcccc {
    package org.threetenbp {

        class ZoneDateTime {
            ...
        }
    }

    package net.openhft.hashing {

        class LongHashFunction {
            ...
        }
    }
    package com.github.javafaker {
        class Faker {
            ...
       } 
    }
   
  

}
package cl.ucn.disc.dsm.pjopia { 


    package model #ccffcc {
        class News <<entity>> {
            - id: Long
            - title: String
            - Source: String
            - Author: String
            - url: String
            - urlImage: String
            - description: String
            - content: String
            + News(...)
            + getId(): String
            + getTitle(): String
            + getSource(): String
            + getAuthor(): String
            + getUrl(): String
            + getUrlImage(): String
            + getDescription(): String
            + getContent(): String

         
        } 
        News *--> "1" ZoneDateTime: - publishedAt 
        News ..> LongHashFunction: }<<use>>
    }
    package services #ccccff {

        interface Contracts <<interface>> {
            +retrieveNews(size: Integer): List<News>
            +save(news: News): Void
        }   
        Contracts ..> News: <<use>>

        class ContractsImplFaker { 
            -ListNews: List<News>
        }
        ContractsImplFaker ..> Contracts
        ContractsImplFaker ..> Faker: <<use>>

@enduml
```




## License
[MIT](https://choosealicense.com/licenses/mit/)