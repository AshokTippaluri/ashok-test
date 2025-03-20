# Use official Node.js 16 image
FROM node:16

ENV NODE_ENV=production

LABEL maintainer="Ashok Tippaluri"  
# Set working directory inside the container
WORKDIR /app

RUN useradd -r nodeuser && chown -R nodeuser /app


USER nodeuser

# Copy package.json and install dependencies
COPY package.json ./
RUN npm install
# Copy the application code
COPY . .
# Expose port 8080 for the web server
EXPOSE 8080

HEALTHCHECK CMD curl --fail http://localhost:8080/serverStatus || exit 1

# Start the application
CMD ["node", "index.js"]

