
# Robin Hemmingsson hemtest CGI
```
🆆🅾🆁🅳🅲🅾🆄🅽🆃🅴🆁
```


### Beskrivning
För att underlätta genomgång av hemtestet så har jag gjort en monorepo med foldrarna client och server. Foldern server innehåller APIet som specificerat i hemtestet. I foldern client har jag även gjort en enklare webbklient som fungerar med APIet.

#### Klient
React, TypeScript & Bootstrap

#### Server
Java 8
Java Spring

### Användings Instruktioner
1.Klona repot `git clone https://github.com/Robrobb/CGI-StringParser.git`

2.Öppna client folder `cd client` och starta klienten med `npm 
install` och `npm run start`

3.Öppna server folder, bygg projectet med `mvn clean install` och gå in i target mappen och skriv sedan `java -jar StringParser-1.0.jar` för att köra servern

4.Sen kan du öppna webbklienten på http://localhost:3000 och testa programmet

## Postman

Det följer också med en Postman collection i CGI mappen,som innehåller tester som kan köras i Postman
`


