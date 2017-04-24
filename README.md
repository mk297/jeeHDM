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


Übung 2 - JAX-RS
================


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