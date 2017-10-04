# DAT250-auction
Java EE Auction web application, a part of the course DAT250 (Advanced Software Technologies) at Western Norway University of Applied Sciences ([HVL](https://www.hvl.no/))

## Functionality
* Creating auctions
* Managing auctions
* Biding on auctions
* Secure communication with TLS
* Authentication/login

## Users
There is only one type of user (role) in the project as per now;
AuctionUser

Create users with the guide in [Login](#Login)

## Setup and installation
Start Glassfish-server version >= 4.1.2  
Add the file glassfish-resources to the webserver:

```./asadmin add-resources .../DAT250-auction/web/WEB-INF/glassfish-resources.xml```

Build the project in NetBeans, and deploy to server.
The project is then accessable at the adress:
[localhost:8181/DAT250-auction/](https://localhost:8181/DAT250-auction/)

### Login
The login is configured to use the security-realm 'file' in the Glassfish-server.
From the Glassfish control-panel  
**Configurations -> server-config -> security** enable *Default Principal To Role Mapping*.  
**Configurations -> server-config -> security -> Realms -> file** press *manage users*.   Add a user (ie. admin) and place it in the 'Grup list' **AuctionUser**



## Authors
The project is created by [Jostein Kringlen](https://github.com/JosteinKringlen), [Kristian Rosland](https://github.com/Kristianrosland), [André Dyrstad](https://github.com/AndreDyrstad) and [Didrik Sæther](https://github.com/diddern).
