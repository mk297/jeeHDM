Preface
=======

- Do never push to the *master* branch!
- Use always a *feature* branch for pushing changes and create a pull request.

Instructions for installing and using the project
=================================================

- Pull the repo
- Update the Maven Project
- Peform a toplevel clean if any errors persist
- Peform a maven install

Übung 1 - JSF
=============


JAX-RS
===

  Übung 1
- Um neue Kinobesucher anlegen zu können, soll die "POST"-Methode createPerson() realisiert werden. 
  Diese soll auf den relativen Pfad /booking/createPerson gemapped werden.
- Als Parameter soll der Vorname "preName" und Nachname "surName" (String) als Form-Parameter übergeben werden. 
- Als Response soll eine Erfolgsmeldung der gerade angelegten Person an den Client zurückgegeben werden. 
	
	
	
  Übung 2
- Um einen Platz zu reservieren, soll die "POST"-Methode bookSeat() realisiert werden. 
  Diese soll auf den root gemapped werden.
- Als Parameter soll die Sitznummer "seat" und "row" (Integer) als Form-Parameter übergeben werden.
- Des Weiteren soll eine "personID" (Integer) benötigt, damit Tickets einer Person zugeordnet werden kann.
- Als Response soll eine Erfolgsmeldung des gerade reservierten Tickets an den Client zurückgegeben werden.  
	

JPA
===
  Übung 1
- Lege eine Methode an, die versucht bei einer Transaktion ein Objekt aus der Datenbank zu löschen.
  Falls dies fehlschlägt, soll sie die Änderungen rückgängig machen und einen angemessenen Fehler schmeißen. 
  Der Rückgabewert ist ein Boolean, der angibt, ob die Transaktion geglückt oder gescheitert ist.
- Erstelle eine Methode, die eine Klasse anhand ihres Composite-PrimaryKeys in einer Tabelle findet.
  Falls dies fehlschlägt, soll eine Fehlermeldung zurückgegeben werden.

  Übung 2
- Annotiere die Klasse Person als Entität.
- Erstelle eine ID-Variable, die du als Primary Key definierst und die automatisch inkrementiert wird.
- Erstelle je eine Variable, die den Vor- bzw. den Nachnamen der Person hält
  und lege einen Konstruktor an, der Vor- und Nachname als Parameter entgegennimmt.
- Lege eine OneToMany Relation zu einer Ticketliste an.
- Erstelle alle benötigten Getter und Setter.