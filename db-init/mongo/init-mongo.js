db.createUser({
    user: "admin",
    pwd: "password",
    roles: [
        {
            role: "readWrite",
            db: "db"
        }
    ]
});

db = db.getSiblingDB('db');

db.testtable.insertMany([
    { name: "mati", weather: "sunny"},
    { name: "mati2", weather: "cloudy"},
]);