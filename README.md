# assignment

Tools Required 
Jdk 17 , Mysql , any IDE (Inteiij,STS), Postman for testing apis
While running the application some change have tobe done in (.property) file we have to give username and password for the database connection


1> Created Monolithic Project using Springboot in Which i am having a controller where i have created 2 apis which will give monthyly sales and bonuspoints and another will give 3 month data and in this We can also see Customerwise data Also By send sending CustomerId in parameters  

GET (http://localhost:8080/api/transaction/get-all) this api will return all the consolidated data present in db and we can also see data customerwise also by sending id in param (http://localhost:8080/api/transaction/get-all?cid={cusomerId})

GET (http://localhost:8080/api/transaction/get-monthly) this api will return 3 Month of consolidated data present in db and we can also see data customerwise also by sending id in param (http://localhost:8080/api/transaction/get-monthly?cid={cusomerId})

2> Used mysql DataBase for storing data. Created 3 tables (order,orderitems,customer) the Schema and Tables will be created automatically  when the application will be started

3> Used Native Query,JPQL And jPA Projection for creatng response and fetching data from DB
