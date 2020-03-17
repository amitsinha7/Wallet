"# Wallet API" 
To Run Follow Below Steps : 

Download the Zip and extract the wallet

At wallet folder*(Extarcted Folder) run CMD 

mvn clean install

docker build ./ -t wallet

docker-compose up

After Application Is Up Please open a new Terminal At wallet folder*(Extarcted Folder) run CMD :

docker cp init.sql postgres:/docker-entrypoint-initdb.d/init.sql

docker exec -u postgres postgres psql postgres postgres -f /docker-entrypoint-initdb.d/init.sql

Added Wallet.postman_collection.json for testing through postman At wallet folder*(Extarcted Folder) run CMD 
