
rootProject.name = "demo-hexagonal"

include(
    "core:demo-core",
    "core:demo-reactive-core",
    "infrastructure:datastore-mariadb",
    "infrastructure:datastore-mongodb-reactive",
    "infrastructure:datastore-mariadb-reactive",
    "server:demo-app",
    "server:demo-reactive-app",
    "util:common-util",
    "server:demo-all-in-one-app"
)