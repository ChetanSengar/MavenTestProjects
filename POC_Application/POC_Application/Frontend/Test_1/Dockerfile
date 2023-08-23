FROM nginx:1.25.0-alpine
WORKDIR /app
COPY ./dist/test-1 /usr/share/nginx/html/test-1
COPY default.conf /etc/nginx/conf.d/default.conf
EXPOSE 8081