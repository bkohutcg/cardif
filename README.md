# **Subscriptions service**

runs on **localhost:8080**

_**ENDPOINTS:**_

- **GET** `/subscription/{id}`
finds one subscription based on given database ID
------
- **POST** `/subscrption/create`
creates new subscription in database with given attributes
- request: 
`{
  "startDate": LocalDate eg. 2023-03-14,
  "validUntil": LocalDate eg. 2023-03-14,
  "quotation": {
  "beginingOfInsurance": LocalDate eg. 2023-03-14,
  "insuredAmount": Bigdecimal,
  "dateOfSigningMortgage": LocalDate eg. 2023-03-14,
  "customer": {
  "firstName": String,
  "lastName": String,
  "middleName": String,
  "email": String,
  "phoneNumber": String,
  "birthDate": LocalDate eg. 2023-03-14
  }}}`
-------
- **POST** `/quotation/create`
creates new quotation object in database with given attributes
- request:
`{
  "beginingOfInsurance": LocalDate eg. 2023-03-14,
  "insuredAmount": Bigdecimal,
  "dateOfSigningMortgage": LocalDate eg. 2023-03-14,
  "customer": {
  "firstName": String,
  "lastName": String,
  "middleName": String,
  "email": String,
  "phoneNumber": String,
  "birthDate": LocalDate eg. 2023-03-14
  }}`
---
- **GET** `/customer/{id}`
finds one customer in database based on given ID
---
- **POST** `/customer/create`
creates new customer object in database with given attributes
- request:
`{
  "firstName": String,
  "lastName": String,
  "middleName": String,
  "email": String,
  "phoneNumber": String,
  "birthDate": LocalDate eg. 2023-03-14
  }`
---
- **PUT** `/customer/{id}/update`
updates customer with provided ID with given attributes
- request: (any or all can be null)
  `{
  "firstName": String,
  "lastName": String,
  "middleName": String,
  "email": String,
  "phoneNumber": String,
  "birthDate": LocalDate eg. 2023-03-14
  }`