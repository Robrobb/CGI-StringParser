 __      __                .____________                      __                
/  \    /  \___________  __| _/\_   ___ \  ____  __ __  _____/  |_  ___________ 
\   \/\/   /  _ \_  __ \/ __ | /    \  \/ /  _ \|  |  \/    \   __\/ __ \_  __ \
 \        (  <_> )  | \/ /_/ | \     \___(  <_> )  |  /   |  \  | \  ___/|  | \/
  \__/\  / \____/|__|  \____ |  \______  /\____/|____/|___|  /__|  \___  >__|   
       \/                   \/         \/                  \/          \/       

Webbklienten är byggd i Visualstudio code med React,Backenden är byggd i java spring med intelliJ
webbklienten ska öppnas i port 3000, java använder port 8081, om webbklienten använder annan port kan den blockeras av CORS i java klienten
Endpointen för att dela upp en text är http://localhost:8081/parser och har testats i Postman och i webbklienten


1.Klona repot via länken "https://github.com/Robrobb/CGI-StringParser.git"
2.Öppna client folder `cd client` och starta klienten med `npm install` och `npm run start`
3.Öppna server folder, bygg projectet med `maven clean install` och gå in i target mappen och skriv sedan `java -jar -StringParser-1.0.jar`
4.Då kan du öppna webbklienten på http://localhost:3000 och testa programmet




