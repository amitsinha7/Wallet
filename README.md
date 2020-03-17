"# Wallet API" 
To Run Follow Below Steps :
docker build ./ -t wallet
docker-compose up
docker cp init.sql postgres:/docker-entrypoint-initdb.d/init.sql
docker exec -u postgres postgres psql postgres postgres -f /docker-entrypoint-initdb.d/init.sql
