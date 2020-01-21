# poc2-customer-api

## use existing docker image

`docker pull caltuntas/poc2-customer-api`


## build your own docker image
`docker image build -t poc2-customer-api .`

## ENV

following environment variables should be passed to docker container

`MONGODB_HOST
MONGODB_PORT
MONGODB_DATABASE
MONGODB_AUTHDB
MONGODB_USERNAME
MONGODB_PASSWORD
LOGSTASH_HOST`