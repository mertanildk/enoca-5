SDK : coretto 17
Language : coretto 17


Terminalde;
docker run --name basic-postgres --rm -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=mysecretpassword 
-e PGDATA=/var/lib/postgresql/data/pgdata -v /tmp:/var/lib/postgresql/data -p 5430:5432 -it postgres:14.1-alpine

enoca adında bir database açın ve public schema var mı kontrol edinin. Yoksa oluşturunuz.

Komutunu çalıştırın.

Application properties -> spring.jpa.hibernate.ddl-auto=create yazın.
Code first yaklaşımı ile tablolar oluşturulacaktır.

Daha sonrasında projeyi kaldırın.

http://localhost:8095/swagger-ui.html linkinden en-pointlere erişebilirsiniz.



