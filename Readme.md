## Spring-boot SOLID DiP principle

This project shows how to comply with the SOLID [DiP](https://en.wikipedia.org/wiki/Dependency_inversion_principle)
principle using a messaging system as an example

###Goal: 
To be able to change the kafka-provider with another provider, like reddis.

###kafka-provider
This is a provider specific implementation for retrieving messages from an Apache Kafka Topic.
It is allowed to include provider specific libraries.

###message-processor
This is an abstraction layer that receives raw Apache Kafka messages and can perform
business logic to transform the messages in any way needed.

###messages
This is the HIGH level application that uses the transformed messages to satisfy its business purpose.



| Module      | Depends On |
| ----------- | ----------- |
| kafka-provider      | Apache Kafka       |
| message-processor    | kafka-provider        |
| messages  | message-processor |
 
