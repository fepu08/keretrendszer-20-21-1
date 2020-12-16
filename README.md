# keretrendszer-20-21-1
Keretrendszer alapú programozás c. tárgyhoz

# A félév menete
- Architektúrák, Build Toolok
- XML, XSD, DTO, JSON
- Modellezés, Alap struktúra, Logolás
- Hibernate
- Service, Logolás, Fájl alapú adattárolás
- Spring Framework
- Web modul, alkalmazás szerver
- Spring MVC
- REST API
- Kivételkezelés
- Kód


# Beadandó feladat leírása
A beadandó témája szabadon választott.
Készítsen egy több modulos Maven alkalmazást.
Legyen core, service, dao, controller és web moduljai.
Valamilyen model osztály, melynek legyen LocalDate, enum, string és int/double adattagja. Az adattagok egy része legyen leszabályozva, ezeknek készítsen külön Exception osztályt.
Készítsen DAO modult valamilyen adatforrásból, amely a CRUD műveletet biztosítja.
Térjen ki az azonosító alapján történő lekérdezésre is.
Készítsen egy Service modult, amely a DAO híváson kívül rendelkezzen egyéb funcionalitással (például a megadott Gyártó termékeit adja vissza).
A Service tudjon olyan kivételt dobni a használójának, ami a nincs ilyen objektum az adatbázisban, és ez az objektum már szerepel az adatbázisban (értelemszerűen a saját példánk alapján elnevezve).

Készítsen szervleteket az adott funkciók http protokollon keresztüli elérésére.
Legyen lehetőség tehát kilistázni az objektumokat, egyet visszaadni azonosító alapján, amely dobjon kivételt ha ilyen azonosító nem létezik.
Továbbá lehessen Post kérés segítségével objektumot felvinni, amelynek az esetleges hibáit küldje vissza a használónak.
Lehessen valamilyen szűrő feltétel alapján kilistázni az objektumokat (két dátum közötti, adott érték alapján (pl gyártó, márka, fajta, stb)).

Kezelje le a keletkező kivételeket, kezelje le azt is, amikor nem megengedett metódussal akarjuk meghívni a szervletet, illetve amikor a tartalom tipusa nem megfelelő.

A kivételek indokolt esetben tartalmazzák az adatot (pl. adott mintára nem illeszkedik rá : xy, a kért adat nem található ezzel az azonosítóval :123456).

A feladatot githubon, vagy zipelt állományként lehet leadni.
