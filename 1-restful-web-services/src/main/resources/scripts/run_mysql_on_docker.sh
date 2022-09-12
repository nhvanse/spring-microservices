docker run --detach \
--env MYSQL_ROOT_PASSWORD=root \
--env MYSQL_USER=van \
--env MYSQL_PASSWORD=12345678 \
--env MYSQL_DATABASE=social-media-database \
--name mysql \
--publish 3306:3306 \
mysql:5.7