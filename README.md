# Dmoney_API_RestAssured

## Technology used:
- Java
- Intellij idea
- Allure

## Framework used:
- Rest Assured
- TestNG

## Scenario
1. Do Login by admin
2. Create 2 new customers and a agent
3. Give 2000 tk from System account to the newly created agent
4. Deposit 1500 tk to a customer from the agent account
5. Withdraw 500 tk by the customer to the agent
6. Send money 500 tk to another customer
7. Payment 100 tk to a merchant (01686606905) by the recipient customer
8. Check balance of the recipient customer

## How to run this project
- Clone this project
- To run hit this following command ```gradle clean test```
- To generate allure report hit these command  
```allure generate allure-results --clean -output```  
```allure serve allure-results```

## Allure Report
![rest_assured_overview](https://github.com/fariha28345/Dmoney_API_RestAssured/assets/50767962/917809b3-099b-4e5e-af04-d3865d42343a)
![rest_assured_behaviors](https://github.com/fariha28345/Dmoney_API_RestAssured/assets/50767962/32ccb315-3442-46cf-86da-36e60ce06bcc)
