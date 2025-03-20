# Use a specific MongoDB version (avoid latest for stability)
FROM mongo:6.0

# Metadata for better documentation
LABEL maintainer="Ashok Tippaluri"

# Set environment variables for database and authentication
ENV MONGO_INITDB_ROOT_USERNAME=admin \
    MONGO_INITDB_ROOT_PASSWORD=secret \
    MONGO_INITDB_DATABASE=mydb
# Copy initialization script
COPY init.js /docker-entrypoint-initdb.d/

RUN useradd -r mongodbuser && chown -R mongodbuser /data/db
USER mongodbuser

# Expose MongoDB port
EXPOSE 27017

# Healthcheck to ensure MongoDB is running
HEALTHCHECK --interval=30s --timeout=5s --start-period=10s --retries=3 \
    CMD mongosh --quiet --eval "db.adminCommand('ping')" || exit 1
