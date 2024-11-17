FROM postgres:13-alpine
COPY init.sql /docker-entrypoint-initdb.d/
LABEL authors="miche"

ENTRYPOINT ["top", "-b"]