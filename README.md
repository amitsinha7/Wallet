"# Wallet API" 
To Run Follow Below Steps :
Inside wallet folder run CMD

mvn clean install

docker build ./ -t wallet

docker-compose up

After Application Is Up Please open a new Terminal or CMD on same path as above and run below commands:

docker cp init.sql postgres:/docker-entrypoint-initdb.d/init.sql

docker exec -u postgres postgres psql postgres postgres -f /docker-entrypoint-initdb.d/init.sql

Added Wallet.postman_collection.json for testing through postman @ same folder
