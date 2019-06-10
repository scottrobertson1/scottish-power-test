# scottish-power-test
sample scenario put together for scottish power technical test

#local testing
navigate to Application.java and run

hit http://localhost:8080/account/

include account details in body of request e.g

{
    "id": 2,
    "elec_id": 23332434,
    "gas_id": 8312345,
    "elec_smart_read": "1923892993",
  "gas_smart_read":"0912309992" 
}
