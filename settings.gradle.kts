
rootProject.name = "demo-hexagonal"

include(
    "core:demo-core",
    "infrastructure:datastore-mariadb",
    "infrastructure:datastore-mongodb-reactive",
    "server:demo-app",
    "util:common-util",
    "server:demo-all-in-one-app"
)
include("server:demo-reactive-app")
findProject(":server:demo-reactive-app")?.name = "demo-reactive-app"
include("core:demo-reactive-core")
findProject(":core:demo-reactive-core")?.name = "demo-reactive-core"
