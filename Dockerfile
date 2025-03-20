# Use official Node.js 16 image
FROM node:16
# Set working directory inside the container
WORKDIR /app
# Copy package.json and install dependencies
COPY package.json ./
RUN npm install
# Copy the application code
COPY . .
# Expose port 8080 for the web server
EXPOSE 8080
# Start the application
CMD ["node", "index.js"]

