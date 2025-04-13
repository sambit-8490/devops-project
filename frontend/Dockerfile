FROM node:18 AS nodejs

WORKDIR /app

# Copy package.json and install dependencies
COPY package*.json ./

RUN npm install

# Copy the rest of the application files
COPY . .

# Build the production-ready app (Vite build command)
RUN npm run build

FROM nginx:alpine

# Copy the build folder to the Nginx server
COPY --from=nodejs /app/dist /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
