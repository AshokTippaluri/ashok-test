FROM mongo:latest
# Set up a default database
ENV MONGO_INITDB_DATABASE=mydb
# Copy initialization script
COPY init.js /docker-entrypoint-initdb.d/
# Expose MongoDB port
EXPOSE 27017

