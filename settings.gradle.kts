
rootProject.name = "demo-hexagonal"
include("core:demo-core")
findProject(":core:demo-core")?.name = "demo-core"
include("infrastructure:datastore-mariadb")
findProject(":infrastructure:datastore-mariadb")?.name = "datastore-mariadb"
include("server")
include("server:demo-app")
findProject(":server:demo-app")?.name = "demo-app"
include("util:common-util")
findProject(":util:common-util")?.name = "common-util"
include("server:demo-all-in-one-app")
findProject(":server:demo-all-in-one-app")?.name = "demo-all-in-one-app"
