 __      __                .____________                      __                
/  \    /  \___________  __| _/\_   ___ \  ____  __ __  _____/  |_  ___________ 
\   \/\/   /  _ \_  __ \/ __ | /    \  \/ /  _ \|  |  \/    \   __\/ __ \_  __ \
 \        (  <_> )  | \/ /_/ | \     \___(  <_> )  |  /   |  \  | \  ___/|  | \/
  \__/\  / \____/|__|  \____ |  \______  /\____/|____/|___|  /__|  \___  >__|   
       \/                   \/         \/                  \/          \/       

Webbklienten är byggd i Visualstudio code med React,Backenden är byggd i java spring med intelliJ
webbklienten ska öppnas i port 3000, java använder port 8080, om webbklienten använder annan port kan den blockeras av CORS i java klienten
Endpointen för att dela upp en text är http://localhost:8080/parser och har testats i Postman och i webbklienten


1.hämta java klienten via github länken "https://github.com/Robrobb/Hemtest-Cgi.git" 
2.Kör klienten via intellJ,alternativt finns det en fungerande jar fil som kan startas via terminalen "Hemtest\targetjava -jar demo.jar"
3.för att köra webbklienten,Öppna mappen websitex i visualstudiocode och kör commandot i node terminalen "npm start"
